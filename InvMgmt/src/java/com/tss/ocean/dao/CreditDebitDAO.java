/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.idao.ICreditDebitDAO;
import com.tss.ocean.pojo.ACL;
import com.tss.ocean.pojo.CreditDebit;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ssweta
 */
@Repository("creditDebitDAO")
public class CreditDebitDAO extends GenericDAOImpl<CreditDebit, Integer> implements ICreditDebitDAO{
    
}
