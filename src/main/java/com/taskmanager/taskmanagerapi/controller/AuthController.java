package com.taskmanager.taskmanagerapi.controller;

import com.taskmanager.taskmanagerapi.dto.LoginRequest;
import com.taskmanager.taskmanagerapi.dto.LoginResponse;
import com.taskmanager.taskmanagerapi.entity.User;
import com.taskmanager.taskmanagerapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }
}
