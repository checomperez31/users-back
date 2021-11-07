package com.chevy.users.users.service;

import java.util.Optional;

import com.chevy.users.users.models.relationships.RoleActions;
import com.chevy.users.users.models.relationships.RoleActionsPK;
import com.chevy.users.users.repositories.RoleActionsRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleActionsService {
    private final RoleActionsRepository repository;

    public RoleActionsService(RoleActionsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public RoleActions save(RoleActions entity) {
        return this.repository.save(entity);
    }

    @Transactional(readOnly = false)
    public Page<RoleActions> findAll(String roleId, Pageable pageable) {
        return this.repository.findAllById_RoleId(roleId, pageable);
    }

    @Transactional(readOnly = false)
    public Optional<RoleActions> findOne(String roleId, String actionId) {
        return this.repository.findById(new RoleActionsPK( roleId, actionId ));
    }

    @Transactional
    public void delete(String roleId, String actionId) {
        this.repository.deleteById( new RoleActionsPK( roleId, actionId ) );
    }

}
