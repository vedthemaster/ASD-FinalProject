package edu.miu.cs525.finalproject.framework.model;

import java.util.Date;

public class Transaction {
    private TransactionType type;
    private double amount;
    private double balanceAfterTransaction;
    private Date date;

    public Transaction(TransactionType type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.date = new Date();
    }

    public TransactionType getType() {
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
