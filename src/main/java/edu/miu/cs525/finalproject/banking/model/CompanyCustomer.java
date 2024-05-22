package edu.miu.cs525.finalproject.banking.model;

import edu.miu.cs525.finalproject.framework.model.Address;

public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String email, Address address) {
        super(name, email, address, CustomerType.COMPANY);
    }
}
