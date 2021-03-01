package com.example.bankservice.repository;

import com.example.bankservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "from Account a join fetch a.user where a.accountNumber = ?1")
    Account getByAccountNumber(String accountNumber);

    @Query(value = "from Account a join fetch a.user where a.id = ?1")
    Account getById(Long id);
}
