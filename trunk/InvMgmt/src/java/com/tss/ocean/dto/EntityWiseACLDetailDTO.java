/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.dto;

/**
 *
 * @author Bhavik
 */
public class EntityWiseACLDetailDTO {

    private int aclEntityId;
    private String aclId;
    private String aclModule;
    private Integer permissionLevel;

    public int getAclEntityId() {
        return aclEntityId;
    }

    public void setAclEntityId(int aclEntityId) {
        this.aclEntityId = aclEntityId;
    }

    public String getAclId() {
        return aclId;
    }

    public void setAclId(String aclId) {
        this.aclId = aclId;
    }

    public String getAclModule() {
        return aclModule;
    }

    public void setAclModule(String aclModule) {
        this.aclModule = aclModule;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "EntityWiseACLDetailDTO{" + "aclEntityId=" + aclEntityId + ", aclId=" + aclId + ", aclModule=" + aclModule + ", permissionLevel=" + permissionLevel + '}';
    }

}
