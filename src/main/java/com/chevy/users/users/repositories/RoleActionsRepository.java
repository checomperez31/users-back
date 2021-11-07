package com.chevy.users.users.repositories;

import com.chevy.users.users.models.relationships.RoleActions;
import com.chevy.users.users.models.relationships.RoleActionsPK;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleActionsRepository extends JpaRepository<RoleActions, RoleActionsPK> {
    Page<RoleActions> findAllById_RoleId(String roleId, Pageable pageable);
}
