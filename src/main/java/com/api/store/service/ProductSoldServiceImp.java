package com.api.store.service;

import com.api.store.model.ProductSold;
import com.api.store.model.dto.ProductSoldDTO;
import com.api.store.repository.ProductSoldRepository;
import com.api.store.service.mapper.ProductSoldDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ProductSoldServiceImp implements IProductSoldService{
    @Autowired
    private ProductSoldDTOMapper productSoldDTOMapper;
    @Autowired
    private ProductSoldRepository productSoldRepository;
    @Override
    public ProductSoldDTO save(ProductSoldDTO productSold) {
        ProductSold p = new ProductSold(productSold.name(), productSold.barCode(), productSold.amount(), productSold.totalPrice());
        productSoldRepository.save(p);
        return productSoldDTOMapper.apply(p);
    }

    @Override
    public Set<ProductSold> saveProducts(Set<ProductSoldDTO> productSoldDTOS) {
        if(!productSoldDTOS.isEmpty()){
            Set<ProductSold> p = productSoldDTOS.stream().map(productSoldDTO->{
                return new ProductSold(productSoldDTO.name(),productSoldDTO.barCode(), productSoldDTO.amount(), productSoldDTO.totalPrice());
            }).collect(Collectors.toSet());
            productSoldRepository.saveAll(p);
            return p;
        }else{
            return null;
        }
    }

    @Override
    public ProductSoldDTO findById(Long id) {
        ProductSold p = productSoldRepository.findById(id).orElse(null);
        return p!=null ? productSoldDTOMapper.apply(p) : null;
    }

    @Override
    public ProductSold findProductSoldById(Long id) {
        ProductSold p = productSoldRepository.findById(id).orElse(null);
        return p!=null ? p : null;
    }

    @Override
    public Set<ProductSoldDTO> findAll() {
        Set<ProductSold> productSolds = productSoldRepository.findAll().stream().collect(Collectors.toSet());
        if(productSolds!=null && !productSolds.isEmpty()){
            return productSolds.stream().map(productSold->{
                return productSoldDTOMapper.apply(productSold);
            }).collect(Collectors.toSet());
        }else{
            return null;
        }
    }

    @Override
    public ProductSold findByBarCode(String barCode) {
        return productSoldRepository.findByBarCode(barCode);
    }
}
