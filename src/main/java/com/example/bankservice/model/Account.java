package com.example.bankservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    private double balance;
    @Column(name = "is_active")
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @OneToOne
    @MapsId
    private User user;

    public enum Currency {
        USD, EUR, UAH;
    }
}
