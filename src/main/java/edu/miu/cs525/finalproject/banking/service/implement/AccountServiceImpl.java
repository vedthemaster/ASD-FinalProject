package edu.miu.cs525.finalproject.banking.service.implement;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.AccountType;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.banking.observer.EmailSender;
import edu.miu.cs525.finalproject.banking.repository.AccountRepository;
import edu.miu.cs525.finalproject.banking.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Account createAccount(Account account) {
        // register observer
        account.addObserver(EmailSender.getInstance());

        accountRepository.save(account);
        if (customerRepository.getOne(account.getCustomer().getEmail()) == null) customerRepository.save((Customer) account.getCustomer());
        customerRepository.addAccount(account.getCustomer().getEmail(), account);

        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.getOne(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAll();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.getOne(accountNumber);
        if (account == null) return;
        account.deposit(amount);
        accountRepository.update(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.getOne(accountNumber);
        if (account == null) return;
        account.withdraw(amount);
        accountRepository.update(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountRepository.getOne(fromAccountNumber);
        Account toAccount = accountRepository.getOne(toAccountNumber);
        if (fromAccount == null || toAccount == null) return;

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        accountRepository.update(fromAccount);
        accountRepository.update(toAccount);
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountRepository.getAll();
        for (Account account : accounts) {
            account.addInterest();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }
}
