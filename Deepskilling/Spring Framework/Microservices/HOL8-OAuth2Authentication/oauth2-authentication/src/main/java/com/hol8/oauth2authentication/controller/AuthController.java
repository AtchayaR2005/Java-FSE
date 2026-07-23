package com.hol8.oauth2authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/api/auth/info")
    public Map<String, String> getAuthInfo() {
        return Map.of(
            "service", "OAuth2 Authorization Server",
            "port", "9000",
            "token-endpoint", "/oauth2/token",
            "authorize-endpoint", "/oauth2/authorize",
            "jwk-set-uri", "/oauth2/jwks"
        );
    }
}
