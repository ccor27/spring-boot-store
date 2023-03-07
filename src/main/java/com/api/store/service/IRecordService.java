package com.api.store.service;

import com.api.store.model.Record;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.model.dto.RecordDTO;
import com.api.store.model.dto.RecordRegistrationRequest;
import com.api.store.model.dto.SaleDTO;

import java.util.Set;

//Only is allowed update record to add or delete sale
public interface IRecordService {

    public RecordDTO save(RecordRegistrationRequest recordRegistrationRequest   );
    public RecordDTO findById(Long id);
    public Record findRecordById(Long id);
    public Set<RecordDTO> findAll();
    public boolean addSale(SaleDTO saleDTO, Long id);
    public boolean removeSale(SaleDTO saleDTO, Long id);
    public RecordDTO addCustomer(Long id, CustomerDTO customerDTO);
    public RecordDTO updateRecordAddOrDeleteSale(RecordDTO recordDTO);
}
