package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Purrequisition generated by hbm2java
 */
public class Purrequisition implements java.io.Serializable {

    private Integer id;
    private String prno;
    @NotNull
    private Integer suplierid;
    @NotNull
    private Integer status;
    private Integer approvedby;
    private Date approvedbydate;
    private Integer nextapprovedby;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date createdat;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updatedat;
    @NotNull
    private Boolean isbilled;
    private BigDecimal price;
    private Integer createdby;
    private Integer updatedby;
    private Set<Item> items = new HashSet<Item>();
    private List<Purrequisitiondt> purrequisitiondts = new ArrayList<Purrequisitiondt>();

    public Purrequisition() {
    }

    public Purrequisition(Date createdat) {
        this.createdat = createdat;
    }

    public Purrequisition(String prno, Integer suplierid, Integer status, Integer approvedby, Date approvedbydate, Integer nextapprovedby, Date createdat, Date updatedat, Boolean isbilled, BigDecimal price, Integer createdby, Integer updatedby, Set<Item> items) {
        this.prno = prno;
        this.suplierid = suplierid;
        this.status = status;
        this.approvedby = approvedby;
        this.approvedbydate = approvedbydate;
        this.nextapprovedby = nextapprovedby;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.isbilled = isbilled;
        this.price = price;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.items = items;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrno() {
        return this.prno;
    }

    public void setPrno(String prno) {
        this.prno = prno;
    }

    public Integer getSuplierid() {
        return this.suplierid;
    }

    public void setSuplierid(Integer suplierid) {
        this.suplierid = suplierid;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApprovedby() {
        return this.approvedby;
    }

    public void setApprovedby(Integer approvedby) {
        this.approvedby = approvedby;
    }

    public Date getApprovedbydate() {
        return approvedbydate;
    }

    public void setApprovedbydate(Date approvedbydate) {
        this.approvedbydate = approvedbydate;
    }

    public Integer getNextapprovedby() {
        return nextapprovedby;
    }

    public void setNextapprovedby(Integer nextapprovedby) {
        this.nextapprovedby = nextapprovedby;
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

    public Boolean getIsbilled() {
        return this.isbilled;
    }

    public void setIsbilled(Boolean isbilled) {
        this.isbilled = isbilled;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Integer getUpdatedby() {
        return this.updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Purrequisition{" + "id=" + id + ", prno=" + prno + ", suplierid=" + suplierid + ", status=" + status + ", approvedby=" + approvedby + ", approvedbydate=" + approvedbydate + ", nextapprovedby=" + nextapprovedby + ", createdat=" + createdat + ", updatedat=" + updatedat + ", isbilled=" + isbilled + ", price=" + price + ", createdby=" + createdby + ", updatedby=" + updatedby + ", items=" + items + '}';
    }

    public List<Purrequisitiondt> getPurrequisitiondts() {
        return purrequisitiondts;
    }

    public void setPurrequisitiondts(List<Purrequisitiondt> purrequisitiondts) {
        this.purrequisitiondts = purrequisitiondts;
    }

}