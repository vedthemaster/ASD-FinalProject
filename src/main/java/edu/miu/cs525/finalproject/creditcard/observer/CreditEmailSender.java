package edu.miu.cs525.finalproject.creditcard.observer;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.model.TransactionType;
import edu.miu.cs525.finalproject.framework.observer.Observer;

public class CreditEmailSender implements Observer {
    private static volatile CreditEmailSender instance;

    private CreditEmailSender() {
    }

    public static CreditEmailSender getInstance() {
        if (instance == null) {
            synchronized (CreditEmailSender.class) {
                if (instance == null) {
                    instance = new CreditEmailSender();
                }
            }
        }
        return instance;
    }


    @Override
    public void update(Account account, Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT || transaction.getType() == TransactionType.WITHDRAW) {
            account.getCustomer().sendEmailNotification(account, transaction);
        }
    }


}
