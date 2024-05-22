package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Address;
import edu.miu.cs525.finalproject.framework.model.Party;

import java.time.LocalDate;

public abstract class Customer extends Party {
    private CustomerType customerType;
    public Customer(String name, String email, Address address, CustomerType customerType) {
        super(name, email, address);
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address=" + getAddress() +
                ", customerType=" + customerType +
                '}';
    }
}
