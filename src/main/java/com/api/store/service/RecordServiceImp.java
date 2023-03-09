package com.api.store.service;

import com.api.store.model.Customer;
import com.api.store.model.Record;
import com.api.store.model.Sale;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;
import com.api.store.model.dto.SaleDTO;
import com.api.store.repository.RecordRepository;
import com.api.store.service.mapper.RecordDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecordServiceImp implements IRecordService{

    private final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private ISaleService iSaleService;
    @Autowired
    private RecordDTOMapper recordDTOMapper;
    @Autowired
    private ICustomerService iCustomerService;

    @Override
    public RecordDTO save(RecordRegistrationRequest recordRegistrationRequest) {

        Customer customer = null;
        RecordDTO recordDTO = null;
        Record record = null;

        if(recordRegistrationRequest.customerDTO()!=null)
            customer = findCustomer(recordRegistrationRequest.customerDTO().id());

        if(customer!=null){
            record = new Record(customer,convertList(recordRegistrationRequest.saleDTOS()));
        }else{
            record = new Record(convertList(recordRegistrationRequest.saleDTOS()));
        }

        recordRepository.save(record);
        recordDTO = recordDTOMapper.apply(record);

        if(customer!=null && customer.getRecord()==null) {
            iCustomerService.addRecord(recordDTO, customer.getId());
            LOGGER.info("RECORD: record saved successfully: "+recordDTO.id());
            return recordDTO;
        }else{
            LOGGER.error("RECORD: the customer already has a record, therefore is not possible add this record to the customer");
            return null;
        }

    }

    @Override
    public RecordDTO findById(Long id) {
        Record record = recordRepository.findById(id).orElse(null);
        if(record!=null) {
            LOGGER.info("RECORD: record found successfully " + record.getId());
            return recordDTOMapper.apply(record);
        }
        LOGGER.error("RECORD: record with the id: "+id+" doesn't exist");
        return null;
    }

    @Override
    public Record findRecordById(Long id) {
        return recordRepository.findById(id).isPresent() ? recordRepository.findById(id).get() : null;
    }

    @Override
    public Set<RecordDTO> findAll() {
       if(!recordRepository.findAll().isEmpty() ||recordRepository.findAll()!=null){
           LOGGER.info("RECORD: records found successfully");
           return recordRepository.findAll().stream().map(record -> {
               return recordDTOMapper.apply(record);
           }).collect(Collectors.toSet());
       }
        LOGGER.error("RECORD: there aren't records");
        return null;
    }

    @Override
    public boolean addSale(SaleDTO saleDTO, Long id) {
        Record record = recordRepository.findById(id).orElse(null);
        if(record==null){
            LOGGER.error("RECORD: the record doesn't exist, therefore is not possible add the sale in it");
            return false;
        }else {
            Sale sale = iSaleService.findSaleById(saleDTO.id());
            if(sale==null){
                LOGGER.error("RECORD: the sale doesn't exist, therefore is not possible add it in the record");
                return false;
            }else{

             if(!saleIsAlreadyInAnotherRecord(sale)){
                 record.addSale(sale);
                 recordRepository.saveAndFlush(record);
                 LOGGER.info("RECORD: added sale successfully");
                 return true;
             }else{
               LOGGER.error("RECORD: The sale is already in another record, therefore is not possible add it in the record");
               return false;
             }
            }
        }

    }

    @Override
    public boolean removeSale(SaleDTO saleDTO, Long id) {
        Record record = recordRepository.findById(id).orElse(null);
        if(record==null){
            LOGGER.error("RECORD: the record doesn't exist, therefore is not possible remove the sale in it");
            return false;
        }else {
            Sale sale = iSaleService.findSaleById(saleDTO.id());
            if(sale==null){
                LOGGER.error("RECORD: the sale doesn't exist, therefore is not possible remove it in the record");
                return false;
            }else{
                record.getSaleSet().remove(sale);
                recordRepository.saveAndFlush(record);
                LOGGER.info("RECORD: removed sale successfully");
                return true;
            }
        }
    }

    @Override
    public RecordDTO addCustomer(Long id, CustomerDTO customerDTO) {
        Record record = recordRepository.findById(id).orElse(null);
        if(record!=null){
            Customer customer = iCustomerService.findCustomerById(customerDTO.id());
            record.setCustomer(customer);
            recordRepository.save(record);
            LOGGER.info("RECORD: customer added successfully in a record");
            return recordDTOMapper.apply(record);
        }
        LOGGER.error("RECORD: the record doesn't exist");
        return null;
    }

    @Override
    public RecordDTO updateRecordAddOrDeleteSale(RecordDTO recordDTO) {
        if(recordDTO!=null){
            Record recordToUpdate = recordRepository.findById(recordDTO.id()).orElse(null);
            if(recordToUpdate!=null){
                recordToUpdate.setId(recordDTO.id());
                recordToUpdate.setSaleSet(convertList(recordDTO.saleDTOS()));
                recordRepository.save(recordToUpdate);
                LOGGER.info("RECORD: record updated successfully "+recordToUpdate.getId());
                return recordDTOMapper.apply(recordToUpdate);
            }else{
                LOGGER.error("RECORD: record doesn't exist");
                return null;
            }
        }else{
            LOGGER.error("RECORD: record doesn't exit");
            return null;
        }
    }

    public Set<Sale> convertList(Set<SaleDTO>sales){
        if(sales.isEmpty() || sales==null){
            LOGGER.error("RECORD: the sales to convert doesn't exist");
            return null;
        }else{
            LOGGER.info("RECORD: salesDTO converted to sale successfully");
          return  sales.stream().map(saleDTO -> {
                return iSaleService.findSaleById(saleDTO.id());
            }).collect(Collectors.toSet());
        }
    }

    private Customer findCustomer(Long id){
        return iCustomerService.findCustomerById(id)!=null ? iCustomerService.findCustomerById(id) : null;
    }

    private boolean saleIsAlreadyInAnotherRecord(Sale sale) {
        boolean exist = false;
        Set<Record> records = (Set<Record>) recordRepository.findAll();
        if(records!=null){
            for ( Record r :records ) {
                if(r.getSaleSet().contains(sale)){
                    exist=true;
                    break;
                }

            }
        }
        return exist;
    }
}
