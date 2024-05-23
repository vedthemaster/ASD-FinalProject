package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;

public class PersonalAccount extends Account {
    public PersonalAccount(String accountNumber, Party customer, double initialDeposit, AccountInterestType accountInterestType, InterestStrategy interestStrategy) {
        super(accountNumber, customer, initialDeposit, AccountType.PERSONAL, accountInterestType, interestStrategy);
    }

    @Override
    public void sendEmailNotification(Transaction transaction) {
        if (transaction.getAmount() > 500 || transaction.getBalanceAfterTransaction() < 0) {
            System.out.printf("Personal account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                    getAccountNumber(),
                    transaction.getDate(),
                    transaction.getType(),
                    transaction.getAmount()
            );
        }
    }
}
