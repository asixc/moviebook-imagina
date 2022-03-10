package com.moviebook.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // URL POR DEFECTO: http://localhost:8080/swagger-ui/

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select() //packete a escanear
                .apis(RequestHandlerSelectors.basePackage("com.moviebook")) //pide un predicado pero hay una clase que nos da eso
                .build()
                .apiInfo(new ApiInfo(
                        "API title: Moviebook",
                        "API Description",
                        "0.0.1",
                        "Terms of service..",
                        new Contact("Jotxe", "jotxee.dev", "info@jotxee.dev"),
                        "license",
                        "http://license.url",
                        Collections.emptyList())
                );
    }
}
