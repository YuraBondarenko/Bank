package com.example.bankservice.repository;

import com.example.bankservice.model.Account;
import com.example.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "from Transaction t join fetch t.accountFrom account_from "
            + "join fetch t.accountTo account_to "
            + "where account_from = ?1 or account_to = ?1")
    List<Transaction> getAllByAccountNumber(Account account, Pageable pageable);
}
