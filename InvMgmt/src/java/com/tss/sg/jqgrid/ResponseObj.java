/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.sg.jqgrid;

/**
 *
 * @author Aamir Mansuri
 */
public class ResponseObj {
    private int status;
    private String id="";
    private Object message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" + "\"status\":" + status + ",\"id\":\""+id+"\", \"message\":\"" + message + "\"}";
    }
    
    
}
