package com.api.store.controller;

import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.SaleDTO;
import com.api.store.model.dto.SaleRegistrationRequest;
import com.api.store.service.ISaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/sale")
@Tag(name = "Sale controller",description = "Set of endpoints of sale")
@SecurityRequirement(name = "Bearer Authentication")
public class SaleController {
    private HashMap<String,String> errors = new HashMap<>();
    @Autowired
    private ISaleService iSaleService;

    @PostMapping("/save")
    @Operation(summary = "Save",description = "To save a new sale")
    public ResponseEntity<?> save(@RequestBody SaleRegistrationRequest saleRegistrationRequest){
        SaleDTO sale = iSaleService.save(saleRegistrationRequest);
       if(sale!=null){
           return new ResponseEntity<>(sale,HttpStatus.CREATED);
       }else{
           errors.clear();
           errors.put("Error","Error during the process of saving a sale");
           return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("/find/{id}")
    @Operation(summary = "Find by id",description = "To get a sale by its id")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        SaleDTO sale = iSaleService.findById(id);
        if(sale!=null){
            return new ResponseEntity<>(sale,HttpStatus.FOUND);
        }else {
            errors.clear();
            errors.put("Error","The sale doesn't exist");
            return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    @Operation(summary = "Find all",description = "To get all sales")
    public ResponseEntity<?> findAll(){
        Set<SaleDTO> list = iSaleService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }else{
            errors.clear();
            errors.put("Error","The list of sales is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("{id}/product")
    @Operation(summary = "Add product",description = "To add a product to specific sale")
    public ResponseEntity<?> addProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        SaleDTO saleDTO = iSaleService.addProduct(id,productDTO);
        errors.clear();
        errors.put("Error","The product or the sale doesn't exist");
        return saleDTO!=null ? new ResponseEntity<>(saleDTO,HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/product")
    @Operation(summary = "Remove product from sale",description = "To remove a product to specific sale")
    public ResponseEntity<?> removeProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        SaleDTO saleDTO = iSaleService.removeProduct(id,productDTO);
        errors.clear();
        errors.put("Error","The product or the sale doesn't exist");
        return saleDTO!=null ? new ResponseEntity<>(saleDTO,HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
