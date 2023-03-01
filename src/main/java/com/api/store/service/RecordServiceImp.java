package com.api.store.service;

import com.api.store.model.Record;
import com.api.store.model.Sale;
import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;
import com.api.store.model.dto.SaleDTO;
import com.api.store.repository.RecordRepository;
import com.api.store.repository.SaleRepository;
import com.api.store.service.mapper.RecordDTOMapper;
import com.api.store.service.mapper.SaleDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecordServiceImp implements IRecordService{
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private RecordDTOMapper recordDTOMapper;

    @Override
    public RecordDTO save(RecordRegistrationRequest recordRegistrationRequest) {
        Record record = new Record(convertList(recordRegistrationRequest.saleDTOS()));
        recordRepository.save(record);
        return recordDTOMapper.apply(record);
    }

    @Override
    public RecordDTO findById(Long id) {
        Record record = recordRepository.findById(id).orElse(null);
        if(record!=null)
            return recordDTOMapper.apply(record);
        return null;
    }

    @Override
    public Set<RecordDTO> findAll() {
       if(!recordRepository.findAll().isEmpty() ||recordRepository.findAll()!=null){
           return recordRepository.findAll().stream().map(record -> {
               return recordDTOMapper.apply(record);
           }).collect(Collectors.toSet());
       }
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
                return recordDTOMapper.apply(recordToUpdate);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public Set<Sale> convertList(Set<SaleDTO>sales){
        if(sales.isEmpty() || sales==null)
            return null;

        return sales.stream().map(sale -> {
            return saleRepository.findById(sale.id()).orElse(null);
        }).collect(Collectors.toSet());

    }
}
