package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.UserDTO;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String getMethod() {
//    	return "welcome";
//    }
    	
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDTO) {
        
    	 // Check if email already exists
        if (userService.findByEmail(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
    	if(!userDTO.getEmail().endsWith("@gmail.com")) {
    		return ResponseEntity.badRequest().body("@gmail.com");
    	}
    	
    	try {
            User user = userService.registerUser(userDTO);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
