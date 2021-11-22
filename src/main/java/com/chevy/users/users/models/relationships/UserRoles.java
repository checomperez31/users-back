package com.chevy.users.users.models.relationships;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.chevy.users.users.models.Role;

@Entity
@Table(name="user_roles")
public class UserRoles {
    
    @EmbeddedId
    private UserRolesPK id;

    @MapsId("roleId")
    @ManyToOne
    private Role role;

    public UserRolesPK getId() {
        return id;
    }

    public void setId(UserRolesPK id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
