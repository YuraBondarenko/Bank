package com.example.bankservice.service.impl;

import com.example.bankservice.model.Role;
import com.example.bankservice.repository.RoleRepository;
import com.example.bankservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getByName(Role.RoleName.valueOf(name)).get();
    }
}
