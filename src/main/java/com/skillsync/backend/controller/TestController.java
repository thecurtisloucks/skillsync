package com.skillsync.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test", description = "Test endpoints for JWT authentication")
public class TestController {

    @Operation(summary = "Protected endpoint", description = "Returns a message if JWT token is valid")
    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName() + "! This is a protected endpoint.");
    }
} 
