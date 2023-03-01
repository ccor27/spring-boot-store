package com.api.store.model.dto;

public record AddressRegistrationRequest(
        String street,
        String country,
        String zip_code,
        String city,
        String state
) {
}
