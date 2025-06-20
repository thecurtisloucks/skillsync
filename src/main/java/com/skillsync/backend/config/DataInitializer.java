package com.skillsync.backend.config;

import com.skillsync.backend.model.Role;
import com.skillsync.backend.model.User;
import com.skillsync.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        // Create admin user if it doesn't exist
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@skillsync.com");
            admin.setPassword(encoder.encode("admin"));
            admin.setRole(Role.ADMIN);
            
            userRepository.save(admin);
        }
    }
} 
