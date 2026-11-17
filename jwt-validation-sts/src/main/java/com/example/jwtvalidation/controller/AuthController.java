package com.example.jwtvalidation.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtvalidation.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    // Demo only: a real application must authenticate the user before issuing a token.
    @PostMapping("/token")
    public Map<String, String> createToken(@RequestBody Map<String, String> body) {
        String username = body.getOrDefault("username", "student");
        return Map.of("token", jwtService.generateToken(username));
    }
}
