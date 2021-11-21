package com.chevy.users.users.service;

import java.util.List;
import java.util.Optional;

import com.chevy.users.users.models.User;
import com.chevy.users.users.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserService {
    
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User save(User entity) {
        return this.repository.save( entity );
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findOne(String id) {
        return this.repository.findById(id);
    }

    @Transactional
    public void delete(String id) {
        this.findOne( id ).ifPresent(entity -> {
            String status = entity.getStatus() != null && entity.getStatus().equals("A") ? "I": "A";
            entity.setStatus( status );
            this.repository.save( entity );
        });
    }
}
