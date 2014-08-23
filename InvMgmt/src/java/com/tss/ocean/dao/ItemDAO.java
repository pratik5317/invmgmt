package com.tss.ocean.dao;

import com.tss.ocean.idao.IItemDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Item;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("itemDAO")
public class ItemDAO extends GenericDAOImpl<Item, Integer> implements IItemDAO {
}