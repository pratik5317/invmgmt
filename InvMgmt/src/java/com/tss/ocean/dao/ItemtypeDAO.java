package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.pojo.Itemtype;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("itemTypeDAO")
public class ItemtypeDAO extends GenericDAOImpl<Itemtype, Integer> implements IItemtypeDAO {
}