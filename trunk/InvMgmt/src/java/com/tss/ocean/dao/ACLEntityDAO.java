/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.pojo.ACLEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bhavik
 */
@Repository("aclEntityDAO")
public class ACLEntityDAO extends GenericDAOImpl<ACLEntity, Integer> implements IACLEntityDAO {
    
}
