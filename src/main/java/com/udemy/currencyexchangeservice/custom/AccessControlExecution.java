package com.udemy.currencyexchangeservice.custom;

import com.udemy.currencyexchangeservice.service.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessControlExecution {
    static final Logger log = LoggerFactory.getLogger(AccessControlExecution.class);

    @Autowired
    private Role role;

    @Before("@annotation(AccessControl)")
    public void checkRoleWithAccessControl(){
        boolean hasRole = role.checkRole();
        boolean hasPermission = role.checkAccess();
        log.info("hasRole: "+hasRole + ", hasPermission: "+hasPermission);
        if (!hasPermission){
            throw new IllegalArgumentException("Access Permission Exist");
        }
        if (!hasRole){
            throw new IllegalArgumentException("Role Exist");
        }
    }

}
