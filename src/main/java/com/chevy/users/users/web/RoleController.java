package com.chevy.users.users.web;

import java.util.List;

import com.chevy.users.users.models.Role;
import com.chevy.users.users.service.RoleService;

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
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role entity) {
        return ResponseEntity.ok().body( this.service.save(entity) );
    }
    
    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role entity) {
        return ResponseEntity.ok().body( this.service.save(entity) );
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body( this.service.getAll() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable String id) {
        return ResponseEntity.ok().body( this.service.getOne( id )
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.service.delete( id );
        return ResponseEntity.ok().build();
    }
}
