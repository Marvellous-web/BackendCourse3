package com.stackroute.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/authentication-app/v1/**")
                        .uri("http://localhost:9199/*"))
                .route(p-> p
                        .path("/productapp/v1/**")
                        .uri("http://localhost:8080/*"))
                .build();
    }
}