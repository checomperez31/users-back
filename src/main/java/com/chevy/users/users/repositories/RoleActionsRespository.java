package com.chevy.users.users.repositories;

import com.chevy.users.users.models.relationships.RoleActions;
import com.chevy.users.users.models.relationships.RoleActionsPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleActionsRespository extends JpaRepository<RoleActions, RoleActionsPK> {}
