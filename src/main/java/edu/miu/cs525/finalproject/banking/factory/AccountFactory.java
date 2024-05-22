package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public interface AccountFactory {
    Account createAccount(String accountNumber, Customer customer, double initialDeposit, AccountInterestType interestType, InterestStrategy interestStrategy);
}
