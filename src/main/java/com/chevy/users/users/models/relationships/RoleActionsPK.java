package com.chevy.users.users.models.relationships;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoleActionsPK implements Serializable {

    @Column(name="role_id")
    private String roleId;

    @Column(name="action_id")
    private String actionId;


    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getActionId() {
        return this.actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

}
