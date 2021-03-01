package com.example.bankservice.controller;

import com.example.bankservice.model.Account;
import com.example.bankservice.model.Role;
import com.example.bankservice.model.User;
import com.example.bankservice.model.enums.Currency;
import com.example.bankservice.service.RoleService;
import com.example.bankservice.service.TransactionService;
import com.example.bankservice.service.UserService;
import com.example.bankservice.service.impl.AccountServiceImpl;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInjection {
    private final RoleService roleService;
    private final UserService userService;
    private final AccountServiceImpl accountService;
    private final TransactionService transactionService;

    @PostConstruct
    public void inject() {
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);

        User user = new User();
        user.setName("user");
        user.setDateOfBirth(LocalDate.of(1034, 1, 1));
        user.setPhoneNumber("+380000000000");
        user.setPassword("1234");
        user.setRoles(Set.of(roleAdmin));
        userService.save(user);

        Account firstAccount = new Account();
        firstAccount.setActive(true);
        firstAccount.setUser(user);
        firstAccount.setAccountNumber("1111-1111");
        firstAccount.setBalance(1000.0);
        firstAccount.setCurrency(Currency.EUR);
        accountService.save(firstAccount);

        Account secondAccount = new Account();
        secondAccount.setActive(true);
        secondAccount.setUser(user);
        secondAccount.setAccountNumber("1111-1112");
        secondAccount.setBalance(100000.0);
        secondAccount.setCurrency(Currency.EUR);
        accountService.save(secondAccount);

        transactionService.save(firstAccount, secondAccount, 400.0);
        transactionService.save(firstAccount, secondAccount, 400.0);
        transactionService.save(firstAccount, secondAccount, 400.0);
        transactionService.save(firstAccount, secondAccount, 400.0);
        transactionService.save(firstAccount, secondAccount, 400.0);
        transactionService.save(firstAccount, secondAccount, 400.0);

        transactionService.getAllByAccount(0, 3, firstAccount).forEach(System.out::println);
        System.out.println(user.toString());
        System.out.println(firstAccount.toString());

        System.out.println(accountService.getByAccountNumber("1111-1111"));
        System.out.println(accountService.getById(1L));
    }
}
