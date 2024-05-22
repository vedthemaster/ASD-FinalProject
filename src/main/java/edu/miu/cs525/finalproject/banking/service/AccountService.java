package edu.miu.cs525.finalproject.banking.service;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.AccountType;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

import java.util.Collection;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccount(String accountNumber);
    List<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest();
}
