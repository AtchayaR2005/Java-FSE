package com.library.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(String username,String password){

        if(username.equals("admin") && password.equals("admin")){

            return jwtUtil.generateToken(username);

        }

        return "Invalid Credentials";

    }

}
