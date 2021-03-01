package com.example.bankservice.repository;

import com.example.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @Query(value = "from User u join fetch u.roles where u.id = ?1")
    Optional<User> findById(Long id);

    @Query(value = "from User u join fetch u.roles where u.phoneNumber = ?1")
    Optional<User> getByPhoneNumber(String phoneNumber);
}
