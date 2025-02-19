package ml.software.microservice.api_gateway.configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r
                        .path("/api/product/**")
                        .uri("lb://PRODUCT-SERVICE"))
                .route("order-service", r -> r
                        .path("/api/order/**")
                        .uri("lb://ORDER-SERVICE"))
                .route("inventory-service", r -> r
                        .path("/api/inventory/**")
                        .uri("lb://INVENTORY-SERVICE"))
                .build();
    }
}
