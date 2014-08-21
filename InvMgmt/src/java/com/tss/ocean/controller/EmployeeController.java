/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.techshark.hibernate.base.HibernateDAOFactory;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 *
 * @author Aamir Mansuri
 */
@Controller
public class EmployeeController {

    //get log4j handler  
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    IEmployeesDAO employeesDAO;

    public EmployeeController() {
        employeesDAO = new HibernateDAOFactory().getEmployeesDAO();
    }

    @RequestMapping(value = "/addemployee.html", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employees employee, Model model) {

        logger.debug("addEmployee called :"+employee);
        
        int status = employeesDAO.insert(employee);
        logger.debug("addEmployee insert status:"+status);

        return new ModelAndView("employees");
    }
}
