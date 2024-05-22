package edu.miu.cs525.finalproject.banking.model.intereststrategy;

import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class SavingInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.08;
    }
}
