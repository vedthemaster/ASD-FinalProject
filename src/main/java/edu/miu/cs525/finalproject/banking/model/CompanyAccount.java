package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class CompanyAccount extends Account {
    public CompanyAccount(String accountNumber, Party customer, double initialDeposit, AccountInterestType accountInterestType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, AccountType.COMPANY, accountInterestType, interestStrategy);
    }
    @Override
    public void sendEmailNotification(Transaction transaction) {
        System.out.printf("Company account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                getAccountNumber(),
                transaction.getDate(),
                transaction.getType(),
                transaction.getAmount()
        );
    }
}
