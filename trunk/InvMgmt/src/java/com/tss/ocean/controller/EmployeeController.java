/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.techshark.hibernate.base.HibernateDAOFactory;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Accounts;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.Purorder;
import com.tss.ocean.pojo.Purrequisition;
import com.tss.ocean.util.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
   @Autowired
    private MessageSource messageSource;
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


     @RequestMapping(value="/employee_category.html",method= RequestMethod.GET)
    public ModelAndView employeeCategory(@RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error,
                                    Locale locale) throws Exception {
        logger.info("employee_categogy called.");
        ModelAndView mav = new ModelAndView("employee_category");
        List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
            
        mav.getModelMap().put("employeeCategoryList",employeeCategoryList);
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }
    @RequestMapping(value="/add_employee_category",method= RequestMethod.GET)
    public ModelAndView add_employee_cat_get(@RequestParam(value = "success",required = false)String success,
                                                @RequestParam(value = "error",required = false)String error,
                                                Locale locale) throws Exception {
        logger.info("add_employee_category called.");
        ModelAndView mav = new ModelAndView("add_employee_category");
        EmployeeCategory employeeCategory = new EmployeeCategory();
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("employeecategory", employeeCategory);
        return mav;
    }
    @RequestMapping(value="/add_employee_category.html",method= RequestMethod.POST)
    public ModelAndView addEmployeeCategory(@ModelAttribute("employeecategory") @Valid EmployeeCategory employeeCategory,
                                        BindingResult result,
                                        ModelMap model,                                        
                                        Locale locale) throws Exception {
        logger.info("add_employee_category-post called.");
        if (!result.hasErrors()) {
            employeeCategory.setIsActive(1);
            int insertResult = employeeCategoryDAO.insert(employeeCategory);
            if(insertResult > 0) {
                logger.info( "Purorder Added Successfully with id " +  insertResult);
                return new ModelAndView("redirect:add_employee_category.html")
                    .addObject("success",Utilities.getSpringMessage(messageSource,"empcategory.add.success",locale));
            }
            else {
                logger.info("Error while inserting " + employeeCategory);
//                model.put("supplierList",getSupplierList());
//                model.put("purrequisitionList",getPurrequisitionList());                
                return new ModelAndView("add_employee_category",model)
                    .addObject("error",Utilities.getSpringMessage(messageSource,"empcategory.add.error", locale));
            }
        }
        else {
//            logger.log(Level.WARNING, "Purchase_order values are not valid:", purorder.toString());
//            model.put("supplierList",getSupplierList());
//            mod/el.put("purrequisitionList",getPurrequisitionList());            
            return new ModelAndView("add-purchase_order",model);
        }
    }
}
