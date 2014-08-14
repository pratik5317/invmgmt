/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.pojo.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
        return "item_category";
    }
    
    @RequestMapping(value="/item_unit.html",method= RequestMethod.GET)
    public String item_unit(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"item_unit called.");
        return "item_unit";
    }
    
    @RequestMapping(value="/purchase_order.html",method= RequestMethod.GET)
    public String purchase_order(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"purchase_order called.");
        return "purchase_order";
    }
    
    @RequestMapping(value="/purchase_requisition.html",method= RequestMethod.GET)
    public String purchase_requisition(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"purchase_requisition called.");
        return "purchase_requisition";
    }
    
    @RequestMapping(value="/add-item.html",method= RequestMethod.GET)
    public String add_item(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item called.");
        return "add-item";
    }

    @RequestMapping(value="/add-item_category.html",method= RequestMethod.GET)
    public String add_item_category(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item_category called.");
        return "add-item_category";
    }
    @RequestMapping(value="/add-item_unit.html",method= RequestMethod.GET)
    public String add_item_unit(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-item_unit called.");
        return "add-item_unit";
    }

    @RequestMapping(value="/add-purchase_requisition.html",method= RequestMethod.GET)
    public String add_purchase_requisition(Model model,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"add-purchase_requisition called.");
        return "add-purchase_requisition";
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
        return "hr/hr_add_employee";
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
