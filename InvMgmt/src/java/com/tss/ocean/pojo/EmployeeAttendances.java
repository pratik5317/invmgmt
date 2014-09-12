package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * EmployeeAttendances generated by hbm2java
 */
public class EmployeeAttendances implements java.io.Serializable {

    private Integer id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date attendanceDate;
    @NotNull
    private Integer employeeId;
    private Integer employeeLeaveTypeId;
    private String reason;
    private Boolean isHalfDay;
    private String inTime;
    private String outTime;
    private Integer inHour;
    private Integer inMinutes;
    private Integer outHour;
    private Integer outMinutes;
    private Boolean isLeave;

    public EmployeeAttendances() {
    }

    public EmployeeAttendances(Date attendanceDate, Integer employeeId, Integer employeeLeaveTypeId, String reason, Boolean isHalfDay) {
        this.attendanceDate = attendanceDate;
        this.employeeId = employeeId;
        this.employeeLeaveTypeId = employeeLeaveTypeId;
        this.reason = reason;
        this.isHalfDay = isHalfDay;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAttendanceDate() {
        return this.attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeLeaveTypeId() {
        return this.employeeLeaveTypeId;
    }

    public void setEmployeeLeaveTypeId(Integer employeeLeaveTypeId) {
        this.employeeLeaveTypeId = employeeLeaveTypeId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getIsHalfDay() {
        return this.isHalfDay;
    }

    public void setIsHalfDay(Boolean isHalfDay) {
        this.isHalfDay = isHalfDay;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getInHour() {
        return inHour;
    }

    public void setInHour(Integer inHour) {
        this.inHour = inHour;
    }

    public Integer getInMinutes() {
        return inMinutes;
    }

    public void setInMinutes(Integer inMinutes) {
        this.inMinutes = inMinutes;
    }

    public Integer getOutHour() {
        return outHour;
    }

    public void setOutHour(Integer outHour) {
        this.outHour = outHour;
    }

    public Integer getOutMinutes() {
        return outMinutes;
    }

    public void setOutMinutes(Integer outMinutes) {
        this.outMinutes = outMinutes;
    }

    public Boolean getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Boolean isLeave) {
        this.isLeave = isLeave;
    }

}
