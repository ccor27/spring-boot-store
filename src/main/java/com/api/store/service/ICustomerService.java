package com.api.store.service;

import com.api.store.model.Customer;
import com.api.store.model.dto.*;

import java.util.Set;


public interface ICustomerService {

    public CustomerAuthenticateResponse register(CustomerRegistrationRequest customerRegistrationRequest);
    public CustomerAuthenticateResponse authenticate(CustomerAuthentication customerAuthentication);
    public CustomerDTO findById(Long id);
    public CustomerDTO updateInfo(CustomerUpdateRequest customerUpdateRequest);
    public Set<CustomerDTO> findAll();
    public Customer findCustomerById(Long id);
    public CustomerDTO addRecord(RecordDTO record, Long id);
    public RecordDTO findRecordCustomer(Long id);
    public boolean addSaleInRecord(SaleDTO saleDTO,Long id);
    public boolean deleteSaleInRecord(SaleDTO saleDTO, Long id);
    public CustomerDTO addAddress(AddressRegistrationRequest addressRegistrationRequest, Long id);
    public CustomerDTO removeAddress(AddressDTO addressDTO, Long id);
    public AddressDTO findAddressCustomer(Long id);

}

