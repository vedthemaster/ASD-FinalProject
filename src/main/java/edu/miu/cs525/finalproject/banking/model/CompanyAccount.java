package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class CompanyAccount extends Account {
    public CompanyAccount(String accountNumber, Party customer, double initialDeposit, AccountInterestType accountInterestType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, AccountType.COMPANY, accountInterestType, interestStrategy);
    }
}
