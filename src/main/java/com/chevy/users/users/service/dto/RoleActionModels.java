package com.chevy.users.users.service.dto;

import java.util.List;

import com.chevyl.commons.users.models.relationships.RoleActions;

public class RoleActionModels {
    private List<RoleActions> entities;

    public List<RoleActions> getEntities() {
        return this.entities;
    }

    public void setEntities(List<RoleActions> entities) {
        this.entities = entities;
    }

}
