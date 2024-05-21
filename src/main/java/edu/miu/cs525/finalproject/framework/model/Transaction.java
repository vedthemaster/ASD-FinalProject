package edu.miu.cs525.finalproject.framework.model;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfterTransaction;
    private Date date;

    public Transaction(String type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = new Date();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public Date getDate() {
        return date;
    }
}
