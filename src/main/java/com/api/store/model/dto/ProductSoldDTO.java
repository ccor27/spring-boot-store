package com.api.store.model.dto;

public record ProductSoldDTO(
        Long id,
        String name,
        String barCode,
        Integer amount,
        Double totalPrice
) {
}
