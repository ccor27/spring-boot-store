package com.api.store.service.mapper;

import com.api.store.model.Customer;
import com.api.store.model.Product;
import com.api.store.model.ProductSold;
import com.api.store.model.Sale;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductSoldDTO;
import com.api.store.model.dto.SaleDTO;
import com.api.store.service.ICustomerService;
import com.api.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SaleDTOMapper implements Function<Sale, SaleDTO> {
    @Autowired
    private CustomerDTOMapper customerDTOMapper;
    @Autowired
    private ProductSoldDTOMapper productSoldDTOMapper;
    @Autowired
    private IProductService iProductService;
    @Override
    public SaleDTO apply(Sale sale) {
        return  new SaleDTO(
                sale.getId(),
                sale.getConcept(),
                sale.getCreated_at(),
                sale.getPrice(),
                productsExisting(sale.getProducts())

        );
    }

    private Set<ProductSoldDTO> productsExisting(Set<ProductSold> productSolds){
        if(productSolds==null || productSolds.isEmpty()){
            return null;
        }else{
            return productSolds.stream().map(productSold ->{
                return productSoldDTOMapper.apply(productSold);
            }).collect(Collectors.toSet());
        }
    }
}
