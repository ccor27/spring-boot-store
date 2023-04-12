package com.api.store.controller;

import com.api.store.model.dto.ProductSoldDTO;
import com.api.store.service.IProductSoldService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequestMapping("/api/v1/product/sold")
@RestController
@Tag(name = "Product sold controller", description = "Set of endpoints for products sold")
@SecurityRequirement(name = "Bearer Authentication")
public class ProductSoldController {
    @Autowired
    private IProductSoldService iProductSoldService;

    @GetMapping("/find")
    public ResponseEntity<?> find(){
        Set<ProductSoldDTO> productSoldDTOS = iProductSoldService.findAll();
        return !productSoldDTOS.isEmpty() || productSoldDTOS!=null ? new ResponseEntity<>(productSoldDTOS, HttpStatus.FOUND) : new ResponseEntity<>(productSoldDTOS, HttpStatus.FOUND);
    }

}
