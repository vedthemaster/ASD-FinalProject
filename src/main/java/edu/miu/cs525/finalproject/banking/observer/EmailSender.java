package edu.miu.cs525.finalproject.banking.observer;

import edu.miu.cs525.finalproject.banking.model.CompanyAccount;
import edu.miu.cs525.finalproject.banking.model.PersonalAccount;
import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.model.TransactionType;
import edu.miu.cs525.finalproject.framework.observer.Observer;

public class EmailSender implements Observer {
    private static volatile EmailSender instance;
    private EmailSender() {}

    public static EmailSender getInstance() {
        if (instance == null) {
            synchronized (EmailSender.class) {
                if (instance == null) {
                    instance = new EmailSender();
                }
            }
        }
        return instance;
    }


    @Override
    public void update(Account account, Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT || transaction.getType() == TransactionType.WITHDRAW) {
            if (account.getClass() == PersonalAccount.class) {
                if (transaction.getAmount() > 500 || transaction.getBalanceAfterTransaction() < 0) {
                    System.out.printf("Personal account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                            account.getAccountNumber(),
                            transaction.getDate(),
                            transaction.getType(),
                            transaction.getAmount()
                    );
                }
            } else if (account.getClass() == CompanyAccount.class) {
                System.out.printf("Company account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                        account.getAccountNumber(),
                        transaction.getDate(),
                        transaction.getType(),
                        transaction.getAmount()
                );
            }

        }
    }
}
