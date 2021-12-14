package com.chevy.users.users.service;

import java.util.List;
import java.util.Optional;

import com.chevyl.commons.users.models.Action;
import com.chevy.users.users.repositories.ActionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ActionService {

    private final ActionRepository repository;

    public ActionService(ActionRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Action save(Action entity) {
        return this.repository.save(entity);
    }

    @Transactional(readOnly=true)
    public List<Action> getAllActions() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Action> getOne(String id) {
        return this.repository.findById(id);
    }

    @Transactional()
    public void delete(String id) {
        Action action = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        action.setStatus( action.getStatus() != null && action.getStatus().equals("A") ? "I" : "A" );
        this.repository.save( action );
    }
    
}
