package com.example.bankservice.service;

import com.example.bankservice.model.Account;

public interface AccountService {
    Account save(Account account);

    Account getByAccountNumber(String accountNumber);

    Account getById(Long id);
}
