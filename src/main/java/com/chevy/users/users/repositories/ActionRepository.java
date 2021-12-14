package com.chevy.users.users.repositories;

import com.chevyl.commons.users.models.Action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, String>{}
