package com.example.bankservice.service;

import com.example.bankservice.model.User;

public interface UserService {
    User save(User user);

    void delete(User user);

    User getById(Long id);

    User getByPhoneNumber(String phoneNumber);
}
