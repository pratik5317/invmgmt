/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IEmployeeAttendancesDAO;
import com.tss.ocean.idao.IEmployeeLeaveTypesDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.AttendanceDate;
import com.tss.ocean.pojo.EmployeeAttendances;
import com.tss.ocean.pojo.EmployeeLeaveTypes;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.util.Utilities;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
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
public class EmployeeLeaveController {

    @Autowired
    IEmployeeLeaveTypesDAO employeeLeaveTypesDAO;
    @Autowired
    IEmployeesDAO employeesDAO;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    IEmployeeAttendancesDAO employeeAttendancesDAO;
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
            ModelAndView mav = new ModelAndView("add_leave_type", model);
            EmployeeLeaveTypes leaveType = new EmployeeLeaveTypes();
            mav.getModelMap().put("leaveType", leaveType);
            return mav;
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
            return new ModelAndView("edit_leave_type", model);
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

    @RequestMapping(value = "/hr_attendence.html", method = RequestMethod.GET)
    public ModelAndView attendanceRegister(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("leave types called.");
        ModelAndView mav = new ModelAndView("attendance_register");
        List<Employees> employeeList = employeesDAO.getList();
        mav.getModelMap().put("employeeList", employeeList);
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/add_attendance.html", method = RequestMethod.GET)
    public ModelAndView addAttendance(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("add_attendance called.");
        ModelAndView mav = new ModelAndView("add_attendance");
        List<Employees> employeeList = employeesDAO.getList();
        List<EmployeeLeaveTypes> employeeLeaveTypeList = employeeLeaveTypesDAO.getList();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        List<String> hoursList = new ArrayList<>();
        for (int i = 0; i < 23; i++) {
            hoursList.add(decimalFormat.format(i));
        }
        List<String> minutesList = new ArrayList<>();
        for (int i = 0; i < 59; i++) {
            minutesList.add(decimalFormat.format(i));
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("employeeList", employeeList);
        mav.getModelMap().put("employeeLeaveTypeList", employeeLeaveTypeList);
        mav.getModelMap().put("hoursList", hoursList);
        mav.getModelMap().put("minutesList", minutesList);
        mav.getModelMap().put("attendance", new EmployeeAttendances());
        return mav;
    }

    @RequestMapping(value = "/add_attendance.html", method = RequestMethod.POST)
    public ModelAndView addAttendance(@ModelAttribute("attendance") @Valid EmployeeAttendances employeeAttendances,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("add_attendance-post called." + result.hasErrors());
        if (!result.hasErrors()) {
            List<Employees> employeeList = employeesDAO.getList();
            List<EmployeeLeaveTypes> employeeLeaveTypeList = employeeLeaveTypesDAO.getList();

            DecimalFormat decimalFormat = new DecimalFormat("00");
            List<String> hoursList = new ArrayList<>();
            for (int i = 0; i < 23; i++) {
                hoursList.add(decimalFormat.format(i));
            }
            List<String> minutesList = new ArrayList<>();
            for (int i = 0; i < 59; i++) {
                minutesList.add(decimalFormat.format(i));
            }
            ModelAndView mav = new ModelAndView("add_attendance");
            mav.getModelMap().put("employeeList", employeeList);
            mav.getModelMap().put("employeeLeaveTypeList", employeeLeaveTypeList);
            mav.getModelMap().put("hoursList", hoursList);
            mav.getModelMap().put("minutesList", minutesList);
            mav.getModelMap().put("attendance", new EmployeeAttendances());

            if (employeeAttendances.getInHour() != null && employeeAttendances.getInMinutes() != null) {
                employeeAttendances.setInTime(decimalFormat.format(employeeAttendances.getInHour()) + ":" + decimalFormat.format(employeeAttendances.getInMinutes()));
            }
            if (employeeAttendances.getOutHour() != null && employeeAttendances.getOutMinutes() != null) {
                employeeAttendances.setOutTime(decimalFormat.format(employeeAttendances.getOutHour()) + ":" + decimalFormat.format(employeeAttendances.getOutHour()));
            }
//            employeeAttendances.setInTime(employeeAttendances.getInHour() + ":" + employeeAttendances.getInMinutes());
//            employeeAttendances.setOutTime(employeeAttendances.getOutHour() + ":" + employeeAttendances.getOutMinutes());
            if (!employeeAttendances.getIsLeave()) {

                employeeAttendances.setEmployeeLeaveTypeId(null);
            }
            List<EmployeeAttendances> employeeAttendanceses = getAttendanceByDateByEmployeeId(employeeAttendances.getAttendanceDate(), employeeAttendances.getEmployeeId());
            if (employeeAttendanceses != null && !employeeAttendanceses.isEmpty()) {
                employeeAttendances.setId(employeeAttendanceses.get(0).getId());
            }
            employeeAttendancesDAO.insertOrUpdate(employeeAttendances);

            logger.info("Employee attendance Added Successfully with id ");
            return mav
                    .addObject("success", Utilities.getSpringMessage(messageSource, "attendance.add.success", locale));

        } else {
            ModelAndView mav = new ModelAndView("add_attendance", model);
            List<Employees> employeeList = employeesDAO.getList();
            List<EmployeeLeaveTypes> employeeLeaveTypeList = employeeLeaveTypesDAO.getList();
            DecimalFormat decimalFormat = new DecimalFormat("00");
            List<String> hoursList = new ArrayList<>();
            for (int i = 0; i < 23; i++) {
                hoursList.add(decimalFormat.format(i));
            }
            List<String> minutesList = new ArrayList<>();
            for (int i = 0; i < 59; i++) {
                minutesList.add(decimalFormat.format(i));
            }

            mav.getModelMap().put("employeeList", employeeList);
            mav.getModelMap().put("employeeLeaveTypeList", employeeLeaveTypeList);
            mav.getModelMap().put("hoursList", hoursList);
            mav.getModelMap().put("minutesList", minutesList);
            mav.getModelMap().put("attendance", new EmployeeAttendances());
            return mav;
        }

    }

    @RequestMapping(value = "/attendance_register.html", method = RequestMethod.POST)
    public ModelAndView getAttendanceRegister(@ModelAttribute("attendance") @Valid EmployeeAttendances employeeAttendances,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("attendance_register-post called.");
        if (!result.hasErrors()) {
            List<Employees> employeeList = employeesDAO.getList();
            Map<Integer, String> employeeMap = new LinkedHashMap<Integer, String>();
            for (Employees employees : employeeList) {
                employeeMap.put(employees.getId(), employees.getEmployeeNumber());
            }
            List<EmployeeAttendances> employeeAttendanceList = getEmployeeAttendanceByDate(employeeAttendances.getAttendanceDate());

            ModelAndView mav = new ModelAndView("add_attendance");
            mav.getModelMap().put("employeeMap", employeeMap);
            mav.getModelMap().put("employeeAttendanceList", employeeAttendanceList);
            mav.getModelMap().put("attendance", new EmployeeAttendances());
            return mav;
        }
        return new ModelAndView("hr_atendance", model);
    }

    private List<EmployeeAttendances> getEmployeeAttendanceByDate(Date attendanceDate) {
        return employeeAttendancesDAO.getListByFromClause(" FROM EmployeeAttendances e WHERE e.attendanceDate=" + attendanceDate);
    }

    @RequestMapping(value = "/hr_attendence_report.html", method = RequestMethod.GET)
    public ModelAndView attendanceReport(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("hr_attendence");
        ModelAndView mav = new ModelAndView("attendance_report");
        mav.getModelMap().put("attendance", new AttendanceDate());
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/get_attendance.html", method = RequestMethod.POST)
    public ModelAndView getAttendanceReport(@ModelAttribute("attendance") @Valid AttendanceDate attendanceDate,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.info("get_attendancecalled." + attendanceDate.getFromDate() + "  " + attendanceDate.getToDate());
        Map<Integer, AttendanceDate> attendanceMap = new LinkedHashMap<>();
        ModelAndView mav = new ModelAndView("attendance_report_list");
        List<EmployeeAttendances> employeeAttendanceses = getAttendancebetweendates(attendanceDate.getFromDate(), attendanceDate.getToDate());
        logger.info("Here list size  " + employeeAttendanceses.size());
        Calendar cal = Calendar.getInstance();

        for (EmployeeAttendances employeeAttendance : employeeAttendanceses) {
            if (attendanceMap.containsKey(employeeAttendance.getEmployeeId())) {
                cal.setTime(employeeAttendance.getAttendanceDate());
                setAttendanceData(attendanceMap.get(employeeAttendance.getEmployeeId()), cal, employeeAttendance);

            } else {
                AttendanceDate attendanceDate1 = new AttendanceDate();
                attendanceDate1.setPresentDays(0);
                attendanceDate1.setAbsentDays(0);
                attendanceDate1.setTotalDays(0);
                attendanceDate1.setFromDate(attendanceDate.getFromDate());
                attendanceDate1.setToDate(attendanceDate.getToDate());
                cal.setTime(employeeAttendance.getAttendanceDate());
                setAttendanceData(attendanceDate1, cal, employeeAttendance);
                attendanceMap.put(employeeAttendance.getEmployeeId(), attendanceDate1);
            }
        }
        List<AttendanceDate> attendancereportList = new ArrayList<>();
        for (Map.Entry<Integer, AttendanceDate> entrySet : attendanceMap.entrySet()) {
            Employees employees = employeesDAO.getRecordByPrimaryKey(entrySet.getKey());

            entrySet.getValue().setEmployee(employees.getFirstName() + "(" + employees.getEmployeeNumber() + ")");
            attendancereportList.add(entrySet.getValue());
        }

        mav.getModelMap().put("attendanceReportList", attendancereportList);
        return mav;
    }

    private List<EmployeeAttendances> getAttendancebetweendates(Date fromDate, Date toDate) {
        return employeeAttendancesDAO.getEmployeeAttendanceBetweenDates(fromDate, toDate);
    }

    private void setAttendanceData(AttendanceDate attendanceDate, Calendar cal, EmployeeAttendances employeeAttendances) {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        logger.info("setAttendanceData called " + dayOfWeek + "   " + Calendar.SATURDAY + "  " + Calendar.SUNDAY);
        if (!(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)) {
            logger.info(" 111 setAttendanceData called");
            attendanceDate.setTotalDays(attendanceDate.getTotalDays() + 1);
            if (employeeAttendances.getIsLeave()) {
                logger.info("isleave");
                attendanceDate.setAbsentDays(attendanceDate.getAbsentDays() + 1);
            } else {
                logger.info("isleave no");
                attendanceDate.setPresentDays(attendanceDate.getPresentDays() + 1);
            }
        } else {
            logger.info(" 222 setAttendanceData called");
        }
    }

    @RequestMapping(value = "/get_attendance_register.html", method = RequestMethod.POST)
    public ModelAndView getAttendance(@RequestParam(value = "fromDate", required = false) String fromDate,
            @RequestParam(value = "toDate", required = false) String toDate, @RequestParam(value = "employee", required = true) String employeeId,
            Locale locale) throws Exception {
        logger.info("add_attendance called.");
        ModelAndView mav = new ModelAndView("attendance_register");
        Integer employee = Integer.valueOf(employeeId);
        Date fromdate = null;
        Date todate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            fromdate = formatter.parse(fromDate);
            todate = formatter.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (employee != null && fromdate != null && todate != null) {
            List<EmployeeAttendances> employeeAttendanceses = getAttendanceRegisterByDateByEmployee(employee, fromdate, todate);
            if (employeeAttendanceses != null && !employeeAttendanceses.isEmpty()) {
                Employees employees = employeesDAO.getRecordByPrimaryKey(employeeAttendanceses.get(0).getEmployeeId());
                mav.getModelMap().put("employee", employees);
                DecimalFormat decimalFormat = new DecimalFormat("00");
                for (EmployeeAttendances employeeAttendances : employeeAttendanceses) {
                    if (employeeAttendances.getInHour() != null && employeeAttendances.getInMinutes() != null) {
                        employeeAttendances.setInTime(decimalFormat.format(employeeAttendances.getInHour()) + ":" + decimalFormat.format(employeeAttendances.getInMinutes()));
                    }
                    if (employeeAttendances.getOutHour() != null && employeeAttendances.getOutMinutes() != null) {
                        employeeAttendances.setOutTime(decimalFormat.format(employeeAttendances.getOutHour()) + ":" + decimalFormat.format(employeeAttendances.getOutHour()));
                    }

                }
            }

            mav.getModelMap().put("attendanceList", employeeAttendanceses);
            mav.getModelMap().put("employeeList", employeesDAO.getList());
        }

        return mav;
    }

    private List<EmployeeAttendances> getAttendanceRegisterByDateByEmployee(Integer employeeId, Date fromDate, Date toDate) {
        return employeeAttendancesDAO.getEmployeeAttendanceBetweenDatesByEmployee(employeeId, fromDate, toDate);
    }

    private List<EmployeeAttendances> getAttendanceByDateByEmployeeId(Date attendanceDate, Integer employeeId) {
        return employeeAttendancesDAO.getEmployeeAttendanceByDateByEmployeeId(attendanceDate, employeeId);
    }
}
