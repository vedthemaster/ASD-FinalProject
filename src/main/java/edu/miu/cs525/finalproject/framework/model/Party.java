package edu.miu.cs525.finalproject.framework.model;

import edu.miu.cs525.finalproject.framework.observer.Observer;
import edu.miu.cs525.finalproject.framework.service.EmailService;

import java.util.ArrayList;
import java.util.List;

public abstract class Party implements Observer {
    private String name;
    private String email;

    private Address address;
    private List<Account> accounts = new ArrayList<>();

    public Party(String name, String email,Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.addObserver(this);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public void update(Account account, Transaction transaction) {
        if (transaction.getType().equals(TransactionType.WITHDRAW) && transaction.getAmount() > 400) {
            EmailService.sendEmail(email, "Large Transaction Alert", "A large withdrawal was made from your account: " + transaction.getAmount());
        }
    }
}
