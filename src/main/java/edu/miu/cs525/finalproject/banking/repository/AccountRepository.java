package edu.miu.cs525.finalproject.banking.repository;

import edu.miu.cs525.finalproject.banking.model.Account;
import edu.miu.cs525.finalproject.framework.service.CommonRepository;

import java.util.Collection;
import java.util.List;

public interface AccountRepository extends CommonRepository<Account> {
    Account getOne(String accountNumber);
}
