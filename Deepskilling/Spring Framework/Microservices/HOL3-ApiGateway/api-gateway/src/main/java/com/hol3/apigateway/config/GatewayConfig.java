package com.hol3.apigateway.config;

import org.springframework.cloud.gateway.server.mvc.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    // Spring Cloud Gateway routes are configured in application.yml
    // Additional custom filters can be added here
}
