package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.model.UserDTO;
import com.example.repository.UserRepositrory;

@Service
public class UserService {

    @Autowired
    private UserRepositrory userRepository;

    public User registerUser(UserDTO userDTO) {
        // Your logic to save user data to the database
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        User save = userRepository.save(user);
        return save;
    }
    public boolean findByEmail(String email) {
       User user = userRepository.findByEmail(email);
       if(user==null) {
    	   return false;
       }
       return true;
    }
}
