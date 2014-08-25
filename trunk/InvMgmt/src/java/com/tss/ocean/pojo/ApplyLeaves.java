package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * ApplyLeaves generated by hbm2java
 */
public class ApplyLeaves  implements java.io.Serializable {


     private Integer id;
     private Integer employeeId;
     private Integer employeeLeaveTypesId;
     private Boolean isHalfDay;
     private Date startDate;
     private Date endDate;
     private String reason;
     private Boolean approved;
     private Boolean viewedByManager;
     private String managerRemark;

    public ApplyLeaves() {
    }

    public ApplyLeaves(Integer employeeId, Integer employeeLeaveTypesId, Boolean isHalfDay, Date startDate, Date endDate, String reason, Boolean approved, Boolean viewedByManager, String managerRemark) {
       this.employeeId = employeeId;
       this.employeeLeaveTypesId = employeeLeaveTypesId;
       this.isHalfDay = isHalfDay;
       this.startDate = startDate;
       this.endDate = endDate;
       this.reason = reason;
       this.approved = approved;
       this.viewedByManager = viewedByManager;
       this.managerRemark = managerRemark;
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
    public Integer getEmployeeLeaveTypesId() {
        return this.employeeLeaveTypesId;
    }
    
    public void setEmployeeLeaveTypesId(Integer employeeLeaveTypesId) {
        this.employeeLeaveTypesId = employeeLeaveTypesId;
    }
    public Boolean getIsHalfDay() {
        return this.isHalfDay;
    }
    
    public void setIsHalfDay(Boolean isHalfDay) {
        this.isHalfDay = isHalfDay;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    public Boolean getViewedByManager() {
        return this.viewedByManager;
    }
    
    public void setViewedByManager(Boolean viewedByManager) {
        this.viewedByManager = viewedByManager;
    }
    public String getManagerRemark() {
        return this.managerRemark;
    }
    
    public void setManagerRemark(String managerRemark) {
        this.managerRemark = managerRemark;
    }




}

