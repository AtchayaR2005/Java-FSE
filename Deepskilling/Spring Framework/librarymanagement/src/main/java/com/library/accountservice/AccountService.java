package com.library.accountservice;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account getAccount() {

        return new Account(101,"Atchaya");

    }

}