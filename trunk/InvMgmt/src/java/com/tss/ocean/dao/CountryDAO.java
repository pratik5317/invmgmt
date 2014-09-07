/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.ICountryDAO;
import com.tss.ocean.pojo.Country;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VinitShah
 */
@Repository("countryDAO")
public class CountryDAO extends GenericDAOImpl<Country, Integer> implements ICountryDAO{
    
}
