package com.api.store.service.mapper;

import com.api.store.model.Product;
import com.api.store.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getBarCode(),
                product.getPrice(),
                product.getAmount()
        );
    }
}
