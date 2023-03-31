package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductUpdateRequest;

import java.util.Set;

public interface IProductService {
    public ProductDTO save(ProductRegistrationRequest productRegistrationRequest);
    public ProductDTO updateDate(ProductUpdateRequest productUpdateRequest);
    public ProductDTO findById(Long id);
    public Set<ProductDTO> findAll();
    public Product findProductById(Long id);
    public boolean deleteProduct(Long id);
    public boolean validateAndModifyAmountOfProduct(Product product,int amount);
}
