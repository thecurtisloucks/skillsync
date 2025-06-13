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
@RequestMapping("/api/client")
@Tag(name = "Client", description = "Client-only endpoints")
public class ClientController {

    @Operation(summary = "Client dashboard", description = "Only accessible by users with CLIENT role")
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/dashboard")
    public ResponseEntity<?> clientDashboard(Authentication authentication) {
        return ResponseEntity.ok("Client dashboard for: " + authentication.getName());
    }

    @Operation(summary = "Post project", description = "Only accessible by users with CLIENT role")
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/projects/post")
    public ResponseEntity<?> postProject(Authentication authentication) {
        return ResponseEntity.ok("Post new project - accessible by client: " + authentication.getName());
    }
} 
