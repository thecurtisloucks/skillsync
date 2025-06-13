package config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Skillsync API")
                        .description("API documentation for Skillsync Backend")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Skillsync Team")
                                .email("contact@skillsync.com")));
    }
} 
