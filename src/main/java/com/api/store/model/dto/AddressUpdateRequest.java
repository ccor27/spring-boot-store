package com.api.store.model.dto;

public record AddressUpdateRequest(
        Long id,
        String street,
        String zip_code,
        String city,
        String state
) {
}
