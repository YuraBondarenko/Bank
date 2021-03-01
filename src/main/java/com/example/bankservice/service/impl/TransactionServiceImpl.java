package com.example.bankservice.service.impl;

import com.example.bankservice.model.Account;
import com.example.bankservice.model.Transaction;
import com.example.bankservice.repository.TransactionRepository;
import com.example.bankservice.service.AccountService;
import com.example.bankservice.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Override
    public void save(Account accountTo, Account accountFrom, double amount) {
        Transaction transactionFrom = new Transaction();
        transactionFrom.setDate(LocalDateTime.now());
        transactionFrom.setType(Transaction.Type.OUTCOMING);
        transactionFrom.setAccountFrom(accountFrom);
        transactionFrom.setAccountTo(accountTo);
        transactionFrom.setAmount(amount);
        System.out.println(accountFrom.getBalance());
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        accountService.save(accountFrom);
        transactionRepository.save(transactionFrom);

        Transaction transactionTo = new Transaction();
        transactionTo.setDate(LocalDateTime.now());
        transactionTo.setType(Transaction.Type.INCOMING);
        transactionTo.setAccountTo(accountTo);
        transactionTo.setAccountFrom(accountFrom);
        transactionTo.setAmount(amount);
        accountTo.setBalance(accountTo.getBalance() + amount);
        accountService.save(accountTo);
        transactionRepository.save(transactionTo);
    }

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccountNumber(account, pageable);
    }
}
