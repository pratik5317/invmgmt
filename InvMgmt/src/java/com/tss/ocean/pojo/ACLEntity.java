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
    private Integer entityId;
    private Integer entityType;
    private Integer permissionLevel;

    public ACLEntity() {
    }

    public ACLEntity(Integer Id, String aclId, Integer entityId, Integer entityType, Integer permissionlevel) {
        this.Id = Id;
        this.aclId = aclId;
        this.entityId = entityId;
        this.entityType = entityType;
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

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entiyId) {
        this.entityId = entiyId;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "ACLEntity{" + "Id=" + Id + ", aclId=" + aclId + ", entityId=" + entityId + ", entityType=" + entityType + ", permissionlevel=" + permissionLevel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Id);
        hash = 53 * hash + Objects.hashCode(this.aclId);
        hash = 53 * hash + Objects.hashCode(this.entityId);
        hash = 53 * hash + Objects.hashCode(this.entityType);
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
        if (!Objects.equals(this.entityId, other.entityId)) {
            return false;
        }
        if (!Objects.equals(this.entityType, other.entityType)) {
            return false;
        }
        if (!Objects.equals(this.permissionLevel, other.permissionLevel)) {
            return false;
        }
        return true;
    }   
}