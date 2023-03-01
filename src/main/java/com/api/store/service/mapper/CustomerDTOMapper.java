package com.api.store.service.mapper;

import com.api.store.model.Customer;
import com.api.store.model.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()!=null?customer.getAddress().getCountry():"",
                customer.getAddress()!=null?customer.getAddress().getCity():""
        );
    }
}
