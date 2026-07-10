package com.library.accountservice;

public class Account {

    private int accountId;
    private String accountHolder;

    public Account() {
    }

    public Account(int accountId, String accountHolder) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
}
