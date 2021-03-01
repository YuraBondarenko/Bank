package com.example.bankservice.model;

import com.example.bankservice.model.enums.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name = "account_number", nullable = false)
    private String accountNumber;
    @Min(0)
    private double balance;
    @Column(name = "is_active")
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private User user;

    public void setBalance(double balance) {
        if (balance <= 0) {
            throw new ArithmeticException("Balance after transaction cannot be less than 0");
        }
        this.balance = balance;
    }
}
