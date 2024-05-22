package edu.miu.cs525.finalproject.framework.service;

import edu.miu.cs525.finalproject.framework.model.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);

    Account getAccount(String accountNumber);

    List<Account> getAllAccounts();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);

    void addInterest();


}
