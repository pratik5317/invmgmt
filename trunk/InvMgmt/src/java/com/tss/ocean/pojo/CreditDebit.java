/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ssweta
 */
public class CreditDebit implements Serializable{

    private Integer id;
    @NotNull
    private String referenceNumber;
    @NotEmpty
    private String creditOrDebit;
    @NotNull
    private Double amount;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCreditOrDebit() {
        return creditOrDebit;
    }

    public void setCreditOrDebit(String creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CreditDebit{" + "id=" + id + ", referenceNumber=" + referenceNumber + ", creditOrDebit=" + creditOrDebit + ", amount=" + amount + ", date=" + date + '}';
    }

}
