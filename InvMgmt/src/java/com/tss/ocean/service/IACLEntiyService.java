/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.service;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bhavik
 */
public interface IACLEntiyService {

    @Transactional
    int assignACL(int entityId, int entityType, String aclId, int permissionlevel);

    @Transactional
    void revokeACL(int entityId, int entityType, String aclId);

    @Transactional
    void revokeAllACL(int entityId, int entityType);

    @Transactional
    void revokeAllACL(String aclId);
    
    boolean hasACL(int entityId,int entityType,String aclId,int permissionLevel);
}
