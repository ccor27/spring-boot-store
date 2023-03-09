package com.api.store.service;

import com.api.store.model.Address;
import com.api.store.model.dto.AddressDTO;
import com.api.store.model.dto.AddressRegistrationRequest;
import com.api.store.model.dto.AddressUpdateRequest;

import java.util.Set;

public interface IAddressService {

    public AddressDTO save(AddressRegistrationRequest addressRegistrationRequest);
    public AddressDTO findById(Long id);
    public Address findAddressById(Long id);
    public AddressDTO updateData(AddressUpdateRequest addressUpdateRequest);
    public Set<AddressDTO> findAll();
}
