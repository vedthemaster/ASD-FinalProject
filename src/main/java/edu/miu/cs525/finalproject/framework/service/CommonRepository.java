package edu.miu.cs525.finalproject.framework.service;

import edu.miu.cs525.finalproject.banking.model.Account;

import java.util.List;

public interface CommonRepository<T> {
    void save(T t);
    void update(T t);
    T getOne(Long id);
    List<T> getAll();
}
