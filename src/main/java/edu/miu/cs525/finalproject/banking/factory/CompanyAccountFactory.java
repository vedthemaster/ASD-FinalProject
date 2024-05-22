package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.CompanyAccount;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class CompanyAccountFactory implements AccountFactory{
    @Override
    public Account createAccount(String accountNumber, Customer customer, double initialDeposit, AccountInterestType interestType, InterestStrategy interestStrategy) {
        Account account = new CompanyAccount(accountNumber, customer, initialDeposit, interestType, interestStrategy);
        return account;
    }
}
