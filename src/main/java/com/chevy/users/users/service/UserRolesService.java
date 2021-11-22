package com.chevy.users.users.service;

import com.chevy.users.users.models.relationships.UserRolesPK;
import com.chevy.users.users.repositories.UserRolesRepository;

import org.springframework.stereotype.Service;

@Service
public class UserRolesService {

    private final UserRolesRepository repository;

    public UserRolesService(UserRolesRepository repository) {
        this.repository = repository;
    }
    
}
