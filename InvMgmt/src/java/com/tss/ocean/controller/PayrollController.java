/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.idao.IMonthlyPayslipsDAO;
import com.tss.ocean.idao.IPayrollCategoriesDAO;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.MonthlyPayslips;
import com.tss.ocean.pojo.PayrollCategories;
import com.tss.ocean.pojo.Payslip;
import com.tss.ocean.pojo.PayslipContainer;
import com.tss.ocean.util.Utilities;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
    IMonthlyPayslipsDAO monthlyPayslipsDAO;
    @Autowired
    IEmployeesDAO employeesDAO;

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

    @RequestMapping(value = "/payslips.html", method = RequestMethod.GET)
    public ModelAndView payslip(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        LOGGER.info("payslips called.");
        PayslipContainer payslipContainer = new PayslipContainer();
        ModelAndView mav = new ModelAndView("payslips");
        List<MonthlyPayslips> monthlyPayslips = new ArrayList<>();
        payslipContainer.setMonthlyPayslipList(monthlyPayslips);
        List<Employees> employeeList = employeesDAO.getList();
        List<PayrollCategories> payrollCategoryList = payrollCategoriesDAO.getList();
        mav.getModelMap().put("employeeList", employeeList);
        mav.getModelMap().put("payslipContainer", payslipContainer);
        mav.getModelMap().put("payrollcategoryList", payrollCategoryList);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/create_payslip.html", method = RequestMethod.POST)
    public ModelAndView createPayslip(@ModelAttribute("payslipContainer") @Valid PayslipContainer payslipContainer,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        LOGGER.info("create_payslip post called." + payslipContainer.getMonthlyPayslipList());
        ModelAndView mav = new ModelAndView("payslips");

        List<MonthlyPayslips> monthlyPayslips = new ArrayList<>();
        PayslipContainer payslipContainerNew = new PayslipContainer();
        payslipContainerNew.setMonthlyPayslipList(monthlyPayslips);
        List<Employees> employeeList = employeesDAO.getList();
        List<PayrollCategories> payrollCategoryList = payrollCategoriesDAO.getList();
        mav.getModelMap().put("employeeList", employeeList);
        mav.getModelMap().put("payslipContainer", payslipContainerNew);
        mav.getModelMap().put("payrollcategoryList", payrollCategoryList);
        if (!result.hasErrors()) {

            if (!isPayslipCreated(payslipContainer.getEmployeeId(), payslipContainer.getSalaryDate())) {
                int insertResult = 0;
                List<MonthlyPayslips> monthlyPayslipList = payslipContainer.getMonthlyPayslipList();
                if (monthlyPayslipList != null && !monthlyPayslipList.isEmpty()) {
                    for (MonthlyPayslips monthlyPayslips1 : payslipContainer.getMonthlyPayslipList()) {
                        monthlyPayslips1.setEmployeeId(payslipContainer.getEmployeeId());
                        monthlyPayslips1.setSalaryDate(payslipContainer.getSalaryDate());
                        monthlyPayslips1.setIsApproved(false);
                        monthlyPayslips1.setIsRejected(false);
                        insertResult = monthlyPayslipsDAO.insert(monthlyPayslips1);
                    }
                }

                if (insertResult > 0) {
                    LOGGER.info("Payslips created");
                    return mav
                            .addObject("success", Utilities.getSpringMessage(messageSource, "payslip.add.success", locale));
                } else {
                    LOGGER.info("Error while inserting ");
                    return mav
                            .addObject("error", Utilities.getSpringMessage(messageSource, "payslip.add.error", locale));
                }
            } else {
                LOGGER.info("Payslip created ");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(payslipContainer.getSalaryDate());
                return mav
                        .addObject("error", "Payslip is created for employee for month " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
            }

        } else {
            return new ModelAndView("payslips", model);
        }
    }

    private List<MonthlyPayslips> getMonthlyPayslipByEmployee(Integer employeeId) {
        return monthlyPayslipsDAO.getListByFromClause(" FROM MonthlyPayslips m WHERE m.employeeId=" + employeeId);
    }

    private boolean isPayslipCreated(Integer employeeId, Date createDate) {
        Calendar createdatecal = Calendar.getInstance();
        createdatecal.setTime(createDate);
        Calendar salarycal = Calendar.getInstance();
        List<MonthlyPayslips> monthlyPayslipsList = getMonthlyPayslipByEmployee(employeeId);
        if (monthlyPayslipsList != null && !monthlyPayslipsList.isEmpty()) {
            for (MonthlyPayslips monthlyPayslips : monthlyPayslipsList) {
                salarycal.setTime(monthlyPayslips.getSalaryDate());
                if (createdatecal.get(Calendar.MONTH) == salarycal.get(Calendar.MONTH) && createdatecal.get(Calendar.YEAR) == salarycal.get(Calendar.YEAR)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "/payslips_list.html", method = RequestMethod.GET)
    public ModelAndView getPayslipList(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        LOGGER.info("payslips called.");
        ModelAndView mav = new ModelAndView("payslips_list");

        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/get_payslip.html", method = RequestMethod.GET)
    public ModelAndView getPayslipList(@RequestParam(value = "month") String month,
            @RequestParam(value = "year") String year,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        LOGGER.info("payslips called.");
        ModelAndView mav = new ModelAndView("payslips_list");

        HashMap<Integer, Payslip> payslipMap = new HashMap<Integer, Payslip>();
        if (month != null && year != null) {
            List<MonthlyPayslips> payslips = getMonthlyPayslipsForMonthYear(Integer.valueOf(month), Integer.valueOf(year));
            List<Integer> employeeList = new ArrayList<>();
            if (payslips != null && !payslips.isEmpty()) {
                for (MonthlyPayslips monthlyPayslips : payslips) {
                    if (payslipMap.containsKey(monthlyPayslips.getEmployeeId())) {
                        Payslip payslip = payslipMap.get(monthlyPayslips.getEmployeeId());
                        PayrollCategories payrollCategories = payrollCategoriesDAO.getRecordByPrimaryKey(monthlyPayslips.getPayrollCategoryId());
                        if (payrollCategories.getIsDeduction()) {
                            payslip.setDeductions(payslip.getDeductions() + monthlyPayslips.getAmount());
                            payslip.setTotal(payslip.getTotal() - monthlyPayslips.getAmount());
                            payslip.getDeductionList().add(monthlyPayslips);
                        } else {
                            payslip.setSalary(payslip.getSalary() + monthlyPayslips.getAmount());
                            payslip.setTotal(payslip.getTotal() + monthlyPayslips.getAmount());
                            payslip.getSalaryList().add(monthlyPayslips);
                        }

                    } else {
                        Payslip payslip = new Payslip();
                        Employees employee = employeesDAO.getRecordByPrimaryKey(monthlyPayslips.getEmployeeId());
                        payslip.setEmployeeId(monthlyPayslips.getEmployeeId());
                        payslip.setEmployeeNumber(employee.getEmployeeNumber());
                        payslip.setFirstName(employee.getFirstName());
                        payslip.setLastName(employee.getLastName());

                        PayrollCategories payrollCategories = payrollCategoriesDAO.getRecordByPrimaryKey(monthlyPayslips.getPayrollCategoryId());
                        if (payrollCategories.getIsDeduction()) {
                            payslip.setDeductions(monthlyPayslips.getAmount());
                            payslip.setTotal(monthlyPayslips.getAmount() * -1);
                            payslip.setDeductionList(new ArrayList<MonthlyPayslips>());
                            payslip.getDeductionList().add(monthlyPayslips);
                        } else {
                            payslip.setSalary(monthlyPayslips.getAmount());
                            payslip.setTotal(monthlyPayslips.getAmount());
                            payslip.setSalaryList(new ArrayList<MonthlyPayslips>());
                            payslip.getSalaryList().add(monthlyPayslips);
                        }

                        payslipMap.put(monthlyPayslips.getEmployeeId(), payslip);
                        employeeList.add(monthlyPayslips.getEmployeeId());
                    }
                }

                mav.getModelMap().put("employeeList", employeeList);
                mav.getModelMap().put("payslipmap", payslipMap);

            }
        }

        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    List<MonthlyPayslips> getMonthlyPayslipsForMonthYear(int month, int year) {
        List<MonthlyPayslips> list = monthlyPayslipsDAO.getList();
        List<MonthlyPayslips> monthlyPayslipList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (MonthlyPayslips payslip : list) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(payslip.getSalaryDate());
                LOGGER.info("salary yeaar : " + cal.get(Calendar.YEAR));
                LOGGER.info("salary month : " + cal.get(Calendar.MONTH));
                LOGGER.info("param yeaar : " + year);
                LOGGER.info("param month : " + month);

                if (month == (cal.get(Calendar.MONTH)) && year == (cal.get(cal.get(Calendar.YEAR)))) {
                    monthlyPayslipList.add(payslip);
                }
            }
        }
        return monthlyPayslipList;
    }

    @RequestMapping(value = "/payslip_detail.html", method = RequestMethod.GET)
    public ModelAndView getDetailedPayslip(@RequestParam(value = "id") Integer id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error, @ModelAttribute("payslipmap") @Valid HashMap<Integer, Payslip> payslipMap,
            BindingResult result,
            ModelMap model
    ) throws Exception {
        LOGGER.info("payslip_detail called.");
        ModelAndView mav = new ModelAndView("payslip_detail");
        List<MonthlyPayslips> monthlyPayslips = new ArrayList<>();
        List<PayrollCategories> payrollCategorieses = payrollCategoriesDAO.getList();
        Map<Integer, String> payrollCategoryMap = new HashMap<Integer, String>();
        if (payrollCategorieses != null && !payrollCategorieses.isEmpty()) {
            for (PayrollCategories payrollCategories : payrollCategorieses) {
                payrollCategoryMap.put(payrollCategories.getId(), payrollCategories.getName());
            }
        }
        if (id != null) {
            Payslip payslip = payslipMap.get(id);
            mav.getModelMap().put("payslip", payslip);
            if (payslip != null) {
                for (MonthlyPayslips monthlyPayslips1 : payslip.getSalaryList()) {
                    monthlyPayslips.add(monthlyPayslips1);
                }
                for (MonthlyPayslips monthlyPayslips2 : payslip.getDeductionList()) {
                    monthlyPayslips2.setAmount(monthlyPayslips2.getAmount() * (-1));
                    monthlyPayslips.add(monthlyPayslips2);
                }
            }
        }
        mav.getModelMap().put("monthlyPayslips", monthlyPayslips);
        mav.getModelMap().put("payrollcategormap", payrollCategoryMap);

        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

}
