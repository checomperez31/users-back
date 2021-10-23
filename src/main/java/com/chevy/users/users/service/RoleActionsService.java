package com.chevy.users.users.service;

import javax.transaction.Transactional;

import com.chevy.users.users.repositories.RoleActionsRespository;

import org.springframework.stereotype.Service;

@Service
public class RoleActionsService {
    private final RoleActionsRespository respository;

    public RoleActionsService(RoleActionsRespository respository) {
        this.respository = respository;
    }
}
