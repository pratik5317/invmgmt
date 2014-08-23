package com.tss.ocean.dao;

import com.tss.ocean.idao.IPurorderdtDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Purorderdt;
import org.springframework.stereotype.Repository;

@Repository("purorderdtDAO")
public class PurorderdtDAO extends GenericDAOImpl<Purorderdt, Integer> implements IPurorderdtDAO{

}