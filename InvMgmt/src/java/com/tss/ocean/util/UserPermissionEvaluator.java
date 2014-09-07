/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.util;

import com.tss.ocean.idao.IUsersDAO;
import com.tss.ocean.pojo.Users;
import com.tss.ocean.service.IACLEntiyService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Bhavik
 */
public class UserPermissionEvaluator  implements PermissionEvaluator {
    
    private static final Logger logger = Logger.getLogger(UserPermissionEvaluator.class.getName());
    
    @Autowired
    IACLEntiyService aclEntityService;
    
    @Autowired
    IUsersDAO usersDAO;
    
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if(permission == null) {
            return false;
        }
        if(targetDomainObject == null) {
            return false;
        }
        if(authentication == null || authentication.getPrincipal() == null) {
            return false;
        }
        logger.log(Level.SEVERE," Asking permission {0} {1} {2}",new Object[]{authentication.getPrincipal().toString(),targetDomainObject,permission});
        if(!authentication.isAuthenticated()) {
            return false;
        }
        Users user = usersDAO.getRecordByKeyandValue("name", authentication.getPrincipal().toString());
        if(user == null) {
            return false;
        }
        Integer aclPermission = null;        
        if(permission.toString().equalsIgnoreCase("VIEW")) {
            aclPermission = Constants.ACL_VIEW;
        }
        else if(permission.toString().equalsIgnoreCase("ADD")) {
            aclPermission = Constants.ACL_CREATE;
        }
        else if(permission.toString().equalsIgnoreCase("UPDATE")) {
            aclPermission = Constants.ACL_UPDATE;
        }
        else if(permission.toString().equalsIgnoreCase("DELETE")) {
            aclPermission = Constants.ACL_DELETE;
        }
        if(aclPermission == null) {
            return false;
        }
        return aclEntityService.hasACL(user.getUsertypeid(), Constants.ENTITY_GROUP, targetDomainObject.toString().toLowerCase(), aclPermission);
    }
    @Override
    public boolean hasPermission(Authentication authentication,Serializable targetId, String targetType, Object permission) {
        logger.log(Level.SEVERE," Asking permission {0} {1} {2} {3}",new Object[]{authentication.getPrincipal(),targetId,targetType,permission});
        return true;
    }
}