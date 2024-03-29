/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.techshark.hibernate.base.HibernateDAOFactory;
import com.tss.ocean.idao.IBankDAO;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeeDepartmentDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Bank;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.EmployeeDepartment;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.util.Utilities;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.validation.Valid;
import org.hibernate.Hibernate;
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
    @Autowired
    private IEmployeeDepartmentDAO employeeDepartmentDAO;
    @Autowired
    private IBankDAO bankDAO;

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
    public ModelAndView editEmployeeCategoryget(@RequestParam(value = "id") int id,
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

    @RequestMapping(value = "/employee_department.html", method = RequestMethod.GET)
    public ModelAndView employeeDepartment(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("employee_department called.");
        ModelAndView mav = new ModelAndView("employee_department");
        List<EmployeeDepartment> employeeDepartmentList = employeeDepartmentDAO.getList();

        mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_employee_department.html", method = RequestMethod.GET)
    public ModelAndView addEmployeeDeptGet(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("add_employee_department called.");
        ModelAndView mav = new ModelAndView("add_employee_department");
        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("employeedepartment", employeeDepartment);
        return mav;
    }

    @RequestMapping(value = "/add_employee_department.html", method = RequestMethod.POST)
    public ModelAndView addEmployeeDepartment(@ModelAttribute("employeedepartment") @Valid EmployeeDepartment employeeDepartment,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("add_employee_department-post called.");
        if (!result.hasErrors()) {
            int insertResult = employeeDepartmentDAO.insert(employeeDepartment);
            if (insertResult > 0) {
                logger.info("Employee Department Added Successfully with id " + insertResult);
                return new ModelAndView("redirect:add_employee_department.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empdepartment.add.success", locale));
            } else {
                logger.info("Error while inserting " + employeeDepartment);
                return new ModelAndView("add_employee_department", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empdepartment.add.error", locale));
            }
        } else {
            return new ModelAndView("add_employee_department", model);
        }

    }

    @RequestMapping(value = "/edit_employee_department.html", method = RequestMethod.GET)
    public ModelAndView editEmployeeDepartmentGet(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.info("edit_employee_department called.");
        ModelAndView mav;
        EmployeeDepartment employeeDepartment = employeeDepartmentDAO.getRecordByPrimaryKey(id);
        if (employeeDepartment != null) {
            mav = new ModelAndView("edit_employee_department");
            mav.getModelMap().put("employeedepartment", employeeDepartment);
        } else {
            mav = new ModelAndView("redirect:employee_department.html");
            List<EmployeeDepartment> employeeDepartmentList = employeeDepartmentDAO.getList();
            mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_employee_department.html", method = RequestMethod.POST)
    public ModelAndView editEmployeeDepartmentPost(@ModelAttribute("employeedepartment") @Valid EmployeeDepartment employeeDepartment,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("edit_employee_department-post called.");
        if (!result.hasErrors()) {
            int updateResult = employeeDepartmentDAO.update(employeeDepartment);
            if (updateResult > 0) {
                logger.info("employee_departmen updated Successfully with id={0}", updateResult);
                ModelAndView mav = new ModelAndView("redirect:employee_department.html");
                List<EmployeeDepartment> employeeDepartmentList = employeeDepartmentDAO.getList();
                mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empdepartment.update.success", locale));
            } else {
                logger.warn("Error occurred updating employee Department:{0}", employeeDepartment);
                return new ModelAndView("edit_employee_department", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empdepartment.update.error", locale));
            }
        } else {
            logger.warn("Employee department values are not valid:", employeeDepartment);
            return new ModelAndView("edit_employee_department", model);
        }
    }

    @RequestMapping(value = "/delete_employee_department.html")
    @ResponseBody
    public ModelAndView deleteEmployeeDepartment(@RequestParam(value = "id") int id, Locale locale) throws Exception {
        logger.info("delete_employee_department called.");
        EmployeeDepartment employeeDepartment = employeeDepartmentDAO.getRecordByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("redirect:employee_department.html");
        List<EmployeeDepartment> employeeDepartmentList = employeeDepartmentDAO.getList();
        mav.getModelMap().put("employeeDepartmentList", employeeDepartmentList);
        if (employeeDepartment != null) {
            int updateResult = employeeDepartmentDAO.delete(employeeDepartment);

            if (updateResult > 0) {
                logger.info("Employee department with id {0} deleted successfully", employeeDepartment.getId());

                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "empdepartment.delete.success", locale));
            } else {
                logger.warn("Error occurred while deleting employee department with id {0}", employeeDepartment.getId());
                return mav
                        .addObject("error", Utilities.getSpringMessage(messageSource, "empcategory.delete.error", locale));
            }
        }
        logger.info("Employee Department with id {0} is already deleted", employeeDepartment.getId());
        return mav
                .addObject("success", Utilities.getSpringMessage(messageSource, "empdepartment.delete.error", locale));
    }

    @RequestMapping(value = "/employee.html", method = RequestMethod.GET)
    public ModelAndView getEmployyes(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("employee called.");
        ModelAndView mav = new ModelAndView("employee");
        List<Employees> employeeList = employeesDAO.getList();
        Map<Integer, String> departmentMap = new HashMap<>();
        Map<Integer, String> categoryMap = new HashMap<>();
        mav.getModelMap().put("employeeList", employeeList);
        List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
        for (EmployeeDepartment employeeDepartment : departmentList) {
            departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
        }
        mav.getModelMap().put("departmentmap", departmentMap);

        List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
        for (EmployeeCategory employeeCategory : categoryList) {
            categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
        }
        mav.getModelMap().put("categorymap", categoryMap);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_employee", method = RequestMethod.GET)
    public ModelAndView addEmployeeGet(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("add_employee called.");
        ModelAndView mav = new ModelAndView("add_employee");
        Employees employee = new Employees();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        List<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yearsList.add(i);
        }
        List<Integer> monthList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            monthList.add(i);
        }
        mav.getModelMap().put("yearList", yearsList);
        mav.getModelMap().put("monthList", monthList);
        List<Employees> employeeList = employeesDAO.getList();
        List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
        List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
        List<Bank> bankList = bankDAO.getList();
        mav.getModelMap().put("employee", employee);
        mav.getModelMap().put("employeeDepartmentList", departmentList);
        mav.getModelMap().put("employeeCategoryList", categoryList);
        mav.getModelMap().put("employeeList", employeeList);
        mav.getModelMap().put("bankList", bankList);

        return mav;
    }

    @RequestMapping(value = "/add_employee.html", method = RequestMethod.POST)
    public ModelAndView addEmployeePost(@ModelAttribute("employee") @Valid Employees employees,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("add_employee_category-post called.");
        ModelAndView mav = new ModelAndView("redirect:add_employee.html");
        List<Employees> employeeList = employeesDAO.getList();
        List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
        List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
        List<Bank> bankList = bankDAO.getList();
        List<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            yearsList.add(i);
        }
        List<Integer> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthList.add(i);
        }
        mav.getModelMap().put("yearList", yearsList);
        mav.getModelMap().put("monthList", monthList);
        mav.getModelMap().put("employee", employees);
        mav.getModelMap().put("employeeDepartmentList", departmentList);
        mav.getModelMap().put("employeeCategoryList", categoryList);
        mav.getModelMap().put("employeeList", employeeList);
        mav.getModelMap().put("bankList", bankList);
        if (!result.hasErrors()) {
            List<Employees> employeeNumberList = getEmployeeByEmployeeNumber(employees.getEmployeeNumber());
            if (employeeNumberList != null && !employeeNumberList.isEmpty()) {
                logger.info("Employee number already exist");
                return mav.addObject("error", Utilities.getSpringMessage(messageSource, "employee.add.employeenumberexist.error", locale));
            } else {
                if (employees.getFileData() != null) {
                    employees.setPhotoData(Hibernate.createBlob(employees.getFileData().getInputStream()));
                    employees.setPhotoFileName(employees.getFileData().getOriginalFilename());
                    employees.setPhotoContentType(employees.getFileData().getContentType());
                    employees.setPhotoFileSize(new Long(employees.getFileData().getSize()).intValue());
                }
                int insertResult = employeesDAO.insert(employees);

                if (insertResult > 0) {
                    logger.info("Employee category Added Successfully with id " + insertResult);
                    return mav.addObject("success", Utilities.getSpringMessage(messageSource, "employee.add.success", locale));
                } else {
                    logger.info("Error while inserting " + employees);
                    return mav.addObject("error", Utilities.getSpringMessage(messageSource, "employee.add.error", locale));
                }
            }
        } else {
            ModelAndView mav1 = new ModelAndView("add_employee", model);
            mav.getModelMap().put("yearList", yearsList);
            mav.getModelMap().put("monthList", monthList);
            mav1.getModelMap().put("employee", employees);
            mav1.getModelMap().put("employeeDepartmentList", departmentList);
            mav1.getModelMap().put("employeeCategoryList", categoryList);
            mav1.getModelMap().put("employeeList", employeeList);
            mav1.getModelMap().put("bankList", bankList);
            return mav1;

        }

    }

    @RequestMapping(value = "/edit_employee.html", method = RequestMethod.GET)
    public ModelAndView editEmployeeGet(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.info("edit_employee called.");
        ModelAndView mav;
        Employees employees = employeesDAO.getRecordByPrimaryKey(id);
        List<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            yearsList.add(i);
        }
        List<Integer> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthList.add(i);
        }

        if (employees != null) {
            mav = new ModelAndView("edit_employee");
            logger.info("file data " + employees.getFileData());
            mav.getModelMap().put("employee", employees);
            List<Employees> employeeList = employeesDAO.getList();
            List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
            List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
            List<Bank> bankList = bankDAO.getList();
            mav.getModelMap().put("employeeDepartmentList", departmentList);
            mav.getModelMap().put("employeeCategoryList", categoryList);
            mav.getModelMap().put("employeeList", employeeList);
            mav.getModelMap().put("bankList", bankList);
            mav.getModelMap().put("yearList", yearsList);
            mav.getModelMap().put("monthList", monthList);
        } else {

            mav = new ModelAndView("redirect:employee.html");
            List<Employees> employeeList = employeesDAO.getList();
            Map<Integer, String> departmentMap = new HashMap<>();
            Map<Integer, String> categoryMap = new HashMap<>();
            mav.getModelMap().put("employeeList", employeeList);
            List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
            for (EmployeeDepartment employeeDepartment : departmentList) {
                departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
            }
            mav.getModelMap().put("departmentmap", departmentMap);

            List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
            for (EmployeeCategory employeeCategory : categoryList) {
                categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
            }
            mav.getModelMap().put("categorymap", categoryMap);

        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_employee.html", method = RequestMethod.POST)
    public ModelAndView editEmployeePost(@ModelAttribute("employee") @Valid Employees employees,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("edit_employee-post called.");
        ModelAndView mav = new ModelAndView("redirect:employee.html");
        List<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            yearsList.add(i);
        }
        List<Integer> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthList.add(i);
        }
        if (!result.hasErrors()) {
            if (employees.getFileData() != null) {
                employees.setPhotoData(Hibernate.createBlob(employees.getFileData().getInputStream()));
                employees.setPhotoFileName(employees.getFileData().getOriginalFilename());
                employees.setPhotoContentType(employees.getFileData().getContentType());
                employees.setPhotoFileSize(new Long(employees.getFileData().getSize()).intValue());
            }
            int updateResult = employeesDAO.update(employees);
            List<Employees> employeeList = employeesDAO.getList();
            Map<Integer, String> departmentMap = new HashMap<>();
            Map<Integer, String> categoryMap = new HashMap<>();
            mav.getModelMap().put("employeeList", employeeList);
            List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
            for (EmployeeDepartment employeeDepartment : departmentList) {
                departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
            }
            mav.getModelMap().put("departmentmap", departmentMap);

            List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
            for (EmployeeCategory employeeCategory : categoryList) {
                categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
            }
            mav.getModelMap().put("categorymap", categoryMap);
            if (updateResult > 0) {
                logger.info("employee  updated Successfully with id={0}", updateResult);

                List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
                mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "employee.update.success", locale));
            } else {
                logger.warn("Error occurred updating employee categry:{0}", employees);
                return new ModelAndView("edit_employee", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "employee.update.error", locale));
            }
        } else {
            mav = new ModelAndView("edit_employee", model);
            mav.getModelMap().put("employee", employees);
            List<Employees> employeeList = employeesDAO.getList();
            List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
            List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
            List<Bank> bankList = bankDAO.getList();
            mav.getModelMap().put("employeeDepartmentList", departmentList);
            mav.getModelMap().put("employeeCategoryList", categoryList);
            mav.getModelMap().put("employeeList", employeeList);
            mav.getModelMap().put("bankList", bankList);
            mav.getModelMap().put("yearList", yearsList);
            mav.getModelMap().put("monthList", monthList);
            logger.warn("Employee  values are not valid:", employees);
            return  mav;
        }
    }

    @RequestMapping(value = "/employee_image.html", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getImage(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws SQLException {

        logger.info("emoloyeeimage called.");
        Employees employees = employeesDAO.getRecordByPrimaryKey(id);

        if (employees.getPhotoData() != null) {
            int blobLength = (int) employees.getPhotoData().length();
            byte[] blobAsBytes = employees.getPhotoData().getBytes(1, blobLength);
            return blobAsBytes;
        }
        return null;

    }

    @RequestMapping(value = "/delete_employee.html", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteEmployee(@RequestParam(value = "id") int id, Locale locale) throws Exception {
        logger.info("delete_employee called.");
        Employees employees = employeesDAO.getRecordByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("redirect:employee.html");
        List<Employees> employeeList = employeesDAO.getList();
        Map<Integer, String> departmentMap = new HashMap<>();
        Map<Integer, String> categoryMap = new HashMap<>();
        mav.getModelMap().put("employeeList", employeeList);
        List<EmployeeDepartment> departmentList = employeeDepartmentDAO.getList();
        for (EmployeeDepartment employeeDepartment : departmentList) {
            departmentMap.put(employeeDepartment.getId(), employeeDepartment.getDepartment());
        }
        mav.getModelMap().put("departmentmap", departmentMap);

        List<EmployeeCategory> categoryList = employeeCategoryDAO.getList();
        for (EmployeeCategory employeeCategory : categoryList) {
            categoryMap.put(employeeCategory.getId(), employeeCategory.getCategory());
        }
        mav.getModelMap().put("categorymap", categoryMap);
        if (employees != null) {
            int updateResult = employeesDAO.delete(employees);

            if (updateResult > 0) {
                logger.info("Employee  with id {0} deleted successfully", employees.getId());

                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "employee.delete.success", locale));
            } else {
                logger.warn("Error occurred while deleting employee  with id {0}", employees.getId());
                return mav
                        .addObject("error", Utilities.getSpringMessage(messageSource, "employee.delete.error", locale));
            }
        }
        logger.info("Employee Department with id {0} is already deleted", employees.getId());
        return mav
                .addObject("success", Utilities.getSpringMessage(messageSource, "employee.delete.error", locale));
    }

    private List<Employees> getEmployeeByEmployeeNumber(String employeeNumber) {
        return employeesDAO.getListByFromClause(" FROM Employees e WHERE e.employeeNumber= '" + employeeNumber + "'");
    }
}
