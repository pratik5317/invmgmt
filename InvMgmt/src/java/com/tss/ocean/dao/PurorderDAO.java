package com.tss.ocean.dao;

import com.tss.ocean.idao.IPurorderDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Purorder;
import org.springframework.stereotype.Repository;

@Repository("purorderDAO")
public class PurorderDAO extends GenericDAOImpl<Purorder, Integer> implements IPurorderDAO{

}