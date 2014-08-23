package com.tss.ocean.dao;

import com.tss.ocean.idao.IEmployeeLeavesDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.EmployeeLeaves;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author bhavik.ambani
 */
@Repository("employeeLeavesDAO")
public class EmployeeLeavesDAO extends GenericDAOImpl<EmployeeLeaves, Integer> implements IEmployeeLeavesDAO{

}