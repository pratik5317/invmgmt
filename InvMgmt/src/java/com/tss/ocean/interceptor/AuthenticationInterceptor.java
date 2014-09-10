/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.interceptor;

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
        logger.log(Level.OFF, "Interceptor: Pre-handle{0}:{1}", new Object[]{request.getRequestURI(), request.getContextPath()});
        if (!request.getRequestURI().equals(request.getContextPath()) && !request.getRequestURI().equals(request.getContextPath()+"/login.html")) {
            boolean allow = request.isUserInRole("ROLE_USER");
            if(!allow) {
                response.sendRedirect(request.getContextPath()+"/login.html");
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