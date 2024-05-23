package edu.miu.cs525.finalproject.framework.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Party {
    private String name;
    private String email;

    private Address address;
    private List<Account> accounts = new ArrayList<>();

    public Party(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void addAccount(Account account) {
        accounts.add(account);
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


    public abstract void sendEmailNotification(Account account,Transaction transaction);


}
