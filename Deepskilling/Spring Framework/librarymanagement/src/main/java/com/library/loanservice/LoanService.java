package com.library.loanservice;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public Loan getLoan(){

        return new Loan(201,500000);

    }

}