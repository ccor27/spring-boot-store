package com.api.university.controller;

import com.api.university.model.User;
import com.api.university.repository.UserRepository;
import com.api.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
