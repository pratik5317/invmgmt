/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.pojo.ACL;
import com.tss.ocean.pojo.ACLEntity;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.Usertype;
import com.tss.ocean.util.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sweta
 */
@Repository("employeeCategoryDAO")
public class EmployeeCategoryDAO extends GenericDAOImpl<EmployeeCategory, Integer> implements IEmployeeCategoryDAO {

    @Autowired
    IACLEntityDAO aclEntityDAO;
    
    @Autowired
    IACLDAO aclDAO;
    
    @Override
    @Transactional
    public Integer insert(EmployeeCategory object) {
        int status = super.insert(object);
        List<ACL> aclList = aclDAO.getList();
        ACLEntity aclEntity;
        for(ACL acl:aclList) {
            aclEntity = new ACLEntity();
            aclEntity.setAclId(acl.getAclId());
            aclEntity.setEntityId(object.getId());
            aclEntity.setEntityType(Constants.ENTITY_GROUP);
            aclEntity.setPermissionLevel(Constants.ACL_NONE);
            aclEntityDAO.insert(aclEntity);
        }
        return status;
    }
}