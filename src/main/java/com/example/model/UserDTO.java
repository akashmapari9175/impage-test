package com.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Size(min = 6,message = "name must be at least 9 characters long")
    private String name;
	@Email(message = "invalid email format")
    private String email;
	@Size(min = 6,message = "password must be at least 6 long")
    private String password;
    private String address;

    // Getters and setters
}

