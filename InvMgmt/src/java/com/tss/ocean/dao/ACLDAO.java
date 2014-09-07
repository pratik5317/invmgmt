/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.pojo.ACL;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bhavik
 */
@Repository("aclDAO")
public class ACLDAO extends GenericDAOImpl<ACL, String> implements IACLDAO{
    
}
