package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class PersonalAccount extends Account {
    public PersonalAccount(String accountNumber, Party customer, double initialDeposit, AccountInterestType accountInterestType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, AccountType.PERSONAL, accountInterestType, interestStrategy);
    }
}
