package com.trial.micro.guest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class GuestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuestServiceApplication.class, args);
    }

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("Guest")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trial.micro.guest.service"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Guest Services",
                "A set of services to provide data access to guests",
                "0.1",
                null,
                new Contact("John Doe", "www.example.com", null),
                null, null, Collections.emptyList());
    }
}
