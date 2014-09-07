/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Bhavik
 */
public class UserAuthenticationProvider implements AuthenticationProvider {
 
    private static final String ROLE_PREFIX = "ROLE_";	
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {        
        Collection authorities = new ArrayList(buildRolesFromUser(authentication.getName()));
        authorities.addAll(getActivatedModulesAsRoles());
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(),authorities);
//		} else {
//			throw new BadCredentialsException("Try again");
//		}
    }
 
    private Collection getActivatedModulesAsRoles() {
        List activatedModules = new ArrayList();
        activatedModules.add(new SimpleGrantedAuthority(ROLE_PREFIX + "USER"));			
        return activatedModules;
    }
 
    private Collection buildRolesFromUser(String username) {
        Collection authorities = new HashSet();
 	return authorities;
    }
 
    @Override
    public boolean supports(Class authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}