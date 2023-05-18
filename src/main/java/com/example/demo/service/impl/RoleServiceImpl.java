package com.example.demo.service.impl;

import com.example.demo.entity.Roles;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RolesService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Roles> findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
