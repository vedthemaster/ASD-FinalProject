package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Transaction;

public class IndividualCustomer extends Customer {
    public IndividualCustomer(String name, String email, Address address) {
        super(name, email, address, CustomerType.INDIVIDUAL);
    }

    @Override
    public void sendEmailNotification(Account account, Transaction transaction) {
        if (transaction.getAmount() > 500 || transaction.getBalanceAfterTransaction() < 0) {
            System.out.printf("Personal account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                    account.getAccountNumber(),
                    transaction.getDate(),
                    transaction.getType(),
                    transaction.getAmount()
            );
        }
    }
}
