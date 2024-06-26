package edu.miu.cs525.finalproject.banking.repository.implement;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.repository.AccountRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
        printAccounts();
    }

    @Override
    public void update(Account account) {
        Account accountExist = getOne(account.getAccountNumber());
        if (accountExist != null) {
            accounts.remove(accountExist);
            accounts.add(account);
        }
    }

    @Override
    public Account getOne(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        return null;
    }

    @Override
    public List<Account> getAll() {
        return accounts;
    }
    @Override
    public Account getOne(Long id) {
        return null;
    }
    public void printAccounts() {
        System.out.println("accounts: ");
        accounts.forEach(System.out::println);
    }
}
