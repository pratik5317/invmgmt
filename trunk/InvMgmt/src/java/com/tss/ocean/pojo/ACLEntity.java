/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bhavik
 */
public class ACLEntity implements Serializable{
    
    private Integer Id;
    private String aclId;
    private Integer entiyId;
    private Integer entiyType;
    private Integer permissionLevel;

    public ACLEntity() {
    }

    public ACLEntity(Integer Id, String aclId, Integer entiyId, Integer entiyType, Integer permissionlevel) {
        this.Id = Id;
        this.aclId = aclId;
        this.entiyId = entiyId;
        this.entiyType = entiyType;
        this.permissionLevel = permissionlevel;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getAclId() {
        return aclId;
    }

    public void setAclId(String aclId) {
        this.aclId = aclId;
    }

    public Integer getEntiyId() {
        return entiyId;
    }

    public void setEntiyId(Integer entiyId) {
        this.entiyId = entiyId;
    }

    public Integer getEntiyType() {
        return entiyType;
    }

    public void setEntiyType(Integer entiyType) {
        this.entiyType = entiyType;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "ACLEntity{" + "Id=" + Id + ", aclId=" + aclId + ", entiyId=" + entiyId + ", entiyType=" + entiyType + ", permissionlevel=" + permissionLevel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Id);
        hash = 53 * hash + Objects.hashCode(this.aclId);
        hash = 53 * hash + Objects.hashCode(this.entiyId);
        hash = 53 * hash + Objects.hashCode(this.entiyType);
        hash = 53 * hash + Objects.hashCode(this.permissionLevel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ACLEntity other = (ACLEntity) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.aclId, other.aclId)) {
            return false;
        }
        if (!Objects.equals(this.entiyId, other.entiyId)) {
            return false;
        }
        if (!Objects.equals(this.entiyType, other.entiyType)) {
            return false;
        }
        if (!Objects.equals(this.permissionLevel, other.permissionLevel)) {
            return false;
        }
        return true;
    }   
}