package edu.miu.cs525.finalproject.creditcard.service;

import edu.miu.cs525.finalproject.creditcard.observer.CreditEmailSender;
import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.service.AccountRepository;
import edu.miu.cs525.finalproject.framework.service.AccountService;

import java.util.List;

public class CreditCardServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private volatile static CreditCardServiceImpl instance;


    public CreditCardServiceImpl() {
        this.accountRepository = new AccountRepoImpl();
    }

    public static CreditCardServiceImpl getInstance() {
        if (instance == null) {
            synchronized (CreditCardServiceImpl.class) {
                if (instance == null) {
                    instance = new CreditCardServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Account createAccount(Account account) {
        // register observer
        account.addObserver(CreditEmailSender.getInstance());
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
        if (account != null) {
            account.deposit(amount);
            accountRepository.updateAccount(account);
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            accountRepository.updateAccount(account);
        }
    }

}
