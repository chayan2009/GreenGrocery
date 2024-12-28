package com.greengrocery.Store_Service.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Green Grocery Store Service API")
                        .description("API documentation for managing stores in the Green Grocery application.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Green Grocery Support")
                                .email("support@greengrocery.com")
                                .url("https://greengrocery.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}

