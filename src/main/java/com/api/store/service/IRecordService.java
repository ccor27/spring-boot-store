package com.api.store.service;

import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;

import java.util.Set;

// I'm using a record_dto as dto and registration_request
//Only is allowed update record to add or delete sale
public interface IRecordService {

    public RecordDTO save(RecordRegistrationRequest recordRegistrationRequest   );
    public RecordDTO findById(Long id);
    public Set<RecordDTO> findAll();

    public RecordDTO updateRecordAddOrDeleteSale(RecordDTO recordDTO);
}
