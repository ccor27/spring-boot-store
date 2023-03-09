package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductUpdateRequest;
import com.api.store.repository.ProductRepository;
import com.api.store.service.mapper.ProductDTOMapper;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService{

    private static final Logger LOGGER= LoggerFactory.getLogger(SLF4JLogger.class);
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
        LOGGER.info("PRODUCT: product created successfully");
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
            LOGGER.info("PRODUCT: product updated successfully");
            return productDTOMapper.apply(product);
        }else {
            LOGGER.error("PRODUCT: the product doesn't exist");
            return null;
        }
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            LOGGER.info("PRODUCT: product found successfully");
            return productDTOMapper.apply(product);
        }else {
            LOGGER.error("PRODUCT: the product doesn't exist");
            return null;
        }
    }

    @Override
    public Set<ProductDTO> findAll() {
        if(productRepository.findAll()==null) {
            LOGGER.error("PRODUCT: there aren't products");
            return null;
        }
        LOGGER.info("PRODUCT: products found successfully");
        return productRepository.findAll().stream().map(product -> {
            return productDTOMapper.apply(product);
        }).collect(Collectors.toSet());
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }
}
