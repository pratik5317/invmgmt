package com.tss.ocean.dao;

import com.tss.ocean.idao.IEmployeeAttendancesDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.EmployeeAttendances;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("employeeAttendancesDAO")
public class EmployeeAttendancesDAO extends GenericDAOImpl<EmployeeAttendances, Integer> implements IEmployeeAttendancesDAO {
}
