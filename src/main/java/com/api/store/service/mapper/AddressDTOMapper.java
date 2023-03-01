package com.api.store.service.mapper;

import com.api.store.model.Address;
import com.api.store.model.dto.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class AddressDTOMapper implements Function<Address, AddressDTO> {

    @Override
    public AddressDTO apply(Address address) {

        return new AddressDTO(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getState(),
                address.getStreet()
        );
    }
}
