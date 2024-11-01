package com.handyhubstore.handyhub_backend.service.impl;

import com.handyhubstore.handyhub_backend.model.User;
import com.handyhubstore.handyhub_backend.repository.UserRepository;
import com.handyhubstore.handyhub_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity<List<User>> response;
        List<User> usersData;
        try {
            usersData = userRepository.findAll();
            response = new ResponseEntity<>(usersData, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
