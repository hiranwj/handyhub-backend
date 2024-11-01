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
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
        return response;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        ResponseEntity<User> response;
        User userData;
        try {
            if ((!user.getName().isEmpty() && !user.getEmail().isEmpty()
                    && !user.getPassword().isEmpty()) && (user.getName() != null &&
                    user.getEmail() != null && user.getPassword() != null)) {
                if (userRepository.findByEmail(user.getEmail()) == null) {
                    userData = userRepository.save(user);
                    response = new ResponseEntity<>(userData, HttpStatus.OK);
                } else {
                    response = new ResponseEntity<>(HttpStatus.FORBIDDEN); // 403
                }
            } else {
                response = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); // 406
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
        return response;
    }

}
