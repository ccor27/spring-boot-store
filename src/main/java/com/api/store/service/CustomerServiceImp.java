package com.api.store.service;

import com.api.store.model.Address;
import com.api.store.model.Customer;
import com.api.store.model.Record;
import com.api.store.model.Sale;
import com.api.store.model.dto.*;
import com.api.store.repository.CustomerRepository;
import com.api.store.service.mapper.CustomerDTOMapper;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements ICustomerService{

    private static final Logger LOGGER= LoggerFactory.getLogger(SLF4JLogger.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerDTOMapper customerDTOMapper;
    @Autowired
    private ISaleService iSaleService;

    @Override
    public CustomerDTO save(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.lastName(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.phone(),
                customerRegistrationRequest.username(),
                customerRegistrationRequest.pwd(),
                convertAddressRegistrationToAddressDTO(customerRegistrationRequest.address()),
                new HashSet<>()
        );
        customerRepository.save(customer);

        return customerDTOMapper.apply(customer);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer!=null){
            return customerDTOMapper.apply(customer);
        }else{
            return null;
        }
    }

    @Override
    public CustomerDTO update(CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = customerRepository.findById(customerUpdateRequest.id()).orElse(null);
        customer.setId(customerUpdateRequest.id());
        customer.setName(customerUpdateRequest.name());
        customer.setLastName(customerUpdateRequest.lastName());
        customer.setEmail(customerUpdateRequest.email());
        customer.setPhone(customerUpdateRequest.phone());
        customerRepository.save(customer);
        return customerDTOMapper.apply(customer);
    }

    @Override
    public Set<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customer -> {
            return customerDTOMapper.apply(customer);
        }).collect(Collectors.toSet());
    }

    @Override
    public Boolean addRecord(SaleDTO saleDTO, Long id) {
       Customer customer = customerRepository.findById(id).orElse(null);
       if(customer!=null){
           Sale sale = iSaleService.findSaleById(saleDTO.id());
           if (sale!=null){
               customer.getRecord().getSaleSet().add(sale);
               LOGGER.info("record add successfully in the customer: "+id);
               return true;
           }else{
               LOGGER.error("Error during the process to add record to a customer: sale is null");
               return false;
           }

       }else{
          LOGGER.error("Error during the process to add record to a customer: customer is null");
          return false;
       }
    }

    private Address convertAddressRegistrationToAddressDTO(AddressRegistrationRequest addressRegistrationRequest){

        if(addressRegistrationRequest!=null) {
            Address address = new Address(
                    addressRegistrationRequest.street(),
                    addressRegistrationRequest.country(),
                    addressRegistrationRequest.zip_code(),
                    addressRegistrationRequest.city(),
                    addressRegistrationRequest.state()
            );
            return address;
        }
        return null;
    }
}
