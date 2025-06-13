package com.skillsync.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestDataInitializer {

    @Bean
    @Primary
    public CommandLineRunner dataInitializer() {
        return args -> {
            // No data initialization needed for tests
        };
    }
} 
