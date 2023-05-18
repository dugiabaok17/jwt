package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UserService {
    Users findByUserName(String username);
    boolean existByUserName(String username);
    boolean existByEmail(String email);
    Users saveOrUpdate(Users user);
}
