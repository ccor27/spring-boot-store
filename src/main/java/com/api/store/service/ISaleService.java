package com.api.store.service;

import com.api.store.model.Sale;
import com.api.store.model.dto.SaleDTO;
import com.api.store.model.dto.SaleRegistrationRequest;

import java.util.Set;

public interface ISaleService {

    public SaleDTO save(SaleRegistrationRequest saleRegistrationRequest);
    public SaleDTO findById(Long id);
    public Set<SaleDTO> findAll();
    public Sale findSaleById(Long id);
    //the sale aren't allowed modify
}
