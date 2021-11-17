package com.chevy.users.users.models.relationships;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.chevy.users.users.models.Action;

@Entity
@Table(name="role_actions")
public class RoleActions {
    
    @EmbeddedId
    private RoleActionsPK id;

    @MapsId("actionId")
    @ManyToOne
    private Action action;

    public RoleActionsPK getId() {
        return this.id;
    }

    public void setId(RoleActionsPK id) {
        this.id = id;
    }


    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
