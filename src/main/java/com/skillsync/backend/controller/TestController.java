package com.skillsync.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test", description = "Test endpoints for JWT authentication and role-based access")
public class TestController {

    @Operation(summary = "Protected endpoint", description = "Returns a message if JWT token is valid")
    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName() + "! This is a protected endpoint.");
    }

    @Operation(summary = "Admin only test", description = "Only accessible by ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-only")
    public ResponseEntity<?> adminOnlyEndpoint(Authentication authentication) {
        return ResponseEntity.ok("Admin access granted for: " + authentication.getName());
    }

    @Operation(summary = "Freelancer or Client", description = "Accessible by FREELANCER or CLIENT roles")
    @PreAuthorize("hasRole('FREELANCER') or hasRole('CLIENT')")
    @GetMapping("/user-only")
    public ResponseEntity<?> userOnlyEndpoint(Authentication authentication) {
        return ResponseEntity.ok("User access granted for: " + authentication.getName());
    }

    @Operation(summary = "Any authenticated user", description = "Accessible by any authenticated user")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/authenticated")
    public ResponseEntity<?> authenticatedEndpoint(Authentication authentication) {
        return ResponseEntity.ok("Authenticated user: " + authentication.getName() + " with authorities: " + authentication.getAuthorities());
    }
} 
