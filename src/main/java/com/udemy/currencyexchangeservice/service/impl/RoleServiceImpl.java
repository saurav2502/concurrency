package com.udemy.currencyexchangeservice.service.impl;

import com.udemy.currencyexchangeservice.aspect.ApiTimeLog;
import com.udemy.currencyexchangeservice.custom.AccessControl;
import com.udemy.currencyexchangeservice.service.Role;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements Role {

    @Override
    @ApiTimeLog
    public boolean checkRole() {
        return true;
    }

    @Override
    public boolean checkAccess() {
        return true;
    }
}
