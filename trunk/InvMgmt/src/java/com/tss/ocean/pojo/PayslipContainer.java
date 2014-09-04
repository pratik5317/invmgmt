/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author sweta
 */
public class PayslipContainer implements Serializable{

    private Integer employeeId;
    private List<MonthlyPayslips> monthlyPayslipList;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date salaryDate;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<MonthlyPayslips> getMonthlyPayslipList() {
        return monthlyPayslipList;
    }

    public void setMonthlyPayslipList(List<MonthlyPayslips> monthlyPayslipList) {
        this.monthlyPayslipList = monthlyPayslipList;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    @Override
    public String toString() {
        return "PayslipContainer{" + "employeeId=" + employeeId + ", monthlyPayslipList=" + monthlyPayslipList + ", salaryDate=" + salaryDate + '}';
    }
    
    

}
