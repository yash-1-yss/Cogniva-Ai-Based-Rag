package com.cogniva.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@Configuration
public class ProjectConfig {
    @Bean
    public OpenAPI openAPI() {

        String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Cogniva — AI Document Intelligence")
                                .description("REST API for Cogniva: Multi-format document ingestion, vector embeddings with PostgreSQL pgvector, and hybrid conversational Q&A with OpenAI.")

                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Substring Technologies")
                                        .email("support@substringtechnolgoies.com")
                                        .url("https://substringtechnologies.com")
                                )

                ).components(new Components()
                        .addSecuritySchemes(
                                securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ))

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                );


    }
}
