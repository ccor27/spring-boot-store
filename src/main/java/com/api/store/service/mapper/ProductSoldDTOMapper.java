package com.api.store.service.mapper;

import com.api.store.model.ProductSold;
import com.api.store.model.dto.ProductSoldDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ProductSoldDTOMapper implements Function<ProductSold, ProductSoldDTO> {
    @Override
    public ProductSoldDTO apply(ProductSold productSold) {
        return new ProductSoldDTO(
                productSold.getId(),
                productSold.getName(),
                productSold.getBarCode(),
                productSold.getAmount(),
                productSold.getTotalPrice()
        );
    }
}
