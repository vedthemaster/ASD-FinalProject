package edu.miu.cs525.finalproject.banking.repository.implement;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.banking.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customers.add(customer);
        printCustomers();
    }

    @Override
    public void update(Customer customer) {
        Customer accountExist = getOne(customer.getEmail());
        if (accountExist != null) {
            customers.remove(accountExist);
            customers.add(customer);
        }
    }

    @Override
    public Customer getOne(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) return customer;
        }
        return null;
    }

    @Override
    public void addAccount(String email, Account account) {
        Customer customer = getOne(email);
        if (customer != null) {
            customer.addAccount(account);
            update(customer);
        }
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
    @Override
    public Customer getOne(Long id) {
        return null;
    }
    public void printCustomers() {
        System.out.println("customers: ");
        customers.forEach(System.out::println);
    }
}
