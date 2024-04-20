package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepositrory extends JpaRepository<User,Integer> {

	User findByEmail(String email);
}
