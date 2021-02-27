package com.example.bankservice.repository;

import com.example.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "from Role where roleName = ?1")
    Optional<Role> getByName(String name);
}
