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
public class ACL implements Serializable {
    
    private String aclId;
    private String aclModule;
    private String parentAclId;

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

    public String getParentAclId() {
        return parentAclId;
    }

    public void setParentAclId(String parentAclId) {
        this.parentAclId = parentAclId;
    }

    @Override
    public String toString() {
        return "ACL{" + "aclId=" + aclId + ", aclModule=" + aclModule + ", parentAclId=" + parentAclId + '}';
    }

    public ACL(String aclId, String aclModule, String parentAclId) {
        this.aclId = aclId;
        this.aclModule = aclModule;
        this.parentAclId = parentAclId;
    }

    public ACL() {
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ACL other = (ACL) obj;
        if (!Objects.equals(this.aclId, other.aclId)) {
            return false;
        }
        if (!Objects.equals(this.aclModule, other.aclModule)) {
            return false;
        }
        if (!Objects.equals(this.parentAclId, other.parentAclId)) {
            return false;
        }
        return true;
    }
    
}
