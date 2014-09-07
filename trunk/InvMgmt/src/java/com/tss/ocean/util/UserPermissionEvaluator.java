/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.util;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Bhavik
 */
public class UserPermissionEvaluator  implements PermissionEvaluator {
    
    private static final Logger logger = Logger.getLogger(UserPermissionEvaluator.class.getName());
    
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        logger.log(Level.SEVERE," Asking permission {0} {1} {2}",new Object[]{authentication.getPrincipal().toString(),targetDomainObject,permission});
        return false;
    }
    @Override
    public boolean hasPermission(Authentication authentication,Serializable targetId, String targetType, Object permission) {
        logger.log(Level.SEVERE," Asking permission {0} {1} {2} {3}",new Object[]{authentication.getPrincipal(),targetId,targetType,permission});
        return true;
    }
}