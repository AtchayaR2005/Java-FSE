package com.library.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @Autowired
    private JwtService service;

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest request){

        String token=service.authenticate(request.getUsername(),request.getPassword());

        return new AuthResponse(token);

    }

}
