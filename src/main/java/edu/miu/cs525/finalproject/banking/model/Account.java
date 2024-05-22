package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public abstract class Account extends edu.miu.cs525.finalproject.framework.model.Account {
    private AccountType accountType;
    private AccountInterestType accountInterestType;

    public Account(String accountNumber, Party customer, double initialDeposit, AccountType accountType, AccountInterestType accountInterestType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, interestStrategy);
        this.accountType = accountType;
        this.accountInterestType = accountInterestType;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public AccountInterestType getAccountInterestType() {
        return accountInterestType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", accountInterestType=" + accountInterestType +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", customer=" + getCustomer() +
                ", balance=" + getBalance() +
                '}';
    }
}
