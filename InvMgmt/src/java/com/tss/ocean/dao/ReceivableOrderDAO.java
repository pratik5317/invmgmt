/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IReceivableOrderDAO;
import com.tss.ocean.pojo.ReceivableOrder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ssweta
 */
@Repository("receivableOrderDAO")
public class ReceivableOrderDAO extends GenericDAOImpl<ReceivableOrder, Integer> implements IReceivableOrderDAO{
    
}
