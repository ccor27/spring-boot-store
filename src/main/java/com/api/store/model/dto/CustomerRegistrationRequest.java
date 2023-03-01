package com.api.store.model.dto;

public record CustomerRegistrationRequest(
        String name,
        String lastName,
        String email,
        String phone,
        String username,
        String pwd,
        AddressRegistrationRequest address
) {
}
