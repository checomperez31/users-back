package com.chevy.users.users.web;

import java.util.List;

import com.chevy.users.users.service.UserRolesService;
import com.chevy.users.users.service.dto.UserRolesModels;
import com.chevyl.commons.users.models.relationships.UserRoles;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-roles")
public class UserRolesController {

    private final UserRolesService service;

    public UserRolesController(UserRolesService service) {
        this.service = service;
    }

    @PostMapping("/list")
    public ResponseEntity<UserRolesModels> createList(@RequestBody UserRolesModels entities) {
        return ResponseEntity.ok().body( this.service.saveList( entities ) );
    }

    @PostMapping()
    public ResponseEntity<UserRoles> create(@RequestBody UserRoles entity) {
        return ResponseEntity.ok().body( this.service.save( entity ) );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserRoles>> getEntities(@PathVariable String userId, Pageable pageable) {
        List<UserRoles> page = this.service.findAll( userId, pageable ).getContent();
        return ResponseEntity.ok().body( page );
    }

    @GetMapping("/{userId}/{roleId}")
    public ResponseEntity<UserRoles> getOne(@PathVariable String userId, @PathVariable String roleId) {
        return ResponseEntity.ok().body( this.service.findOne(userId, roleId).orElse( null ) );
    }

    @DeleteMapping("/{userId}/{roleId}")
    public ResponseEntity<Void> delete(@PathVariable String userId, @PathVariable String roleId) {
        this.service.delete(userId, roleId);
        return ResponseEntity.ok().build();
    }
    
}
