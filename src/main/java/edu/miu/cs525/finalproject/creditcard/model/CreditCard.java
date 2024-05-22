package edu.miu.cs525.finalproject.creditcard.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public abstract class CreditCard extends Account {

    private CreditCardType creditCardType;

    public CreditCard(String accountNumber, Party customer, double initialDeposit, CreditCardType creditCardType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, interestStrategy);
        this.creditCardType = creditCardType;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public abstract double getMinimumPayment();

    public abstract double getMonthlyInterest();

}
