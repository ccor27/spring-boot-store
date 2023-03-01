package com.api.store.model.dto;
import java.util.Set;

public record SaleRegistrationRequest(
        String concept,
        CustomerDTO customerDTO,
        Set<ProductDTO> productsDTO
) {
}
