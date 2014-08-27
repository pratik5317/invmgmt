/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeeDepartmentDAO;
import com.tss.ocean.pojo.EmployeeDepartment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sweta
 */
@Repository("employeeDepartmentDAO")
public class EmployeeDepartmentDAO extends GenericDAOImpl<EmployeeDepartment, Integer> implements IEmployeeDepartmentDAO {
    
}
