package com.api.store.controller;

import com.api.store.model.dto.*;
import com.api.store.service.ICustomerService;
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
@RequestMapping("/api/v1/customer")
@Tag(name = "Customer controller",description = "Set of endpoints for customer")
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {
    private HashMap<String,String> errors = new HashMap<>();
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/find/{id}")
    @Operation(summary = "Find by id",description = "To get a customer by its id")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        CustomerDTO customerDTO = iCustomerService.findById(id);
        if(customerDTO!=null){
            return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
        }else{
            errors.clear();
            errors.put("Error","The customer doesn't exist");
            return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/data")
    @Operation(summary = "Update data",description = "To update data of specific customer")
    public ResponseEntity<?> updateData(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        CustomerDTO customerDTO = iCustomerService.updateInfo(customerUpdateRequest);
        if(customerDTO!=null){
            return new ResponseEntity<>(customerDTO,HttpStatus.OK);
        }else{
            errors.clear();
            errors.put("Error","The customer doesn't exist");
            return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find")
    @Operation(summary = "Find all",description = "To get all customers")
    public ResponseEntity<?> findAll(){
        Set<CustomerDTO> list = iCustomerService.findAll();
        if(list==null || list.size()==0){
            errors.clear();
            errors.put("Error","The list of customers is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
    @PutMapping("{id}/record")
    @Operation(summary = "Add record",description = "To add a record to specific customer")
    public ResponseEntity<?> addRecord(@PathVariable("id") Long id, @RequestBody RecordDTO recordDTO){
        if(iCustomerService.addRecord(recordDTO,id)!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            errors.clear();
            errors.put("Info","There is a problem, it could be caused for three reasons");
            errors.put("Error 1","Possibly the error was caused by the customer doesn't exist");
            errors.put("Error 2","Possibly the error was caused by that the record already have a customer");
            errors.put("Error 3","Possibly the error was caused by that the record doesn't exist");
            return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("{id}/record/sale")
    @Operation(summary = "Add sale into record",description = "To add a new sale to customer's record")
    public ResponseEntity<?> addSaleIntoRecord(@RequestBody SaleDTO saleDTO,@PathVariable("id") Long id){
          boolean isAdded = iCustomerService.addSaleInRecord(saleDTO,id);
          errors.clear();
          errors.put("Info","There is a problem, it could be caused for three reasons");
          errors.put("Error 1","Possibly the error was caused by the sale doesn't exist");
          errors.put("Error 2","Possibly the error was caused by the customer doesn't exist");
          errors.put("Error 3","Possibly the error was caused by the record doesn't exist");
          return isAdded ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}/record/sale")
    @Operation(summary = "Remove sale from record",description = "To remove a sale to customer's record")
    public ResponseEntity<?> removeSaleFromRecord(@PathVariable("id") Long id, @RequestBody SaleDTO saleDTO){
        boolean isRemoved = iCustomerService.deleteSaleInRecord(saleDTO,id);
        errors.clear();
        errors.put("Info","There is a problem, it could be caused for three reasons");
        errors.put("Error 1","Possibly the error was caused by the sale doesn't exist");
        errors.put("Error 2","Possibly the error was caused by the customer doesn't exist");
        errors.put("Error 3","Possibly the error was caused by the record doesn't exist");
        return isRemoved ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/{id}/add/address")
    @Operation(summary = "Add address",description = "To add a new address to customer")
    public ResponseEntity<CustomerDTO> addAddress(@RequestBody AddressRegistrationRequest addressRegistrationRequest, @PathVariable("id") Long id){
          CustomerDTO customerDTO = iCustomerService.addAddress(addressRegistrationRequest,id);
          if(customerDTO!=null ){
              return new ResponseEntity<>(customerDTO,HttpStatus.OK);
          }else{
              errors.clear();
              errors.put("Error","the customer doesn't exist or the address send is null");
              return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }

    }
    @DeleteMapping("{id}/remove/address")
    @Operation(summary = "Remove address",description = "To remove a address to customer")
    public ResponseEntity<CustomerDTO> removeAddress(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id){
       CustomerDTO customerDTO = iCustomerService.removeAddress(addressDTO,id);
       if(customerDTO!=null){
           return new ResponseEntity<>(customerDTO,HttpStatus.OK);
       }else {
           errors.put("Error","the customer doesn't exist or the address send is null");
           errors.clear();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @GetMapping("/{id}/record")
    @Operation(summary = "Find customer's record",description = "To get the customer's record")
    public ResponseEntity<?> findRecordCustomer(@PathVariable("id") Long id){
        RecordDTO recordDTO = iCustomerService.findRecordCustomer(id);
        errors.clear();
        errors.put("Error","The customer doesn't exit or there isn't a record in the customer");
        return recordDTO!=null ? new ResponseEntity<>(recordDTO,HttpStatus.OK) : new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/{id}/address")
    @Operation(summary = "Find customer's address",description = "To get a customer's address")
    public ResponseEntity<AddressDTO> findAddressCustomer(@PathVariable("id") Long id){
        AddressDTO addressDTO = iCustomerService.findAddressCustomer(id);
        if (addressDTO!=null){
            return new ResponseEntity<>(addressDTO,HttpStatus.OK);
        }else {
            errors.clear();
            errors.put("Error","the customer doesn't have an address or the customer doesn't exist");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
