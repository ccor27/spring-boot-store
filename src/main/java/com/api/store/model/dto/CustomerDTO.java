package com.api.store.model.dto;

public record CustomerDTO(
        Long id,
        String name,
        String lastName,
        String email,
        String phone,
        String country,
        String city
) {
}
