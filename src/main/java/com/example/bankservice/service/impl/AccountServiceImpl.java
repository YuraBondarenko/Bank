package com.example.bankservice.service.impl;

import com.example.bankservice.model.Account;
import com.example.bankservice.repository.AccountRepository;
import com.example.bankservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getByAccountNumber(String accountNumber) {
        return accountRepository.getByAccountNumber(accountNumber);
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.getById(id);
    }
}
