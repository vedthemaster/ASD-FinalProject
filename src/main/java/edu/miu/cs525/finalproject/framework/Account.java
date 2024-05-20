package edu.miu.cs525.finalproject.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Observable {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();
    protected Party customer;
    protected List<Observer> observers = new ArrayList<>();

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    protected double monthlyInterestRate;
    protected double minimumPaymentRate;


    public Account(String accountNumber, Party customer, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialDeposit;
        if (initialDeposit > 0) {
            transactions.add(new Transaction("initial deposit", initialDeposit, balance));
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("deposit", amount, balance));
        notifyObservers(new Transaction("deposit", amount, balance));
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction("withdraw", amount, balance));
        notifyObservers(new Transaction("withdraw", amount, balance));
    }

    public void addInterest(double interestRate) {
        double interest = balance * interestRate;
        balance += interest;
        transactions.add(new Transaction("interest", interest, balance));
        notifyObservers(new Transaction("interest", interest, balance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(this, transaction);
        }
    }
}
