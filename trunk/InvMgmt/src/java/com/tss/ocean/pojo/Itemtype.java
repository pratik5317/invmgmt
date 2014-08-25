package com.tss.ocean.pojo;
// Generated 4 Aug, 2014 6:30:10 PM by Hibernate Tools 3.2.1.GA

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Itemtype generated by hbm2java
 *
 * @author Bhavik Ambani
 */
public class Itemtype implements java.io.Serializable {

    private Integer id;

    @NotEmpty(message = "Please enter item name.")
    @Size(min = 10, max = 45, message = "Item name must between 1 and 45 characters")
    private String name;

    @Size(min = 0, max = 65535, message = "Item description must between 0 and 65535 characters")
    private String description;

    public Itemtype() {
    }

    public Itemtype(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Itemtype{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

}