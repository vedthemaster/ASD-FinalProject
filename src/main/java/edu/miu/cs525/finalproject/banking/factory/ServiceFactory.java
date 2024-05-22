package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.repository.implement.AccountRepositoryImpl;
import edu.miu.cs525.finalproject.banking.repository.implement.CustomerRepositoryImpl;
import edu.miu.cs525.finalproject.banking.service.AccountService;
import edu.miu.cs525.finalproject.banking.service.implement.AccountServiceImpl;

public class ServiceFactory {
    private static AccountService accountService;

    public static AccountService getAccountService() {
        if (accountService == null) {
            accountService = new AccountServiceImpl(new AccountRepositoryImpl(), new CustomerRepositoryImpl());
        }
        return accountService;
    }
}
