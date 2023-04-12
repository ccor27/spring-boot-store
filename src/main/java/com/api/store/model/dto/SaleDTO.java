package com.api.store.model.dto;

import java.util.Date;
import java.util.Set;

// this class work both dto and dtoRegisterRequest
public record   SaleDTO(
        Long id,
        String concept,
        Date date,
        Double price,
        Set<ProductSoldDTO> productDTOS
) {
}
