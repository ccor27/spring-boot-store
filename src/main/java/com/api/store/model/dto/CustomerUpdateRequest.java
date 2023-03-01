package com.api.store.model.dto;

public record CustomerUpdateRequest(
        Long id,
        String name,
        String lastName,
        String email,
        String phone
) {
}
