package com.library.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public String securityBean(){

        return "Security Config Loaded";

    }

}