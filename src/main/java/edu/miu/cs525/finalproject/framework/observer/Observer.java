package edu.miu.cs525.finalproject.framework.observer;

import edu.miu.cs525.finalproject.framework.model.Account;
import edu.miu.cs525.finalproject.framework.model.Transaction;

public interface Observer {
    void update(Account account, Transaction transaction);
}
