package com.skillsync.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Hello Controller", description = "Test endpoints for API verification")
public class HelloController {
    
    @GetMapping("/")
    @Operation(summary = "Root endpoint", description = "Returns a welcome message at the root URL")
    public String root() {
        return "Welcome to Skillsync API! Try /api/hello or /swagger-ui/index.html";
    }

    @GetMapping("/api/hello")
    @Operation(summary = "Get hello message", description = "Returns a simple hello message to verify the API is working")
    public String hello() {
        return "Hello, Swagger!";
    }
} 
