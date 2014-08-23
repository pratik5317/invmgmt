/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.sg.jqgrid;

/**
 *
 * @author Aamir
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JqGridData {

    /**
     * Total number of pages
     */
    private int total;
    /**
     * The current page number
     */
    private String sEcho;
    /**
     * Total number of records
     */
    private int iTotalRecords;
    /**
     * Total number of records
     */
    private int iTotalDisplayRecords;
    
    /**
     * The actual data
     */
    private List rows;

    public JqGridData(String sEcho, int iTotalDisplayRecords, int iTotalRecords, List rows) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
        this.sEcho = sEcho;
        this.iTotalRecords = iTotalRecords;
        this.rows = rows;
    }

//    public int getTotal() {
//        return total;
//    }
//
//    public int getPage() {
//        return sEcho;
//    }
//
//    public int getRecords() {
//        return iTotalRecords;
//    }
//
//    public List<T> getRows() {
//        return rows;
//    }

    public String getJsonString() {

       ObjectMapper maper = new ObjectMapper();

        Map<String, Object> map;
        map = new HashMap();
        map.put("sEcho", sEcho);
        map.put("iTotalRecords", iTotalRecords);
        map.put("iTotalDisplayRecords", iTotalDisplayRecords);
        map.put("aaData", (rows));
        String json = "";
        try {
            json = maper.writeValueAsString(map);
        } catch (JsonGenerationException ex) {
            Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonMappingException ex) {
            Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  return JSONValue.toJSONString(map);
        return json;
    }
}