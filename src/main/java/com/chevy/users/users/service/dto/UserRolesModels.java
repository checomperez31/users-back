package com.chevy.users.users.service.dto;

import java.util.List;

import com.chevy.users.users.models.relationships.UserRoles;

public class UserRolesModels {
    private List<UserRoles> entities;

    public List<UserRoles> getEntities() {
        return entities;
    }

    public void setEntities(List<UserRoles> entities) {
        this.entities = entities;
    }
}