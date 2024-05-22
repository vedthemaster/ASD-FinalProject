package edu.miu.cs525.finalproject.creditcard.model;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Party;
import edu.miu.cs525.finalproject.framework.model.Transaction;
import edu.miu.cs525.finalproject.framework.strategy.InterestStrategy;


public class PersonalAccount extends Party {

    public PersonalAccount(String name, String email, Address address) {
        super(name, email, address);
    }


}