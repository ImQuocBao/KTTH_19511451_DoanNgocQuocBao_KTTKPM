package com.javainuse;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/billing/**")
                        .uri("http://localhost:8080/")
                        .id("billingService"))

                .route(r -> r.path("/passengers/**")
                        .uri("http://localhost:8081/")
                        .id("passengerService"))
                .build();
    }
}
