/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aamir Mansuri
 */
@Repository("employeesDAO")
public class EmployeesDAO  extends GenericDAOImpl<Employees, Integer> implements IEmployeesDAO{
    
}
