package com.api.store.service;

import com.api.store.model.ProductSold;
import com.api.store.model.dto.ProductSoldDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface IProductSoldService {
    public ProductSoldDTO save(ProductSoldDTO productSold);
    public Set<ProductSold> saveProducts(Set<ProductSoldDTO> productSoldDTOS);
    public ProductSoldDTO findById(Long id);
    public ProductSold findProductSoldById(Long id);
    public Set<ProductSoldDTO> findAll();
    public ProductSold findByBarCode(String barCode);
}
