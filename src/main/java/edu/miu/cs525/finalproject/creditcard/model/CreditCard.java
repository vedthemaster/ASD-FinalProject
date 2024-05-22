package edu.miu.cs525.finalproject.creditcard.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public abstract class CreditCard extends Account {

    public CreditCard(String accountNumber, Party customer, double initialDeposit, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, interestStrategy);
    }

    public abstract void charge(double amount);

    public abstract double getMinimumPayment();

    public abstract double getMonthlyInterest();

}
