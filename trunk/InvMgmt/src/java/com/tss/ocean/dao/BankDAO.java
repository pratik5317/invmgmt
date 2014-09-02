/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IBankDAO;
import com.tss.ocean.pojo.Bank;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sweta
 */
@Repository("bankDAO")
public class BankDAO extends GenericDAOImpl<Bank, Integer> implements IBankDAO{
    
}
