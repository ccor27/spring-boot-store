package com.api.store.service;

import com.api.store.model.Address;
import com.api.store.model.dto.AddressDTO;
import com.api.store.model.dto.AddressRegistrationRequest;
import com.api.store.model.dto.AddressUpdateRequest;
import com.api.store.repository.AddressRepository;
import com.api.store.service.mapper.AddressDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp implements IAddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressDTOMapper addressDTOMapper;
    @Override
    public AddressDTO save(AddressRegistrationRequest addressRegistrationRequest) {
        Address address = new Address(
                addressRegistrationRequest.street(),
                addressRegistrationRequest.country(),
                addressRegistrationRequest.zip_code(),
                addressRegistrationRequest.city(),
                addressRegistrationRequest.state()
        );
        addressRepository.save(address);
        return addressDTOMapper.apply(address);
    }

    @Override
    public AddressDTO findById(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if(address!=null){
            return addressDTOMapper.apply(address);
        }else{
            return null;
        }
    }

    @Override
    public AddressDTO updateData(AddressUpdateRequest addressUpdateRequest) {
        Address address = addressRepository.findById(addressUpdateRequest.id()).orElse(null);
        if(address!=null){
           address.setId(addressUpdateRequest.id());
           address.setState(addressUpdateRequest.street());
           address.setZip_code(addressUpdateRequest.zip_code());
           address.setCity(addressUpdateRequest.city());
           address.setState(addressUpdateRequest.state());
           addressRepository.save(address);
           return addressDTOMapper.apply(address);
        }else {
            return null;
        }
    }

    @Override
    public Set<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(address -> {
            return addressDTOMapper.apply(address);
        }).collect(Collectors.toSet());
    }
}
