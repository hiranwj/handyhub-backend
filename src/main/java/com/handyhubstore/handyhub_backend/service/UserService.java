package com.handyhubstore.handyhub_backend.service;

import com.handyhubstore.handyhub_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();
}