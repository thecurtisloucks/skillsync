package com.skillsync.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestDataInitializer {

    @Bean
    public CommandLineRunner testDataInitializer() {
        return args -> {
            // No data initialization needed for tests
        };
    }
} 
