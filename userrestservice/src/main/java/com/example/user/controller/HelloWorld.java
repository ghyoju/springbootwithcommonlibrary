package com.example.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@Tag(name = "HelloWorld", description = "HelloWorld")
public class HelloWorld {

    @GetMapping
    @Operation(summary = "HelloWorld")
    public ResponseEntity<String> getAllUsers() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
