package com.library.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {

        return "JWT_TOKEN_FOR_" + username;

    }

}
