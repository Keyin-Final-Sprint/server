package com.keyin.server.controller;

import com.keyin.server.entity.User;
import com.keyin.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user) {
        return authService.signUp(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return authService.login(user.getUsername(), user.getPassword());
    }
}
