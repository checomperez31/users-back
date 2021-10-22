package com.chevy.users.users.models.relationships;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="role_actions")
public class RoleActions {
    
    @EmbeddedId
    private RoleActionsPK id;

    public RoleActionsPK getId() {
        return this.id;
    }

    public void setId(RoleActionsPK id) {
        this.id = id;
    }
}
