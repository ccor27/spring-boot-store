package com.api.university.service;

import com.api.university.model.User;
import com.api.university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateData(Long id, User user){
        User userToUpdate = userRepository.findById(id).get();
        if(userToUpdate!=null){
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPwd(user.getPwd());
            return userRepository.save(userToUpdate);
        }else{
            return null;
        }
    }
    public boolean deleteUser(Long id){

        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
