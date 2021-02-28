package com.example.bankservice.controller;

import com.example.bankservice.model.Role;
import com.example.bankservice.model.User;
import com.example.bankservice.service.RoleService;
import com.example.bankservice.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInjection {
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public DataInjection(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

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
    }
}
