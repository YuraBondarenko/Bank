package com.example.bankservice.controller;

import com.example.bankservice.model.Role;
import com.example.bankservice.model.User;
import com.example.bankservice.model.enums.RoleName;
import com.example.bankservice.service.RoleService;
import com.example.bankservice.service.UserService;
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

    @PostConstruct
    public void inject() {
        Role roleUser = new Role();
        roleUser.setRoleName(RoleName.USER);
        roleService.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setRoleName(RoleName.ADMIN);
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
