package com.example.bankservice.model;

import com.example.bankservice.model.enums.Type;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDateTime date;
    @Column(name = "account_from")
    @OneToOne
    private Account accountFrom;
    @Column(name = "account_to")
    @OneToOne
    private Account accountTo;
    @Enumerated(EnumType.STRING)
    private Type type;
}
