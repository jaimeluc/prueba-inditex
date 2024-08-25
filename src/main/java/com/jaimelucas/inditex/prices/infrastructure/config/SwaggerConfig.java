package com.jaimelucas.inditex.prices.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation for Inditex Technical Test")
                        .version("1.0")
                        .description("API documentation for my Spring Boot application using hexagonal architecture")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Jaime Lucas Lozano").email("jaimelucaslozano@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
