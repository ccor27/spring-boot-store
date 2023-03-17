package com.api.store.controller;

import com.api.store.model.dto.CustomerAuthenticateResponse;
import com.api.store.model.dto.CustomerAuthentication;
import com.api.store.model.dto.CustomerRegistrationRequest;
import com.api.store.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/customer")
public class CustomerAuthenticationController {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerAuthenticateResponse> save(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        CustomerAuthenticateResponse response = iCustomerService.register(customerRegistrationRequest);
        if(response!=null){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/authenticate")
    public ResponseEntity<CustomerAuthenticateResponse> authenticate(@RequestBody CustomerAuthentication customerAuthentication){
        CustomerAuthenticateResponse response = iCustomerService.authenticate(customerAuthentication);
        if(response!=null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
