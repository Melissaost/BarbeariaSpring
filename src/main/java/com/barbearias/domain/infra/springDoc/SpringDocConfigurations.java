package com.barbearias.domain.infra.springDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
        .info(new Info()
                .title("Api de barbearia")
                .description("API Rest da aplicação Barbearia, contendo as funcionalidades de CRUD de barbearias e de usuarios, além de agendamento e cancelamento.")
                .contact(new Contact()
                        .name("Time Backend")
                        .email("ostmelissav@gmail.com")));
    }

}


