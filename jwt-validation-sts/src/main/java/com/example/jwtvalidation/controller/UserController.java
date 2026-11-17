package com.example.jwtvalidation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/profile")
    public String profile(@RequestAttribute("username") String username) {
        return "Welcome " + username;
    }
}
