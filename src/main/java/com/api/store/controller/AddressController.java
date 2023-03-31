package com.api.store.controller;

import com.api.store.model.dto.AddressDTO;
import com.api.store.model.dto.AddressRegistrationRequest;
import com.api.store.model.dto.AddressUpdateRequest;
import com.api.store.model.dto.CustomerDTO;
import com.api.store.service.IAddressService;
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
@RequestMapping("/api/v1/address")
@Tag(name = "Address controller", description = "Set of endpoints for address")
@SecurityRequirement(name = "Bearer Authentication")
public class AddressController {
    @Autowired
    private IAddressService iAddressService;


    @PostMapping("/save")
    @Operation(summary = "Save",description = "To save a new address")
    public ResponseEntity<?> save(@RequestBody AddressRegistrationRequest addressRegistrationRequest){
        AddressDTO addressDTO = iAddressService.save(addressRegistrationRequest);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
        }else{
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","Error during the process of saving the address");
            return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   @PutMapping("/update")
   @Operation(summary = "Update data",description = "To update address's data")
   public ResponseEntity<?> updateData(@RequestBody AddressUpdateRequest addressUpdateRequest){
        AddressDTO addressDTO =iAddressService.updateData(addressUpdateRequest);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO,HttpStatus.OK);
        }else{
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","The address doesn't exit");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }
    @GetMapping("/find/{id}")
    @Operation(summary = "Find by id",description = "To return a specific address by its id")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        AddressDTO addressDTO = iAddressService.findById(id);
        if(addressDTO!=null){
            return new ResponseEntity<>(addressDTO,HttpStatus.FOUND);
        }else{
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","The address doesn't exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    @Operation(summary = "Find All",description = "To return all addresses")
    public ResponseEntity<?> findAll(){
        Set<AddressDTO> list = iAddressService.findAll();
        if(list==null || list.size()==0){
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","The list of addresses is empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }
    }
}
