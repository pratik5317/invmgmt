/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aamir Mansuri
 */
@Controller
public class AuthController {
    
    @RequestMapping(value="/login.html",method= RequestMethod.GET)
    public String getlogin() throws Exception {        
        return "login";
    }   
}