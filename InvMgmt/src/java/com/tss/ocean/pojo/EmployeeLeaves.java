package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * EmployeeLeaves generated by hbm2java
 */
public class EmployeeLeaves  implements java.io.Serializable {


     private Integer id;
     private Integer employeeId;
     private Integer employeeLeaveTypeId;
     private BigDecimal leaveCount;
     private BigDecimal leaveTaken;
     private Date resetDate;
     private Date createdAt;
     private Date updatedAt;

    public EmployeeLeaves() {
    }

    public EmployeeLeaves(Integer employeeId, Integer employeeLeaveTypeId, BigDecimal leaveCount, BigDecimal leaveTaken, Date resetDate, Date createdAt, Date updatedAt) {
       this.employeeId = employeeId;
       this.employeeLeaveTypeId = employeeLeaveTypeId;
       this.leaveCount = leaveCount;
       this.leaveTaken = leaveTaken;
       this.resetDate = resetDate;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public BigDecimal getLeaveCount() {
        return this.leaveCount;
    }
    
    public void setLeaveCount(BigDecimal leaveCount) {
        this.leaveCount = leaveCount;
    }
    public BigDecimal getLeaveTaken() {
        return this.leaveTaken;
    }
    
    public void setLeaveTaken(BigDecimal leaveTaken) {
        this.leaveTaken = leaveTaken;
    }
    public Date getResetDate() {
        return this.resetDate;
    }
    
    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}


