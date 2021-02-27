package com.example.bankservice.service;

import com.example.bankservice.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
