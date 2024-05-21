package edu.miu.cs525.finalproject.creditcard.strategy;

import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class SilverCreditCardStrategy implements InterestStrategy {
    private static final double INTEREST_RATE = 0.08;

    @Override
    public double calculateInterest(double balance) {
        return balance * INTEREST_RATE;
    }
}

