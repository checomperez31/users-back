package com.chevy.users.users.service;

import java.util.Optional;

import com.chevy.users.users.models.relationships.UserRoles;
import com.chevy.users.users.models.relationships.UserRolesPK;
import com.chevy.users.users.repositories.UserRolesRepository;
import com.chevy.users.users.service.dto.UserRolesModels;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRolesService {

    private final UserRolesRepository repository;

    public UserRolesService(UserRolesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserRolesModels saveList(UserRolesModels entities) {
        if ( entities != null && entities.getEntities() != null && entities.getEntities().size() > 0 ) {
            for ( UserRoles entity: entities.getEntities() ) {
                this.save( entity );
            }
        }
        return entities;
    }

    @Transactional
    public UserRoles save( UserRoles entity ) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public Page<UserRoles> findAll(String userId, Pageable pageable) {
        return this.repository.findAllById_UserId(userId, pageable);
    }

    @Transactional(readOnly = true)
    public Optional<UserRoles> findOne( String userId, String roleId ) {
        return this.repository.findById( new UserRolesPK(roleId, userId) );
    }

    @Transactional
    public void delete(String userId, String roleId) {
        this.repository.deleteById( new UserRolesPK( roleId, userId ) );
    }
    
}
