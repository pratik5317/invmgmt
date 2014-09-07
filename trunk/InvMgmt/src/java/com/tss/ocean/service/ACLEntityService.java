/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.service;

import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.pojo.ACLEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bhavik
 */
@Service("aclEntityService")
public class ACLEntityService implements IACLEntiyService {
    
    @Autowired
    IACLEntityDAO aclEntityDAO;
    
    @Transactional
    @Override
    public int assignACL(int entityId,int entityType,String aclId,int permissionlevel) {
        revokeACL(entityId, entityType, aclId);
        ACLEntity aCLEntity = new ACLEntity();
        aCLEntity.setAclId(aclId);
        aCLEntity.setEntiyId(entityId);
        aCLEntity.setEntiyType(entityType);
        aCLEntity.setPermissionLevel(permissionlevel);
        return aclEntityDAO.insert(aCLEntity);
    }
    
    @Transactional
    @Override
    public void revokeACL(int entityId,int entityType,String aclId) {        
        List<ACLEntity> aclEntityList = aclEntityDAO.getListByCondition(" WHERE entityid="+entityId+" AND entitytype="+entityType+" AND aclId='"+aclId+"'");
        for (ACLEntity aCLEntity : aclEntityList) {
           aclEntityDAO.delete(aCLEntity);
        }
    }
    
    @Transactional
    @Override
    public void revokeAllACL(int entityId,int entityType) {        
        List<ACLEntity> aclEntityList = aclEntityDAO.getListByCondition(" WHERE entityid="+entityId+" AND entitytype="+entityType);
        for (ACLEntity aCLEntity : aclEntityList) {
           aclEntityDAO.delete(aCLEntity);
        }
    }
        
    @Transactional
    @Override
    public void revokeAllACL(String aclId) {        
        List<ACLEntity> aclEntityList = aclEntityDAO.getListByCondition(" WHERE aclid='"+aclId+"'");
        for (ACLEntity aCLEntity : aclEntityList) {
           aclEntityDAO.delete(aCLEntity);
        }
    }
}