package com.api.store.model.dto;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        Integer amount
) {
}
