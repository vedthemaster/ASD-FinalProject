package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Party;

import java.time.LocalDate;

public class Customer extends Party {
    public Customer(String name, String email, Address address) {
        super(name, email, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address=" + getAddress() +
                '}';
    }
}
