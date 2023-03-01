package com.api.store.service.mapper;

import com.api.store.model.Record;
import com.api.store.model.dto.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class RecordDTOMapper implements Function<Record, RecordDTO> {
    @Autowired
    private SaleDTOMapper saleDTOMapper;
    @Override
    public RecordDTO apply(Record record) {
        return new RecordDTO(
                record.getId(),
                record.getSaleSet().stream().map(sale -> {
                    return saleDTOMapper.apply(sale);
                }).collect(Collectors.toSet())
        );
    }
}
