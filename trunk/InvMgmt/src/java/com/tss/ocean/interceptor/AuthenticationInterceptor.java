/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.interceptor;

import com.tss.ocean.pojo.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aamir Mansuri
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.log(Level.OFF, "Interceptor: Pre-handle"+request.getRequestURI()+":"+request.getContextPath());
        // Avoid a redirect loop for some urls
        if (!request.getRequestURI().equals(request.getContextPath()) 
                // && !request.getRequestURI().equals("/sample-interc/login.failed")
                && !request.getRequestURI().equals(request.getContextPath()+"/login.htm")) {
            Users userData = (Users) request.getSession().getAttribute("LOGGEDIN_USER");
            if (userData == null) {
                response.sendRedirect(request.getContextPath()+"/login.htm");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
        logger.log(Level.CONFIG, "post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        logger.log(Level.CONFIG, "post handle");
    }
}
