package com.chevy.users.users.repositories;

import com.chevyl.commons.users.models.relationships.UserRoles;
import com.chevyl.commons.users.models.relationships.UserRolesPK;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesPK> {
    Page<UserRoles> findAllById_UserId(String userId, Pageable pageable);
}
