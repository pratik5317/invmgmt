package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA

import org.hibernate.validator.constraints.NotEmpty;




/**
 * PayrollCategories generated by hbm2java
 */
public class PayrollCategories  implements java.io.Serializable {


     private Integer id;
     @NotEmpty
     private String name;
     private Float percentage;
     private Integer payrollCategoryId;
     private Boolean isDeduction;
     private Boolean status;

    public PayrollCategories() {
    }

    public PayrollCategories(String name, Float percentage, Integer payrollCategoryId, Boolean isDeduction, Boolean status) {
       this.name = name;
       this.percentage = percentage;
       this.payrollCategoryId = payrollCategoryId;
       this.isDeduction = isDeduction;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Float getPercentage() {
        return this.percentage;
    }
    
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
    public Integer getPayrollCategoryId() {
        return this.payrollCategoryId;
    }
    
    public void setPayrollCategoryId(Integer payrollCategoryId) {
        this.payrollCategoryId = payrollCategoryId;
    }
    public Boolean getIsDeduction() {
        return this.isDeduction;
    }
    
    public void setIsDeduction(Boolean isDeduction) {
        this.isDeduction = isDeduction;
    }
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }




}


