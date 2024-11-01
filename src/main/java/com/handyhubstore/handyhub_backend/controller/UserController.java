package com.handyhubstore.handyhub_backend.controller;

import com.handyhubstore.handyhub_backend.model.User;
import com.handyhubstore.handyhub_backend.service.UserService;
import com.handyhubstore.handyhub_backend.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
//@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setRoleId(CommonUtil.customer);
        return userService.createUser(user);
    }
}
