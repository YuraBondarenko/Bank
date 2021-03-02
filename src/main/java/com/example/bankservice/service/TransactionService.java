package com.example.bankservice.service;

import com.example.bankservice.model.Account;
import com.example.bankservice.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void save(Account accountTo, Account accountFrom, BigDecimal amount);

    List<Transaction> getAllByAccount(int page, int size, Account account);
}
