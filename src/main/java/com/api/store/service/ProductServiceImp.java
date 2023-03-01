package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductUpdateRequest;
import com.api.store.repository.ProductRepository;
import com.api.store.service.mapper.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDTOMapper productDTOMapper;
    @Override
    public ProductDTO save(ProductRegistrationRequest productRegistrationRequest) {
        Product product = new Product(
                productRegistrationRequest.name(),
                productRegistrationRequest.description(),
                productRegistrationRequest.price(),
                productRegistrationRequest.amount(),
                productRegistrationRequest.barCode(),
                productRegistrationRequest.origin()
        );
        productRepository.save(product);
        return productDTOMapper.apply(product);
    }

    @Override
    public ProductDTO updateDate(ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findById(productUpdateRequest.id()).orElse(null);
        if(product!=null){
            product.setId(productUpdateRequest.id());
            product.setName(productUpdateRequest.name());
            product.setDescription(productUpdateRequest.description());
            product.setAmount(productUpdateRequest.amount());
            product.setPrice(productUpdateRequest.price());
            productRepository.save(product);
            return productDTOMapper.apply(product);
        }else {
            return null;
        }
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            return productDTOMapper.apply(product);
        }else {
            return null;
        }
    }

    @Override
    public Set<ProductDTO> findAll() {
        if(productRepository.findAll()==null)
            return null;

        return productRepository.findAll().stream().map(product -> {
            return productDTOMapper.apply(product);
        }).collect(Collectors.toSet());
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }
}
