package com.api.store.controller;

import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductUpdateRequest;
import com.api.store.service.IProductService;
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
@RequestMapping("/api/v1/product")
@Tag(name = "Product controller",description = "Set of endpoints of product")
@SecurityRequirement(name = "Bearer Authentication")
public class ProductController {
    private HashMap<String,String> erros = new HashMap<>();
    @Autowired
    private IProductService iProductService;
    @PostMapping("/save")
    @Operation(summary = "Save",description = "To save a new product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductRegistrationRequest productRegistrationRequest){
        ProductDTO productDTO = iProductService.save(productRegistrationRequest);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        }else{
            erros.clear();
            erros.put("Error","Error during the saving of the product");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    @Operation(summary = "Find by id",description = "To get a products by its id")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id){
        ProductDTO productDTO = iProductService.findById(id);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO,HttpStatus.FOUND);
        }else{
            erros.clear();
            erros.put("Error","the product doesn't exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    @Operation(summary = "Find all",description = "To get all products")
    public ResponseEntity<Set<ProductDTO>> findAll(){
        Set<ProductDTO> list =iProductService.findAll();
        if(list==null || list.size()==0){
            erros.clear();
            erros.put("Error","The list of products is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
    @PutMapping("/update")
    @Operation(summary = "Update data",description = "To update data of specific product")
    public ResponseEntity<ProductDTO> updateData(@RequestBody ProductUpdateRequest productUpdateRequest){
        ProductDTO productDTO = iProductService.updateDate(productUpdateRequest);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO,HttpStatus.OK);
        }else{
            erros.clear();
            erros.put("Error","the product doesn't exist");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete product",description = "To delete a specific product")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        erros.clear();
        erros.put("Error","the product doesn't exist");
        return  iProductService.deleteProduct(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(erros,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
