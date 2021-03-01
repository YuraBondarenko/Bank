package com.example.bankservice.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(unique = true, name = "phone_number", nullable = false)
    private String phoneNumber;
    @ToString.Exclude
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @Column(nullable = false)
    private Set<Role> roles;
}
