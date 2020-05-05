package com.udemy.currencyexchangeservice.swaggerconfig;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                /*.groupName("v1.0-api")*/
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.udemy.currencyexchangeservice.controller"))
                .paths(regex("/currency-exchange.*"))
                .build()
                /*.directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)*/
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                "",
                /*new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),*/
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}