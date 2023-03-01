package com.api.store.controller;

import com.api.store.model.dto.AddressDTO;
import com.api.store.model.dto.AddressRegistrationRequest;
import com.api.store.model.dto.AddressUpdateRequest;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService iAddressService;
    @PostMapping("/save")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressRegistrationRequest addressRegistrationRequest){
        AddressDTO addressDTO = iAddressService.save(addressRegistrationRequest);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   @PutMapping("/update")
   public ResponseEntity<AddressDTO> updateData(@RequestBody AddressUpdateRequest addressUpdateRequest){
        AddressDTO addressDTO =iAddressService.updateData(addressUpdateRequest);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
    @GetMapping("/find/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("id") Long id){
        AddressDTO addressDTO = iAddressService.findById(id);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Set<AddressDTO>> findAll(){
        Set<AddressDTO> list = iAddressService.findAll();
        if(list==null || list.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
}
