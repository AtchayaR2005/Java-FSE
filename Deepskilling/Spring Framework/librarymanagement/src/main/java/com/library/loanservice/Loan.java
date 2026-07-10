package com.library.loanservice;

public class Loan {

    private int loanId;
    private double amount;

    public Loan() {
    }

    public Loan(int loanId,double amount) {

        this.loanId=loanId;
        this.amount=amount;

    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}