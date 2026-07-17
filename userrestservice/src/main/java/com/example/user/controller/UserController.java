package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.user.entity.UserEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User Management APIs")
public class UserController {

    @Autowired
    private com.example.user.service.UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get userById")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id).get();
    }

    @PostMapping
    @Operation(summary = "Save user")
    public void saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
    }
    
}
