package edu.miu.cs525.finalproject.framework.model;

import edu.miu.cs525.finalproject.framework.observer.Observer;
import edu.miu.cs525.finalproject.framework.service.EmailService;

import java.util.ArrayList;
import java.util.List;

public abstract class Party implements Observer {
    protected String name;
    protected String email;
    protected List<Account> accounts = new ArrayList<>();

    public Party(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public void update(Account account, Transaction transaction) {
        if (transaction.getType().equals("withdraw") && transaction.getAmount() > 400) {
            EmailService.sendEmail(email, "Large Transaction Alert", "A large withdrawal was made from your account: " + transaction.getAmount());
        }
    }
}
