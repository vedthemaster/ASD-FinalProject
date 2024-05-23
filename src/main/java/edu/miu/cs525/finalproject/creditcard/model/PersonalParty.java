package edu.miu.cs525.finalproject.creditcard.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;


public class PersonalParty extends Party {

    public PersonalParty(String name, String email, Address address) {
        super(name, email, address);
    }

    @Override
    public void sendEmailNotification(Account account, Transaction transaction) {
        if (transaction.getAmount() > 400 || transaction.getBalanceAfterTransaction() < 0) {
            System.out.printf("Personal Credit account email notification: Customer %s - Date: %s - Type: %s - Amount: %,.2f\n",
                    getName(),
                    transaction.getDate(),
                    transaction.getType(),
                    transaction.getAmount()
            );
        }

    }


}