package com.api.store.service;

import com.api.store.model.dto.*;

import java.util.Set;


public interface ICustomerService {

    public CustomerDTO save(CustomerRegistrationRequest customerRegistrationRequest);
    public CustomerDTO findById(Long id);
    public CustomerDTO update(CustomerUpdateRequest customerUpdateRequest);
    public Set<CustomerDTO> findAll();
    public Boolean addRecord(SaleDTO saleDTO, Long id);
}
