package edu.miu.cs525.finalproject.creditcard.service;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.service.AccountRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountRepoImpl implements AccountRepository {

    static List<Account> accountlist = new ArrayList<Account>();


    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = getAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return accountlist;
    }
}
