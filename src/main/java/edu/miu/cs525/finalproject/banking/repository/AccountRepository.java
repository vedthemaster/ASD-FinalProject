package edu.miu.cs525.finalproject.banking.repository;

import edu.miu.cs525.finalproject.banking.model.Account;

import java.util.Collection;
import java.util.List;

public interface AccountRepository {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account getAccount(String accountNumber);
    List<Account> getAccounts();
}
