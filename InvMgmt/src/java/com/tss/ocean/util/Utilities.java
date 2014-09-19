/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;
import org.springframework.context.MessageSource;


public class Utilities {
    private static final SecureRandom random = new SecureRandom();

    public static String getSpringMessage(MessageSource messageSource,String key,Locale locale) {
        return messageSource.getMessage(key,null, Constants.DEFAULT_MESSSAGE ,locale);
    }
    
    public static String getRandomString(int length) {
        return new BigInteger(length, random).toString();
    }
}
