/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.pojo.Users;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Aamir Mansuri
 */
@Controller
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());
    
    @RequestMapping(value="login.html",method= RequestMethod.POST)    
    public String login(Model model, Users loginform, Locale locale, HttpServletRequest request) throws Exception {
 
        String username = loginform.getName();
        String password = loginform.getPassword();
 
        // A simple authentication manager
        if(username != null && password != null && !("").equals(username) 
                && !("").equals(password)){                           
                
//            if( username.equals(settings.getString("username")) &&  password.equals(settings.getObject("password")) ){
                //return "welcome";
                request.getSession().setAttribute("LOGGEDIN_USER", loginform);
                //to do ..
                //set the title here...
                request.getSession().setAttribute("title", "Management System 1.0");
                
                return "redirect:/";
//                return "redirect:/?lang=ar";//to set locale here...
//            }else{
//                return "redirect:/login.failed";
//            }
        }else{
            return "redirect:/login.html";
        }  
    }
    
    @RequestMapping(value="/login.html",method= RequestMethod.GET)
    public String getlogin(Model model, Users loginform) throws Exception {
        logger.log(Level.OFF,"getlogin called.");        
        return "login";
    }
    
    @RequestMapping(value="/logout.html",method= RequestMethod.GET)
    public String logout(Model model, Users loginform,HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"logout called.");
        request.getSession().invalidate();
        model.addAttribute("loginAttribute", loginform);
        return "login";
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        logger.log(Level.OFF,"index called.");
        boolean allow = request.isUserInRole("ROLE_USER");
        if(allow) {
            return "index";
        }
        else {
            return "login";
        }
    }
}