package edu.miu.cs525.finalproject.framework.model;

import edu.miu.cs525.finalproject.framework.observer.Observer;
import edu.miu.cs525.finalproject.framework.observer.Subject;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Subject {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();
    private Party customer;
    private List<Observer> observers = new ArrayList<>();

    private InterestStrategy interestStrategy;


    public Account(String accountNumber, Party customer, double initialDeposit, InterestStrategy interestStrategy) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialDeposit;
        if (initialDeposit > 0) {
            transactions.add(new Transaction(TransactionType.DEPOSIT, initialDeposit, balance));
        }
        this.interestStrategy = interestStrategy;
    }

    public void deposit(double amount) {
        balance += amount;
        createTransaction(TransactionType.DEPOSIT, amount, balance);
    }

    public void withdraw(double amount) {
        balance -= amount;
        createTransaction(TransactionType.WITHDRAW, amount, balance);
    }

    public void addInterest() {
        double interest = interestStrategy.calculateInterest(this.balance);
        balance += interest;
        createTransaction(TransactionType.INTEREST, interest, balance);
    }

    public void createTransaction(TransactionType type, double amount, double updatedBalance) {
        Transaction newTransaction = new Transaction(type, amount, updatedBalance);
        transactions.add(newTransaction);
        notifyObservers(newTransaction);
    }


    public Party getCustomer() {
        return customer;
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

    public void sendEmailNotification(Transaction transaction) {}
}
