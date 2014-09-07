package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.idao.IUsertypeDAO;
import com.tss.ocean.pojo.ACL;
import com.tss.ocean.pojo.ACLEntity;
import com.tss.ocean.pojo.Usertype;
import com.tss.ocean.util.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usertypeDAO")
public class UsertypeDAO extends GenericDAOImpl<Usertype, Integer> implements IUsertypeDAO{

    @Autowired
    IACLEntityDAO aclEntityDAO;
    
    @Autowired
    IACLDAO aclDAO;
    
    @Override
    @Transactional
    public Integer insert(Usertype object) {
        int status = super.insert(object); //To change body of generated methods, choose Tools | Templates.
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