package com.api.store.controller;

import com.api.store.model.dto.*;
import com.api.store.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
//@Controller
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
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
        CustomerDTO customerDTO = iCustomerService.updateInfo(customerUpdateRequest);
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
    @PutMapping("{id}/record")
    public ResponseEntity<?> addRecord(@PathVariable("id") Long id, @RequestBody RecordDTO recordDTO){
        return  iCustomerService.addRecord(recordDTO,id)!=null ? new ResponseEntity<>(HttpStatus.OK) :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("{id}/record/sale")
    public ResponseEntity<?> addSaleIntoRecord(@RequestBody SaleDTO saleDTO,@PathVariable("id") Long id){
          boolean isAdded = iCustomerService.addSaleInRecord(saleDTO,id);
          return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/record/sale")
    public ResponseEntity<?> removeSaleFromRecord(@PathVariable("id") Long id, @RequestBody SaleDTO saleDTO){
        boolean isRemoved = iCustomerService.deleteSaleInRecord(saleDTO,id);
        return isRemoved ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/{id}/add/address")
    public ResponseEntity<CustomerDTO> addAddress(@RequestBody AddressRegistrationRequest addressRegistrationRequest, @PathVariable("id") Long id){
          CustomerDTO customerDTO = iCustomerService.addAddress(addressRegistrationRequest,id);
          return customerDTO!=null ? new ResponseEntity<>(customerDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/remove/address")
    public ResponseEntity<CustomerDTO> removeAddress(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id){
       CustomerDTO customerDTO = iCustomerService.removeAddress(addressDTO,id);
       return customerDTO!=null ? new ResponseEntity<>(customerDTO,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
