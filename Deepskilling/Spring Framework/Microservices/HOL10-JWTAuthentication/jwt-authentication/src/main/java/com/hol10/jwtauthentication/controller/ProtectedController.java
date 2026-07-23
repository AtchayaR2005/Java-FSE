package com.hol10.jwtauthentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @GetMapping("/hello")
    public Map<String, String> hello(Authentication authentication) {
        return Map.of(
            "message", "Hello from JWT protected endpoint!",
            "user", authentication.getName()
        );
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(Authentication authentication) {
        return Map.of(
            "username", authentication.getName(),
            "authorities", authentication.getAuthorities(),
            "message", "This is your profile data (JWT protected)"
        );
    }
}
