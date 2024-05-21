package edu.miu.cs525.finalproject.framework.service;

import edu.miu.cs525.finalproject.framework.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addInterest(double interestRate) {
        for (Account account : accounts) {
            account.addInterest(interestRate);
        }
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
