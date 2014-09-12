package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.techshark.hibernate.util.HibernateUtil;
import com.tss.ocean.idao.IEmployeeAttendancesDAO;
import com.tss.ocean.pojo.EmployeeAttendances;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("employeeAttendancesDAO")
public class EmployeeAttendancesDAO extends GenericDAOImpl<EmployeeAttendances, Integer> implements IEmployeeAttendancesDAO {

    @Override
    public List<EmployeeAttendances> getEmployeeAttendanceBetweenDates(Date fromdate, Date todate) {

        Map< String, Object> parameterNameAndValues = new HashMap<String, Object>();

        parameterNameAndValues.put("startDate", fromdate);
        parameterNameAndValues.put("endDate", todate);

        String hqlQuery = "FROM EmployeeAttendances e WHERE e.attendanceDate  BETWEEN :startDate AND :endDate";

        Query query = HibernateUtil.getCurrentSession().createQuery(hqlQuery);

        for (Entry<String, Object> e : parameterNameAndValues.entrySet()) {
            query.setParameter(e.getKey(), e.getValue());
        }

        return query.list();
    }

    @Override
    public List<EmployeeAttendances> getEmployeeAttendanceBetweenDatesByEmployee(Integer employeeId, Date fromdate, Date todate) {

        Map< String, Object> parameterNameAndValues = new HashMap<String, Object>();

        parameterNameAndValues.put("startDate", fromdate);
        parameterNameAndValues.put("endDate", todate);
        parameterNameAndValues.put("employeeId", employeeId);

        String hqlQuery = "FROM EmployeeAttendances e WHERE e.attendanceDate  BETWEEN :startDate AND :endDate AND e.employeeId=:employeeId";

        Query query = HibernateUtil.getCurrentSession().createQuery(hqlQuery);

        for (Entry<String, Object> e : parameterNameAndValues.entrySet()) {
            query.setParameter(e.getKey(), e.getValue());
        }

        return query.list();
    }

    @Override
    public List<EmployeeAttendances> getEmployeeAttendanceByDateByEmployeeId(Date attendanceDate, Integer employeeId) {
        Map< String, Object> parameterNameAndValues = new HashMap<String, Object>();

        parameterNameAndValues.put("attendanceDate", attendanceDate);
        parameterNameAndValues.put("employeeId", employeeId);

        String hqlQuery = "FROM EmployeeAttendances e WHERE e.attendanceDate=:attendanceDate AND e.employeeId=:employeeId";

        Query query = HibernateUtil.getCurrentSession().createQuery(hqlQuery);

        for (Entry<String, Object> e : parameterNameAndValues.entrySet()) {
            query.setParameter(e.getKey(), e.getValue());
        }

        return query.list();
    }
   
}
