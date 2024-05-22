package edu.miu.cs525.finalproject.banking.repository;
import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.banking.model.Customer;
import edu.miu.cs525.finalproject.framework.service.CommonRepository;

public interface CustomerRepository extends CommonRepository<Customer>{
    Customer getOne(String email);
    void addAccount(String email, Account account);
}
