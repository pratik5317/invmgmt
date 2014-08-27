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
public class EmployeeCategory implements Serializable {

    private Integer id;
    @NotEmpty
    private String category;
    @NotEmpty
    private String prefix;
    private Integer isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "EmployeeCategory{" + "id=" + id + ", category=" + category + ", prefix=" + prefix + ", isActive=" + isActive + '}';
    }

}
