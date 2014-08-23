package com.tss.ocean.dao;

import com.tss.ocean.idao.IAccountsDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Accounts;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author bhavik.ambani
 */
@Repository("accountsDAO")
public class AccountsDAO extends GenericDAOImpl<Accounts, Integer> implements IAccountsDAO{

}
