package com.tss.ocean.dao;

import com.tss.ocean.idao.IEmployeeLeaveTypesDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.EmployeeLeaveTypes;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("employeeLeaveTypesDAO")
public class EmployeeLeaveTypesDAO extends GenericDAOImpl<EmployeeLeaveTypes, Integer> implements IEmployeeLeaveTypesDAO {
}