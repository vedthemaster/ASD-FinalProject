package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.model.Customer;

public interface CustomerFactory {
    Customer createCustomer(String name, String email, String street, String city, String state, String zip);
}
