/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.util;

import java.util.Locale;
import org.springframework.context.MessageSource;

/**
 *
 * @author Jenil
 */
public class Utilities {
    
    public static String getSpringMessage(MessageSource messageSource,String key,Locale locale) {
        return messageSource.getMessage(key,null, Constants.DEFAULT_MESSSAGE ,locale);
    }
    
}
