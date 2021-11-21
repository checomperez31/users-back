package com.chevy.users.users.web;

import java.util.List;

import com.chevy.users.users.models.User;
import com.chevy.users.users.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User entity) {
        return ResponseEntity.ok().body(this.service.save(entity));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User entity) {
        return ResponseEntity.ok().body(this.service.save(entity));
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body( this.service.findAll() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable String id) {
        return ResponseEntity.ok().body( this.service.findOne(id).orElse(null) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
