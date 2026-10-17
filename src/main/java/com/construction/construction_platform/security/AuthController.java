package com.construction.construction_platform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequest request) {
        // For demonstration/testing, we generate a token directly based on input username & role
        // In full production, you would validate credentials against a database first.
        String token = jwtUtils.generateToken(request.getUsername(), request.getRole());
        return ResponseEntity.ok(token);
    }
}