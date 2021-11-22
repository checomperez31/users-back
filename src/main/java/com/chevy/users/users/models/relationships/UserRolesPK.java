package com.chevy.users.users.models.relationships;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRolesPK {
    @Column(name="role_id")
    private String roleId;

    @Column(name="user_id")
    private String userId;

    public UserRolesPK() {}

    public UserRolesPK(String roleId, String userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
