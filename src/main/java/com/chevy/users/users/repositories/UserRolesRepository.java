package com.chevy.users.users.repositories;

import com.chevy.users.users.models.relationships.UserRoles;
import com.chevy.users.users.models.relationships.UserRolesPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesPK> {
    
}
