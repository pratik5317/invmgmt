package com.tss.ocean.dao;

import com.tss.ocean.idao.IItemunitDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Itemunit;
import org.springframework.stereotype.Repository;

@Repository("itemunitDAO")
public class ItemunitDAO extends GenericDAOImpl<Itemunit, Integer> implements IItemunitDAO {
}