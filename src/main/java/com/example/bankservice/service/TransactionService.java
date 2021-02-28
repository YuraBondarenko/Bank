package com.example.bankservice.service;

import com.example.bankservice.model.Account;
import com.example.bankservice.model.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllByAccount(int page, int size, Account account);
}
