package com.api.store.model.dto;

public record AddressDTO (
        Long id,
        String country,
        String city,
        String state,
        String street
){
}
