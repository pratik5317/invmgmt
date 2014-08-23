package com.tss.ocean.dao;

import com.tss.ocean.idao.IAlarmsDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Alarms;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author bhavik.ambani
 */
@Repository("alarmsDAO")
public class AlarmsDAO extends GenericDAOImpl<Alarms, Integer> implements IAlarmsDAO{

}