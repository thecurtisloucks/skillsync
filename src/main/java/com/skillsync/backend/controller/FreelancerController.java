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
@RequestMapping("/api/freelancer")
@Tag(name = "Freelancer", description = "Freelancer-only endpoints")
public class FreelancerController {

    @Operation(summary = "Freelancer profile", description = "Only accessible by users with FREELANCER role")
    @PreAuthorize("hasRole('FREELANCER')")
    @GetMapping("/profile")
    public ResponseEntity<?> freelancerProfile(Authentication authentication) {
        return ResponseEntity.ok("Freelancer profile for: " + authentication.getName());
    }

    @Operation(summary = "View projects", description = "Only accessible by users with FREELANCER role")
    @PreAuthorize("hasRole('FREELANCER')")
    @GetMapping("/projects")
    public ResponseEntity<?> viewProjects(Authentication authentication) {
        return ResponseEntity.ok("Available projects for freelancer: " + authentication.getName());
    }
} 
