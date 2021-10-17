package com.chevy.users.users.web;

import java.util.List;

import com.chevy.users.users.models.Action;
import com.chevy.users.users.service.ActionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/action")
public class ActionController {

    private final ActionService service;

    public ActionController(ActionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Action> save(@RequestBody Action entity) {
        return ResponseEntity.ok().body( this.service.save(entity) );
    }
    
    @PutMapping
    public ResponseEntity<Action> update(@RequestBody Action entity) {
        return ResponseEntity.ok().body( this.service.save(entity) );
    }

    @GetMapping
    public ResponseEntity<List<Action>> getActions() {
        return ResponseEntity.ok().body( this.service.getAllActions() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Action> getAction(@PathVariable String id) {
        return ResponseEntity.ok().body( this.service.getOne( id )
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}