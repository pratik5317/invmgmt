/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.techshark.hibernate.base.HibernateDAOFactory;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.EmployeePostion;
import com.tss.ocean.pojo.Employees;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aamir Mansuri
 */
@Controller
public class EmployeeController {

    //get log4j handler  
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    IEmployeesDAO employeesDAO;
    IEmployeeCategoryDAO employeeCategoryDAO;

    public EmployeeController() {
        employeesDAO = new HibernateDAOFactory().getEmployeesDAO();
        employeeCategoryDAO = new HibernateDAOFactory().getEmployeeCategoryDAO();
    }

    @RequestMapping(value = "/addemployee.html", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employees employee, Model model) {

        logger.debug("addEmployee called :" + employee);

        int status = employeesDAO.insert(employee);
        logger.debug("addEmployee insert status:" + status);

        return new ModelAndView("employees");
    }

    @RequestMapping(value = "/addemployeecategory.html", method = RequestMethod.POST)
    public ModelAndView addEmployeeCategory(Model model, HttpServletRequest request) {

        logger.debug("addEmployeeCategory called :" + request.getParameter("category"));
        EmployeeCategory employeeCategory = new EmployeeCategory();
        employeeCategory.setCategory(request.getParameter("category"));

        int status = employeeCategoryDAO.insert(employeeCategory);
        logger.debug("addEmployeeCategory insert status:" + status);

        return new ModelAndView("employees");
    }
}
