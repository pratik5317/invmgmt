package com.tss.ocean.dao;

import com.tss.ocean.idao.IPrstatusDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Prstatus;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("prstatusDAO")
public class PrstatusDAO extends GenericDAOImpl<Prstatus, Integer> implements IPrstatusDAO {
}