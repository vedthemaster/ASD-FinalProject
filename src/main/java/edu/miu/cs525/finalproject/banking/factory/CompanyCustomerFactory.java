package edu.miu.cs525.finalproject.banking.factory;

import edu.miu.cs525.finalproject.banking.model.CompanyCustomer;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.framework.model.Address;

public class CompanyCustomerFactory implements CustomerFactory {
    @Override
    public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
        Address address = new Address(street, city, state, zip);
        Customer customer = new CompanyCustomer(name, email, address);
        return customer;
    }
}
