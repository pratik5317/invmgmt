/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IEmployeeLeaveTypesDAO;
import com.tss.ocean.pojo.EmployeeLeaveTypes;
import com.tss.ocean.util.Utilities;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
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
 * @author sweta
 */
@Controller
public class EmployeeLeaveController {

    @Autowired
    IEmployeeLeaveTypesDAO employeeLeaveTypesDAO;
    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeLeaveController.class);

    @RequestMapping(value = "/leave_types.html", method = RequestMethod.GET)
    public ModelAndView leaveTypes(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("leave types called.");
        ModelAndView mav = new ModelAndView("leave_types");
        List<EmployeeLeaveTypes> leaveTypes = employeeLeaveTypesDAO.getList();

        mav.getModelMap().put("leaveTypesList", leaveTypes);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_leave_type", method = RequestMethod.GET)
    public ModelAndView addLeaveTypeGet(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("addLeaveTypeGet called.");
        ModelAndView mav = new ModelAndView("add_leave_type");
        EmployeeLeaveTypes leaveType = new EmployeeLeaveTypes();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("leaveType", leaveType);
        return mav;
    }

    @RequestMapping(value = "/add_leave_type.html", method = RequestMethod.POST)
    public ModelAndView addLeaveTypePost(@ModelAttribute("leaveType") @Valid EmployeeLeaveTypes employeeLeaveTypes,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("add_leave_type-post called.");
        if (!result.hasErrors()) {
            int insertResult = employeeLeaveTypesDAO.insert(employeeLeaveTypes);
            if (insertResult > 0) {
                logger.info("Employee leave types Added Successfully with id " + insertResult);
                return new ModelAndView("redirect:add_leave_type.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "leavetype.add.success", locale));
            } else {
                logger.info("Error while inserting " + employeeLeaveTypes);
                return new ModelAndView("add_leave_type", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "leavetype.add.error", locale));
            }
        } else {
            return new ModelAndView("add_leave_type", model);
        }

    }

    @RequestMapping(value = "/edit_leave_type.html", method = RequestMethod.GET)
    public ModelAndView editLeaveTypeGet(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.info("edit_leave_type called.");
        ModelAndView mav;
        EmployeeLeaveTypes employeeLeaveTypes = employeeLeaveTypesDAO.getRecordByPrimaryKey(id);
        if (employeeLeaveTypes != null) {
            mav = new ModelAndView("edit_leave_type");
            mav.getModelMap().put("leaveType", employeeLeaveTypes);
        } else {

            mav = new ModelAndView("redirect:leave_types.html");
            List<EmployeeLeaveTypes> leaveTypes = employeeLeaveTypesDAO.getList();

            mav.getModelMap().put("leaveTypesList", leaveTypes);
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_leave_type.html", method = RequestMethod.POST)
    public ModelAndView editLeaveTypePost(@ModelAttribute("leaveType") @Valid EmployeeLeaveTypes employeeLeaveTypes,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("edit_leave_type-post called.");
        if (!result.hasErrors()) {
            int updateResult = employeeLeaveTypesDAO.update(employeeLeaveTypes);
            if (updateResult > 0) {
                logger.info("leave_type updated Successfully with id={0}", updateResult);
                ModelAndView mav = new ModelAndView("redirect:leave_types.html");
                List<EmployeeLeaveTypes> leaveTypes = employeeLeaveTypesDAO.getList();
                 mav.getModelMap().put("leaveTypesList", leaveTypes);
                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "leavetype.update.success", locale));
            } else {
                logger.warn("Error occurred updating leave type :{0}", employeeLeaveTypes);
                return new ModelAndView("edit_leave_type", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "leavetype.update.error", locale));
            }
        } else {
            logger.warn("Leave types values are not valid:", employeeLeaveTypes);
            return new ModelAndView("edit_employee_category", model);
        }
    }

    @RequestMapping(value = "/delete_leave_type.html")
    @ResponseBody
    public ModelAndView deleteLeaveType(@RequestParam(value = "id") int id, Locale locale) throws Exception {
        logger.info("deleteLeaveType called.");
        EmployeeLeaveTypes employeeLeaveTypes = employeeLeaveTypesDAO.getRecordByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("redirect:leave_types.html");
        List<EmployeeLeaveTypes> leaveTypes = employeeLeaveTypesDAO.getList();
       mav.getModelMap().put("leaveTypesList", leaveTypes);
        if (employeeLeaveTypes != null) {
            int updateResult = employeeLeaveTypesDAO.delete(employeeLeaveTypes);

            if (updateResult > 0) {
                logger.info("Leave Type with id {0} deleted successfully", employeeLeaveTypes.getId());

                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "leavetype.delete.success", locale));
            } else {
                logger.warn("Error occurred while deleting leave type with id {0}", employeeLeaveTypes.getId());
                return mav
                        .addObject("error", Utilities.getSpringMessage(messageSource, "leavetype.delete.error", locale));
            }
        }
        logger.info("leave type with id {0} is already deleted", employeeLeaveTypes.getId());
        return mav
                .addObject("success", Utilities.getSpringMessage(messageSource, "leavetype.delete.success", locale));
    }

}
