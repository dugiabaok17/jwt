package com.example.demo.service;

import com.example.demo.entity.Roles;

import java.util.Optional;

public interface RolesService {
    Optional<Roles> findByRoleName(String roleName);
}
