/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.techshark.hibernate.base.HibernateDAOFactory;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.util.Utilities;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.ResponseBody;
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
    @Autowired
    IEmployeeCategoryDAO employeeCategoryDAO;
    @Autowired
    private MessageSource messageSource;

    public EmployeeController() {
        employeesDAO = new HibernateDAOFactory().getEmployeesDAO();
    }

    @RequestMapping(value = "/addemployee.html", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Employees employee, Model model) {

        logger.debug("addEmployee called :" + employee);

        int status = employeesDAO.insert(employee);
        logger.debug("addEmployee insert status:" + status);

        return new ModelAndView("employees");
    }

    @RequestMapping(value = "/employee_category.html", method = RequestMethod.GET)
    public ModelAndView employeeCategory(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("employee_categogy called.");
        ModelAndView mav = new ModelAndView("employee_category");
        List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();

        mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_employee_category", method = RequestMethod.GET)
    public ModelAndView add_employee_cat_get(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("add_employee_category called.");
        ModelAndView mav = new ModelAndView("add_employee_category");
        EmployeeCategory employeeCategory = new EmployeeCategory();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("employeecategory", employeeCategory);
        return mav;
    }

    @RequestMapping(value = "/add_employee_category.html", method = RequestMethod.POST)
    public ModelAndView addEmployeeCategory(@ModelAttribute("employeecategory") @Valid EmployeeCategory employeeCategory,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("add_employee_category-post called.");
        if (!result.hasErrors()) {
            employeeCategory.setIsActive(1);
            int insertResult = employeeCategoryDAO.insert(employeeCategory);
            if (insertResult > 0) {
                logger.info("Employee category Added Successfully with id " + insertResult);
                return new ModelAndView("redirect:add_employee_category.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empcategory.add.success", locale));
            } else {
                logger.info("Error while inserting " + employeeCategory);
                return new ModelAndView("add_employee_category", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empcategory.add.error", locale));
            }
        } else {
            return new ModelAndView("add_employee_category", model);
        }

    }

    @RequestMapping(value = "/edit_employee_category.html", method = RequestMethod.GET)
    public ModelAndView editEmployeeget(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.info("edit_employee_category called.");
        ModelAndView mav;
        EmployeeCategory employeeCategory = employeeCategoryDAO.getRecordByPrimaryKey(id);
        if (employeeCategory != null) {
            mav = new ModelAndView("edit_employee_category");
            mav.getModelMap().put("employeecategory", employeeCategory);
        } else {

            mav = new ModelAndView("redirect:employee_category.html");
            List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
            mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_employee_category.html", method = RequestMethod.POST)
    public ModelAndView editEmployeeCategoryPost(@ModelAttribute("employeecategory") @Valid EmployeeCategory employeeCategory,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("edit_employee_category-post called.");
        if (!result.hasErrors()) {
            int updateResult = employeeCategoryDAO.update(employeeCategory);
            if (updateResult > 0) {
                logger.info("employee_category updated Successfully with id={0}", updateResult);
                ModelAndView mav = new ModelAndView("redirect:employee_category.html");
                List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
                mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empcategory.update.success", locale));
            } else {
                logger.warn("Error occurred updating employee categry:{0}", employeeCategory);
                return new ModelAndView("edit_employee_category", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empcategory.update.error", locale));
            }
        } else {
            logger.warn("Employee category values are not valid:", employeeCategory);
            return new ModelAndView("edit_employee_category", model);
        }
    }

    @RequestMapping(value = "/delete_employee_category.html")
    @ResponseBody
    public ModelAndView deleteEmployeeCategory(@RequestParam(value = "id") int id, Locale locale) throws Exception {
        logger.info("delete_employee_category called.");
        EmployeeCategory employeeCategory = employeeCategoryDAO.getRecordByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("redirect:employee_category.html");
        List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
        mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
        if (employeeCategory != null) {
            int updateResult = employeeCategoryDAO.delete(employeeCategory);

            if (updateResult > 0) {
                logger.info("Employee category with id {0} deleted successfully", employeeCategory.getId());

                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empcategory.delete.success", locale));
            } else {
                logger.warn("Error occurred while deleting employee category with id {0}", employeeCategory.getId());
                return mav
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empcategory.delete.error", locale));
            }
        }
        logger.info("Employee category with id {0} is already deleted", employeeCategory.getId());
        return mav
                .addObject("success", Utilities.getSpringMessage(messageSource, "empcategory.delete.success", locale));
    }
}
