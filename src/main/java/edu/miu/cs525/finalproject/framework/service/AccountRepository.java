package edu.miu.cs525.finalproject.framework.service;

import edu.miu.cs525.finalproject.framework.model.Account;

import java.util.List;

public interface AccountRepository {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account getAccount(String accountNumber);
    List<Account> getAccounts();
}
