package com.chevy.users.users.web;

import java.util.List;

import com.chevy.users.users.models.relationships.RoleActions;
import com.chevy.users.users.service.RoleActionsService;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/role-actions")
public class RoleActionsController {
    private final RoleActionsService service;

    public RoleActionsController(RoleActionsService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<RoleActions> create(RoleActions entity) {
        return ResponseEntity.ok().body( this.service.save(entity) );
    }

    @GetMapping()
    public ResponseEntity<List<RoleActions>> getEntities(Pageable pageable) {
        List<RoleActions> page = this.service.findAll( pageable ).getContent();
        return ResponseEntity.ok().body( page );
    }

    @GetMapping("/{roleId}/{actionId}")
    public ResponseEntity<RoleActions> getOne(@PathVariable String roleId, @PathVariable String actionId) {
        return ResponseEntity.ok().body( this.service.findOne(roleId, actionId).orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND )) );
    }

    @DeleteMapping("/{roleId}/{actionId}")
    public ResponseEntity<Void> delete(@PathVariable String roleId, @PathVariable String actionId) {
        this.service.delete(roleId, actionId);
        return ResponseEntity.ok().build();
    }
}
