package com.hol7.resiliencegateway.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ResilienceConfig {
    // Resilience4j is auto-configured via application.yml
    // Circuit breaker, retry, and time limiter instances are defined there
}
