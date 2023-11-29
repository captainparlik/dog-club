package com.captainparlik.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Oleksandr",
                        email = "alexpotyagaylo@gmail.com"
                ),
                description = "OpenApi documentation for Dog Club Api",
                title = "Dog Club REST API",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
