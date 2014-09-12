package com.tss.ocean.idao;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.EmployeeAttendances;
import java.util.Date;
import java.util.List;

public interface IEmployeeAttendancesDAO extends GenericDAO<EmployeeAttendances, Integer> {

    List<EmployeeAttendances> getEmployeeAttendanceBetweenDates(Date fromdate, Date todate);

    List<EmployeeAttendances> getEmployeeAttendanceBetweenDatesByEmployee(Integer employeeId, Date fromdate, Date todate);
    List<EmployeeAttendances> getEmployeeAttendanceByDateByEmployeeId(Date attendanceDate,Integer employeeId);
}
