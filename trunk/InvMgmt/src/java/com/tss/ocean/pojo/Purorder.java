package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * Purorder generated by hbm2java
 */
public class Purorder  implements java.io.Serializable {


     private Integer id;
     private Integer purrequisition;
     private Integer supplier;
     private Date createdat;
     private Date updatedat;
     private Integer createdby;
     private BigDecimal price;
     private Integer updatedby;

    public Purorder() {
    }

	
    public Purorder(Date createdat) {
        this.createdat = createdat;
    }
    public Purorder(Integer purrequisition, Integer supplier, Date createdat, Date updatedat, Integer createdby, BigDecimal price, Integer updatedby) {
       this.purrequisition = purrequisition;
       this.supplier = supplier;
       this.createdat = createdat;
       this.updatedat = updatedat;
       this.createdby = createdby;
       this.price = price;
       this.updatedby = updatedby;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPurrequisition() {
        return this.purrequisition;
    }
    
    public void setPurrequisition(Integer purrequisition) {
        this.purrequisition = purrequisition;
    }
    public Integer getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }
    public Date getCreatedat() {
        return this.createdat;
    }
    
    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
    public Date getUpdatedat() {
        return this.updatedat;
    }
    
    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
    public Integer getCreatedby() {
        return this.createdby;
    }
    
    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getUpdatedby() {
        return this.updatedby;
    }
    
    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }




}


