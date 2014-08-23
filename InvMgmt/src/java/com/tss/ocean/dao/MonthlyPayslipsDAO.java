package com.tss.ocean.dao;

import com.tss.ocean.idao.IMonthlyPayslipsDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.MonthlyPayslips;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author bhavik.ambani
 */
@Repository("monthlyPayslipsDAO")
public class MonthlyPayslipsDAO extends GenericDAOImpl<MonthlyPayslips, Integer> implements IMonthlyPayslipsDAO{

}