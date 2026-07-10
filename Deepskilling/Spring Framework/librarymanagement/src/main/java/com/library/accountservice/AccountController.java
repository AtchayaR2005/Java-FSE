package com.library.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/account")
    public Account getAccount(){

        return service.getAccount();

    }

}
