package com.tss.ocean.dao;

import com.tss.ocean.idao.IUsertypeDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Usertype;
import org.springframework.stereotype.Repository;

@Repository("usertypeDAO")
public class UsertypeDAO extends GenericDAOImpl<Usertype, Integer> implements IUsertypeDAO{

}