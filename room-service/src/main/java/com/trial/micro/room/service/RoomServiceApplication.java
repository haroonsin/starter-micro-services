package com.trial.micro.room.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class RoomServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomServiceApplication.class, args);
    }


    @Bean
    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("Room").select()
//                .apis(RequestHandlerSelectors.basePackage("com.trial.micro.roomservice"))
//                .paths(any()).build().apiInfo(new ApiInfo("Room Services",
//                        "A set of services to provide data access to rooms", "1.0.0", null,
//                        new Contact("Frank Moley", "https://twitter.com/fpmoles", null), null, null));

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trial.micro.roomservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Room Services",
                "A set of services to provide data access to rooms.",
                "0.1",
                "Terms of service",
                new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
