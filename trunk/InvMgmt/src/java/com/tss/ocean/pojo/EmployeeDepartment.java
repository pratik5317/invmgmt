/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.pojo;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author sweta
 */
public class EmployeeDepartment implements Serializable{
    
    private Integer id;
    @NotEmpty
    private String department;
    @NotEmpty
    private String code;
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" + "id=" + id + ", department=" + department + ", code=" + code + ", isActive=" + isActive + '}';
    }

      
}
