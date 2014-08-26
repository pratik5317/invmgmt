/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.Itemtype;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aamir Mansuri
 */
@Controller
public class ViewController {
    
    @Autowired
    IItemtypeDAO itemTypeDAO;
    
    private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @RequestMapping(value="/inventory_management.html",method= RequestMethod.GET)
    public String inventorymgmt(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"inventory_management called.");
        return "item";
    }
    
    @RequestMapping(value="/item.html",method= RequestMethod.GET)
    public String itemmgmt(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"item called.");
        return "item";
    }
    
    @RequestMapping(value="/item_category.html",method= RequestMethod.GET)
    public String item_category(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"item_category called.");
        logger.log(Level.OFF,"List details are loaded by the system.");
        logger.log(Level.OFF,itemTypeDAO.getList().toString());
        List<Itemtype> itemTypeList = itemTypeDAO.getList();
        
        model.addAttribute("itemTypeList", itemTypeList);
        
        return "item_category";
    }
    
    @RequestMapping(value="/item_unit.html",method= RequestMethod.GET)
    public String item_unit(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"item_unit called.");
        return "item_unit";
    }
    
    @RequestMapping(value="/add-item.html",method= RequestMethod.GET)
    public String add_item(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item called.");
        return "add-item";
    }

    @RequestMapping(value="/add-item_category.html",method= RequestMethod.GET)
    public String add_item_category(Map<String, Object> model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item_category called.");
        Itemtype itemtype = new Itemtype();
        model.put("itemTypeForm", itemtype);
        return "add-item_category";
    }
    @RequestMapping(value="/add-item_unit.html",method= RequestMethod.GET)
    public String add_item_unit(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item_unit called.");
        return "add-item_unit";
    }
    
    ///View for HR Modules...
    @RequestMapping(value="/hr_management.html",method= RequestMethod.GET)
    public String hr_management(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"hr_management called.");
        return "hr/hr_management";
    }

    @RequestMapping(value="/employees.html",method= RequestMethod.GET)
    public String employees(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"hr_management called.");
        return "hr/hr_management";
    }
    
    @RequestMapping(value="/addemployee.html",method= RequestMethod.GET)
    public String hr_addemployee(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"hr_addemployee called.");
        model.addAttribute("employee",new Employees());
        return "hr/hr_add_employee";
    }
    @RequestMapping(value="/employee_categogy.html",method= RequestMethod.GET)
    public String hr_addemployeeCategory(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"hr_addemployee called.");
        model.addAttribute("employeecategory",new EmployeeCategory());
        return "hr/hr_add_employee_category";
    }
    
    @RequestMapping(value="/payslips.html",method= RequestMethod.GET)
    public String hr_payslip(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"payslips called.");
        return "hr/payslips";
    }
    
    @RequestMapping(value="/create_payslip.html",method= RequestMethod.GET)
    public String create_payslip(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"create_payslip called.");
        return "hr/create_payslip";
    }
    @RequestMapping(value="/leave_types.html",method= RequestMethod.GET)
    public String leave_types(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"leave_types called.");
        return "hr/leave_types";
    }

    @RequestMapping(value="/add_leave_type.html",method= RequestMethod.GET)
    public String add_leave_type(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add_leave_type called.");
        return "hr/add_leave_type";
    }
    
    @RequestMapping(value="/attendences.html",method= RequestMethod.GET)
    public String attendences(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"attendences called.");
        return "hr/attendences";
    }

}