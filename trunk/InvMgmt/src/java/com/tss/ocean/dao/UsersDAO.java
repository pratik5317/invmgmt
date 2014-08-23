package com.tss.ocean.dao;

import com.tss.ocean.idao.IUsersDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository("usersDAO")
public class UsersDAO extends GenericDAOImpl<Users, Integer> implements IUsersDAO{

}