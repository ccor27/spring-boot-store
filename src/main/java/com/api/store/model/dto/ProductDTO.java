package com.api.store.model.dto;

public record ProductDTO(
        Long id,
        String name,
        String barCode,
        Double price,
        Integer amount
) {
}
