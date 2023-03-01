package com.api.store.service.mapper;

import com.api.store.model.Customer;
import com.api.store.model.Product;
import com.api.store.model.Sale;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.SaleDTO;
import com.api.store.service.ICustomerService;
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
    private ProductDTOMapper productDTOMapper;
    @Override
    public SaleDTO apply(Sale sale) {
        return  new SaleDTO(
                sale.getId(),
                sale.getConcept(),
                sale.getCreated_at(),
                sale.getPrice(),
                customerExist(sale.getCustomer()).name(),
                productsExisting(sale.getProducts())

        );
    }

    private Set<ProductDTO> productsExisting(Set<Product> products){
        if(products==null || products.isEmpty()){
            return null;
        }else{
            return products.stream().map(product ->{
                return productDTOMapper.apply(product);
            }).collect(Collectors.toSet());
        }
    }
    private CustomerDTO customerExist(Customer customer){
        if(customer!=null){
            return customerDTOMapper.apply(customer);
        }else{
            return null;
        }
    }
}
