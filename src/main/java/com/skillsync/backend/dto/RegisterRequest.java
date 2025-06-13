package com.skillsync.backend.dto;

import com.skillsync.backend.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Role role;
} 
