/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.pojo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author sweta
 */
public class AttendanceDate {
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fromDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date toDate;
    private String employee;
    private Integer presentDays;
    private Integer absentDays;
    private Integer totalDays;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(Integer presentDays) {
        this.presentDays = presentDays;
    }

    public Integer getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(Integer absentDays) {
        this.absentDays = absentDays;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }
    
    
    
}
