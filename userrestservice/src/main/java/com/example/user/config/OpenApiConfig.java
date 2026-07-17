package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI userServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Service API")
                        .description("REST API for User Service")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("API Support")
                                .email("Gyanendra.K.Hyoju@irs.gov"))
                        .license(new License()
                                .name("Apache 2.0")));
    }
}
