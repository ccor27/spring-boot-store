package com.api.store.model.dto;

public record ProductUpdateRequest(
        Long id,
        String name,
        String description,
        Double price,
        Integer amount
) {
}
