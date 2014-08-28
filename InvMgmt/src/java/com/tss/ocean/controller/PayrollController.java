/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IPayrollCategoriesDAO;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.pojo.EmployeeDepartment;
import com.tss.ocean.pojo.PayrollCategories;
import com.tss.ocean.util.Utilities;
import java.util.HashMap;
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
public class PayrollController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollController.class);

    @Autowired
    IPayrollCategoriesDAO payrollCategoriesDAO;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/payroll_category.html", method = RequestMethod.GET)
    public ModelAndView employeeCategory(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        LOGGER.info("payroll_category called.");
        ModelAndView mav = new ModelAndView("payroll_category");
        List<PayrollCategories> payrollcategoryList = payrollCategoriesDAO.getList();
        HashMap<Integer, String> payrollCategorymap = new HashMap<>(payrollcategoryList.size());
        for (PayrollCategories payrollCategories : payrollcategoryList) {
            payrollCategorymap.put(payrollCategories.getId(), payrollCategories.getName());
        }
        mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
        mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_payroll_category", method = RequestMethod.GET)
    public ModelAndView addpayrollCategoryGet(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        LOGGER.info("add_payroll_category called.");
        ModelAndView mav = new ModelAndView("add_payroll_category");
        PayrollCategories payrollCategories = new PayrollCategories();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
         List<PayrollCategories> payrollcategoryList = payrollCategoriesDAO.getList();
         mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
        mav.getModelMap().put("payrollcategory", payrollCategories);
        return mav;
    }

    @RequestMapping(value = "/add_payroll_category.html", method = RequestMethod.POST)
    public ModelAndView addPayrollCategoryPost(@ModelAttribute("payrollcategory") @Valid PayrollCategories payrollCategories,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        LOGGER.info("add_payroll_category-post called.");
        if (!result.hasErrors()) {
            int insertResult = payrollCategoriesDAO.insert(payrollCategories);
            if (insertResult > 0) {
                LOGGER.info("Payroll category Added Successfully with id " + insertResult);
                return new ModelAndView("redirect:add_payroll_category.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "payrollcategory.add.success", locale));
            } else {
                LOGGER.info("Error while inserting " + payrollCategories);
                return new ModelAndView("add_payroll_category", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "payrollcategory.add.error", locale));
            }
        } else {
            return new ModelAndView("add_payroll_category", model);
        }

    }

    @RequestMapping(value = "/edit_payroll_category.html", method = RequestMethod.GET)
    public ModelAndView editPayrollCategoryGet(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        LOGGER.info("edit_payroll_category called.");
        ModelAndView mav;
        PayrollCategories payrollCategories = payrollCategoriesDAO.getRecordByPrimaryKey(id);
        List<PayrollCategories> payrollcategoryList = payrollCategoriesDAO.getList();
        if (payrollCategories != null) {
            mav = new ModelAndView("edit_payroll_category");
            mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
            mav.getModelMap().put("payrollcategory", payrollCategories);
        } else {
            mav = new ModelAndView("redirect:payroll_category.html");
            HashMap<Integer, String> payrollCategorymap = new HashMap<>(payrollcategoryList.size());
            for (PayrollCategories payrollCategories1 : payrollcategoryList) {
                payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
            }
            mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
            mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_payroll_category.html", method = RequestMethod.POST)
    public ModelAndView editPayrollCategoryPost(@ModelAttribute("payrollcategory") @Valid PayrollCategories payrollCategories,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        LOGGER.info("edit_payroll_category-post called.");
        List<PayrollCategories> payrollcategoryList = payrollCategoriesDAO.getList();
        if (!result.hasErrors()) {
            int updateResult = payrollCategoriesDAO.update(payrollCategories);
            if (updateResult > 0) {
                LOGGER.info("payroll_category updated Successfully with id={0}", updateResult);
                ModelAndView mav = new ModelAndView("redirect:payroll_category.html");
                HashMap<Integer, String> payrollCategorymap = new HashMap<>(payrollcategoryList.size());
                for (PayrollCategories payrollCategories1 : payrollcategoryList) {
                    payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
                }
                mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
                mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "payrollcategory.update.success", locale));
            } else {
                LOGGER.warn("Error occurred updating payroll category:{0}", payrollCategories);
                return new ModelAndView("edit_payroll_category", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "payrollcategory.update.error", locale));
            }
        } else {
            LOGGER.warn("Employee department values are not valid:", payrollCategories);
            return new ModelAndView("edit_payroll_category", model);
        }
    }

    @RequestMapping(value = "/delete_payroll_category.html")
    @ResponseBody
    public ModelAndView deletePayrollCategory(@RequestParam(value = "id") int id, Locale locale) throws Exception {
        LOGGER.info("delete_payroll_category called.");
        PayrollCategories payrollCategories = payrollCategoriesDAO.getRecordByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("redirect:payroll_category.html");
        List<PayrollCategories> payrollcategoryList = payrollCategoriesDAO.getList();
        HashMap<Integer, String> payrollCategorymap = new HashMap<>(payrollcategoryList.size());
                for (PayrollCategories payrollCategories1 : payrollcategoryList) {
                    payrollCategorymap.put(payrollCategories1.getId(), payrollCategories1.getName());
                }
                mav.getModelMap().put("payrollCategoryList", payrollcategoryList);
                mav.getModelMap().put("payrollCategorymap", payrollCategorymap);
        if (payrollCategories != null) {
            int updateResult = payrollCategoriesDAO.delete(payrollCategories);

            if (updateResult > 0) {
                LOGGER.info("Payroll Category with id {0} deleted successfully", payrollCategories.getId());

                return mav
                        .addObject("success", Utilities.getSpringMessage(messageSource, "payrollcategory.delete.success", locale));
            } else {
                LOGGER.warn("Error occurred while deleting employee department with id {0}", payrollCategories.getId());
                return mav
                        .addObject("error", Utilities.getSpringMessage(messageSource, "payrollcategory.delete.error", locale));
            }
        }
        LOGGER.info("Payroll Department with id {0} is already deleted", payrollCategories.getId());
        return mav
                .addObject("success", Utilities.getSpringMessage(messageSource, "payrollcategory.delete.error", locale));
    }
}
