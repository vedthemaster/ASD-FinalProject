package edu.miu.cs525.finalproject.creditcard.strategy;

import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class GoldCreditCardStrategy implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        return   balance * 0.06;
    }
}

