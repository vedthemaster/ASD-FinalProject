package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Transaction;

public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String email, Address address) {
        super(name, email, address, CustomerType.COMPANY);
    }

    @Override
    public void sendEmailNotification(Account account, Transaction transaction) {
        System.out.printf("Company account email notification: Account %s - Date: %s - Type: %s - Amount: %,.2f\n",
                account.getAccountNumber(),
                transaction.getDate(),
                transaction.getType(),
                transaction.getAmount()
        );
    }
}
