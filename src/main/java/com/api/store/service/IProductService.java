package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.ProductSold;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductSoldDTO;
import com.api.store.model.dto.ProductUpdateRequest;

import java.util.Set;

public interface IProductService {
    public ProductDTO save(ProductRegistrationRequest productRegistrationRequest);
    public ProductDTO updateDate(ProductUpdateRequest productUpdateRequest);
    public ProductDTO findById(Long id);
    public Set<ProductDTO> findAll();
    public Product findProductById(Long id);
    public Product findByBarCode(String barCode);
    public boolean deleteProduct(Long id);
    public boolean validateAmountOfProduct(Product product, int amount);
    public boolean modifyAmountOfProduct(Product product, int amount);
    public Set<ProductSold> convertProductsDTOToProduct(Set<ProductSoldDTO> productDTOS);
}
