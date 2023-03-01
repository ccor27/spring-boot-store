package com.api.store.model.dto;

public record ProductRegistrationRequest(
        String name,
        String description,
        Double price,
        Integer amount,
        String barCode,
        String origin

) {
}
