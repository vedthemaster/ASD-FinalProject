package edu.miu.cs525.finalproject.creditcard.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class BronzeCreditCard extends CreditCard {

    private static final double MINIMUM_PAYMENT_RATE = 0.14;
    private static final double MONTHLY_INTEREST_RATE = 0.10;

    public BronzeCreditCard(String accountNumber, Party customer, double initialDeposit, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, interestStrategy);
    }


    @Override
    public double getMinimumPayment() {
        return MINIMUM_PAYMENT_RATE;
    }

    @Override
    public double getMonthlyInterest() {
        return MONTHLY_INTEREST_RATE;
    }


}
