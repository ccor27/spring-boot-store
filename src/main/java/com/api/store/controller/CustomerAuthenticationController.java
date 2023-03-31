package com.api.store.controller;

import com.api.store.model.dto.CustomerAuthenticateResponse;
import com.api.store.model.dto.CustomerAuthentication;
import com.api.store.model.dto.CustomerRegistrationRequest;
import com.api.store.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/auth/customer")
@Tag(name="Customer Authentication controller",description = "Set of endpoints for register and authenticate a customer")
public class CustomerAuthenticationController {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/save")
    @Operation(summary = "Save",description = "To save (or register) a new customer")
    public ResponseEntity<?> save(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){

        CustomerAuthenticateResponse response = iCustomerService.register(customerRegistrationRequest);
        if(response!=null){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","Error during the process of register the customer.");
            return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate",description = "To authenticate a customer")
    public ResponseEntity<?> authenticate(@RequestBody CustomerAuthentication customerAuthentication){
        try {
            CustomerAuthenticateResponse response = iCustomerService.authenticate(customerAuthentication);
        if(response!=null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }catch (Exception e){
            HashMap<String,String> errors = new HashMap<>();
            errors.put("Error","The credentials are wrong");
           return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
