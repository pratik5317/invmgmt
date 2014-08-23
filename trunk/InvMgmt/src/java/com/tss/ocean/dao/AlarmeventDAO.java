package com.tss.ocean.dao;

import com.tss.ocean.idao.IAlarmeventDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Alarmevent;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author bhavik.ambani
 */
@Repository("alarmeventDAO")
public class AlarmeventDAO extends GenericDAOImpl<Alarmevent, Integer> implements IAlarmeventDAO{

}