package com.rishitgupta.greetingapp.controller;

import com.rishitgupta.greetingapp.dto.AuthUserDTO;
import com.rishitgupta.greetingapp.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthenticationService authenticationService;

    public AuthUserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthUserDTO authUserDTO) {
        String response = authenticationService.register(authUserDTO);
        return ResponseEntity.status(201).body(response);
    }
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody AuthUserDTO authUserDTO) {
    String token = authenticationService.login(authUserDTO);
    if (token.equals("Authentication failed.")) {
        return ResponseEntity.status(401).body(token);
    }
    return ResponseEntity.ok(token);
}
}