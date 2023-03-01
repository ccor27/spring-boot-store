package com.api.store.controller;

import com.api.store.model.dto.CustomerDTO;
import com.api.store.model.dto.CustomerRegistrationRequest;
import com.api.store.model.dto.CustomerUpdateRequest;
import com.api.store.model.dto.SaleDTO;
import com.api.store.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
//@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        CustomerDTO customerDTO = iCustomerService.save(customerRegistrationRequest);
        if(customerDTO!=null){
            return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Long id){
        CustomerDTO customerDTO = iCustomerService.findById(id);
        if(customerDTO!=null){
            return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/data")
    public ResponseEntity<CustomerDTO> updateData(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        CustomerDTO customerDTO = iCustomerService.update(customerUpdateRequest);
        if(customerDTO!=null){
            return new ResponseEntity<>(customerDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Set<CustomerDTO>> findAll(){
        Set<CustomerDTO> list = iCustomerService.findAll();
        if(list==null || list.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
    @PutMapping("record/{id}")
    public ResponseEntity<?> addSaleIntoRecord(@PathVariable("id") Long id, @RequestBody SaleDTO saleDTO){
        return  iCustomerService.addRecord(saleDTO,id) ? new ResponseEntity<>(HttpStatus.OK) :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
