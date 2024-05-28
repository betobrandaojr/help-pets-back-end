package br.com.brandao.help_pets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Help Pets API")
                        .description(
                                "Aplicação destinada para auxiliar os abrigos de animais no RS após as fortes chuvas de 2024.")
                        .version("1.0.0"));
    }
}
