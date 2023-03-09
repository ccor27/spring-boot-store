package com.api.store.service;

import com.api.store.model.Product;
import com.api.store.model.Sale;
import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.SaleDTO;
import com.api.store.model.dto.SaleRegistrationRequest;
import com.api.store.repository.SaleRepository;
import com.api.store.service.mapper.SaleDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaleServiceImp implements ISaleService{

    private final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleDTOMapper saleDTOMapper;
    @Autowired
    private IProductService iProductService;


    @Override
    public SaleDTO save(SaleRegistrationRequest saleRegistrationRequest) {
        Sale sale= new Sale(
                saleRegistrationRequest.concept(),
                convertProductsDTOToProduct(saleRegistrationRequest.productsDTO())
        );
        saleRepository.save(sale);
        LOGGER.info("Sale saved successfully "+sale.toString() );
        return saleDTOMapper.apply(sale);
    }

    @Override
    public SaleDTO findById(Long id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if(sale==null)
            return null;
        return saleDTOMapper.apply(sale);
    }

    @Override
    public Set<SaleDTO> findAll() {

        if(!saleRepository.findAll().isEmpty() || saleRepository.findAll()!=null){
            return saleRepository.findAll().stream().map(sale->{
                return saleDTOMapper.apply(sale);
            }).collect(Collectors.toSet());
        }

        return null;
    }
    @Override
    public Sale findSaleById(Long id){
        return saleRepository.findById(id) != null ? saleRepository.findById(id).get() : null;
    }

    @Override
    public SaleDTO addProduct(Long id, ProductDTO productDTO) {
       Sale sale = findSaleById(id);
       if(sale!=null && productDTO!=null){
           Product product = iProductService.findProductById(productDTO.id());
           if(product!=null){
               sale.getProducts().add(product);
               saleRepository.save(sale);
               LOGGER.info("SALE: the product added successfully");
               return saleDTOMapper.apply(sale);
           }else{
               LOGGER.error("SALE: the product doesn't exist, therefore is not possible add it to the sale");
               return null;
           }
       }else{
           LOGGER.error("SALE: the sale or the product doesn't exist, therefore is not possible make the operation");
           return null;
       }
    }

    @Override
    public SaleDTO removeProduct(Long id, ProductDTO productDTO) {
        Sale sale = findSaleById(id);
        if(sale!=null && productDTO!=null){
            Product product = iProductService.findProductById(productDTO.id());
            if(product!=null){
                sale.getProducts().remove(product);
                saleRepository.save(sale);
                LOGGER.info("SALE: the product removed successfully");
                return saleDTOMapper.apply(sale);
            }else{
                LOGGER.error("SALE: the product doesn't exist, therefore is not possible remove it to the sale");
                return null;
            }
        }else{
            LOGGER.error("SALE: the sale or the product doesn't exist, therefore is not possible make the operation");
            return null;
        }
    }

    public Set<Product> convertProductsDTOToProduct(Set<ProductDTO> productDTOS){

        if(productDTOS ==null || productDTOS.isEmpty())
            return null;

        return productDTOS.stream().map(productDTO -> {
            return iProductService.findProductById(productDTO.id());
        }).collect(Collectors.toSet());
    }


}
