package com.api.store.model.dto;

import java.util.Set;

public record RecordRegistrationRequest(
        Set<SaleDTO> saleDTOS
) {
}
