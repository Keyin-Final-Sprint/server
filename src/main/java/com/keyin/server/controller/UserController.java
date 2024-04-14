package com.keyin.server.controller;

import com.keyin.server.entity.UserRole;
import com.keyin.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/{email}")
    public void changeToAdmin(@PathVariable String email) {
        userService.findByEmail(email).ifPresent(userEntity -> {
            userEntity.setRole(UserRole.ADMIN);
            userService.save(userEntity);
        });
    }
}
