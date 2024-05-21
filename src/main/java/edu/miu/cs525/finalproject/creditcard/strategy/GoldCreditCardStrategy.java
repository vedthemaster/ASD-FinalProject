package edu.miu.cs525.finalproject.creditcard.strategy;

import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class GoldCreditCardStrategy implements InterestStrategy {

    private static final double INTEREST_RATE = 0.06;

    @Override
    public double calculateInterest(double balance) {
        return INTEREST_RATE * balance;
    }
}
