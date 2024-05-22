package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.banking.model.PersonalAccount;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class PersonalAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer, double initialDeposit, AccountInterestType interestType, InterestStrategy interestStrategy) {
        return new PersonalAccount(accountNumber, customer, initialDeposit, interestType, interestStrategy);
    }
}
