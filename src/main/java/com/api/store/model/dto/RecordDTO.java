package com.api.store.model.dto;

import java.util.Set;

public record RecordDTO(
        Long id,
        String customerName,
        Set<SaleDTO> saleDTOS
) {
}
