package com.api.store.controller;

import com.api.store.model.dto.SaleDTO;
import com.api.store.model.dto.SaleRegistrationRequest;
import com.api.store.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private ISaleService iSaleService;

    @PostMapping("/save")
    public ResponseEntity<SaleDTO> save(@RequestBody SaleRegistrationRequest saleRegistrationRequest){
        SaleDTO sale = iSaleService.save(saleRegistrationRequest);
       if(sale!=null){
           return new ResponseEntity<>(sale,HttpStatus.CREATED);
       }else{
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<SaleDTO> findById(@PathVariable("id") Long id){
        SaleDTO sale = iSaleService.findById(id);
        if(sale!=null){
            return new ResponseEntity<>(sale,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Set<SaleDTO>> findAll(){
        Set<SaleDTO> list = iSaleService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
