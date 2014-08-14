package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String alias;
     private int categoryid;
     private int typeid;
     private BigDecimal price;
     private int taxid;
     private int unitid;
     private int currstock;

    public Item() {
    }

    public Item(String name, String alias, int categoryid, int typeid, BigDecimal price, int taxid, int unitid, int currstock) {
       this.name = name;
       this.alias = alias;
       this.categoryid = categoryid;
       this.typeid = typeid;
       this.price = price;
       this.taxid = taxid;
       this.unitid = unitid;
       this.currstock = currstock;
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
    public String getAlias() {
        return this.alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public int getCategoryid() {
        return this.categoryid;
    }
    
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
    public int getTypeid() {
        return this.typeid;
    }
    
    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getTaxid() {
        return this.taxid;
    }
    
    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }
    public int getUnitid() {
        return this.unitid;
    }
    
    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }
    public int getCurrstock() {
        return this.currstock;
    }
    
    public void setCurrstock(int currstock) {
        this.currstock = currstock;
    }




}


