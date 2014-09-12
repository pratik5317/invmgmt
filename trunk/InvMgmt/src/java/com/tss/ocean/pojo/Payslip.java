/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesng firstname;
 * and open the template in the editor.
 */

package com.tss.ocean.pojo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sweta
 */
public class Payslip implements Serializable{
    
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private Double salary;
    private Double deductions;
    private Double total;
    private List<MonthlyPayslips> salaryList;
    private List<MonthlyPayslips> deductionList;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<MonthlyPayslips> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<MonthlyPayslips> salaryList) {
        this.salaryList = salaryList;
    }

    public List<MonthlyPayslips> getDeductionList() {
        return deductionList;
    }

    public void setDeductionList(List<MonthlyPayslips> deductionList) {
        this.deductionList = deductionList;
    }

    @Override
    public String toString() {
        return "Payslip{" + "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeNumber=" + employeeNumber + ", salary=" + salary + ", deductions=" + deductions + ", total=" + total + ", salaryList=" + salaryList + ", deductionList=" + deductionList + '}';
    }
    
    
    
    
}
