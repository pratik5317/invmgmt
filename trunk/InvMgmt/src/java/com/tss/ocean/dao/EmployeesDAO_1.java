package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("employeesDAO_1")
public class EmployeesDAO_1 extends GenericDAOImpl<Employees, Integer> implements IEmployeesDAO {
}