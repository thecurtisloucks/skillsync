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
@RequestMapping("/api/admin")
@Tag(name = "Admin", description = "Admin-only endpoints")
public class AdminController {

    @Operation(summary = "Admin dashboard", description = "Only accessible by users with ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public ResponseEntity<?> adminDashboard(Authentication authentication) {
        return ResponseEntity.ok("Welcome to admin dashboard, " + authentication.getName() + "!");
    }

    @Operation(summary = "Manage users", description = "Only accessible by users with ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<?> manageUsers(Authentication authentication) {
        return ResponseEntity.ok("Admin user management panel - accessible by: " + authentication.getName());
    }
} 
