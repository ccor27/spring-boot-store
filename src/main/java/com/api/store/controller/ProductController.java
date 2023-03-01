package com.api.store.controller;

import com.api.store.model.dto.ProductDTO;
import com.api.store.model.dto.ProductRegistrationRequest;
import com.api.store.model.dto.ProductUpdateRequest;
import com.api.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductRegistrationRequest productRegistrationRequest){
        ProductDTO productDTO = iProductService.save(productRegistrationRequest);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id){
        ProductDTO productDTO = iProductService.findById(id);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Set<ProductDTO>> findAll(){
        Set<ProductDTO> list =iProductService.findAll();
        if(list==null || list.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateData(@RequestBody ProductUpdateRequest productUpdateRequest){
        ProductDTO productDTO = iProductService.updateDate(productUpdateRequest);
        if(productDTO!=null){
            return new ResponseEntity<>(productDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
