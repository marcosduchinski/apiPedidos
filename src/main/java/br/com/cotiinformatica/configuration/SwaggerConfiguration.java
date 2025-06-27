package br.com.cotiinformatica.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()).info(new Info()
                .title("API - Pedidos - Treinamento TJPR")
                .description("Curso Java Arquiteto - COTI Informática")
                .version("1.0")
        );
    }
}
