package edu.miu.cs525.finalproject.banking.service.implement;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.AccountType;
import edu.miu.cs525.finalproject.banking.observer.EmailSender;
import edu.miu.cs525.finalproject.banking.repository.AccountRepository;
import edu.miu.cs525.finalproject.banking.service.AccountService;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.observer.Observer;
import edu.miu.cs525.finalproject.framework.observer.Subject;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        // register observer
        account.addObserver(EmailSender.getInstance());

        accountRepository.saveAccount(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.getAccount(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.getAccount(accountNumber);
        if (account == null) return;
        account.deposit(amount);
        accountRepository.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.getAccount(accountNumber);
        if (account == null) return;
        account.withdraw(amount);
        accountRepository.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountRepository.getAccount(fromAccountNumber);
        Account toAccount = accountRepository.getAccount(toAccountNumber);
        if (fromAccount == null || toAccount == null) return;

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountRepository.getAccounts();
        for (Account account : accounts) {
            account.addInterest();
            accountRepository.updateAccount(account);
        }
    }
}
