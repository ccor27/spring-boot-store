package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.Sale;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.SaleDTO;
import com.api.store.model.dto.SaleRegistrationRequest;

import java.util.Set;

public interface ISaleService {

    public SaleDTO save(SaleRegistrationRequest saleRegistrationRequest);
    public SaleDTO findById(Long id);
    public Set<SaleDTO> findAll();
    public Sale findSaleById(Long id);
    public SaleDTO addProduct(Long id, ProductDTO productDTO);
    public SaleDTO removeProduct(Long id, ProductDTO productDTO);

}
