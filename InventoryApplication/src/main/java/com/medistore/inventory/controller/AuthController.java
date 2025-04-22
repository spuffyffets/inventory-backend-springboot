package com.medistore.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medistore.inventory.model.User;
import com.medistore.inventory.service.UserService;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {
        User user = userService.login(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            return "Login successful as " + user.getRole();
        } else {
            return "Invalid credentials";
        }
    }
}
