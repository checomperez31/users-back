package com.chevy.users.users.service;

import java.util.List;
import java.util.Optional;

import com.chevyl.commons.users.models.Role;
import com.chevy.users.users.repositories.RoleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Role save(Role entity) {
        return this.repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Role> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Role> getOne(String id) {
        return this.repository.findById(id);
    }

    @Transactional()
    public void delete(String id) {
        Role entity = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setStatus( entity.getStatus() != null && entity.getStatus().equals("A") ? "I" : "A" );
        this.repository.save( entity );
    }
}
