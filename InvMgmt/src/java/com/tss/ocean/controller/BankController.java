/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IBankDAO;
import com.tss.ocean.idao.ICountryDAO;
import com.tss.ocean.pojo.Bank;
import com.tss.ocean.pojo.Country;
import com.tss.ocean.util.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VinitShah
 */
@Controller
public class BankController {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @Autowired
    private IBankDAO bankDAO;

    @Autowired
    private ICountryDAO countryDAO;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/add-bank.html", method = RequestMethod.GET)
    public ModelAndView add_bank_get(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add-bank called.");
        ModelAndView mav = new ModelAndView("add_bank");
        Bank bank = new Bank();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("countryList", countryDAO.getList());
        System.out.println("co" + countryDAO.getList());
        mav.getModelMap().put("bank", bank);
        return mav;
    }

    @RequestMapping(value = "/add-bank.html", method = RequestMethod.POST)
    public ModelAndView add_bank_post(@ModelAttribute("purorder") @Valid Bank bank,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add-bank-post called.");
        if (!result.hasErrors()) {
            int insertResult = bankDAO.insert(bank);
            if (insertResult > 0) {
                System.out.println("Bank Added");
                logger.log(Level.INFO, "Bank Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add-bank.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "bank.add.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred inserting bank:{0}", bank.toString());
                model.put("countryList", countryDAO.getList());
                return new ModelAndView("purchase_order", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "bank.add.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Bank values are not valid:", bank.toString());
            model.put("countryList", countryDAO.getList());
            return new ModelAndView("purchase_order", model);
        }
    }

    @RequestMapping(value = "/bank.html", method = RequestMethod.GET)
    public ModelAndView getBanks(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("fetch Banks called.");
        ModelAndView mav = new ModelAndView("banks-list");
        List<Bank> bankList = bankDAO.getList();
        System.out.println(bankList.size());
        mav.getModelMap().put("bankList", bankList);
        
        List<Country> countryList=countryDAO.getList();
        Map<Integer,String> countryMap = new HashMap<Integer,String>(countryList.size());
        for (Country c : countryList) {
            countryMap.put(c.getId(), c.getName());
        }
        mav.getModelMap().put("countryMap", countryMap);
        
        return mav;
    }

    @RequestMapping(value = "/edit-bank.html", method = RequestMethod.GET)
    public ModelAndView edit_bank_get(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.log(Level.FINE, "edit-bank called.");
        ModelAndView mav;
        Bank bank = bankDAO.getRecordByPrimaryKey(id);
        if (bank != null) {
            mav = new ModelAndView("add_bank");
            mav.getModelMap().put("bank", bank);
            mav.getModelMap().put("countryList", countryDAO.getList());
        } else {
            mav = new ModelAndView("redirect:add-bank.html");
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit-bank.html", method = RequestMethod.POST)
    public ModelAndView edit_bank_post(@ModelAttribute("bank") @Valid Bank bank,
            BindingResult result,
            ModelMap model,
            Locale locale,HttpServletRequest request) throws Exception {
        logger.log(Level.FINE, "edit-bank-post called.");
        if (!result.hasErrors()) {
            int updateResult = bankDAO.update(bank);
            if (updateResult > 0) {
                logger.log(Level.INFO, "bank updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:bank.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "purorder.update.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred updating purchase_order:{0}", bank.toString());
                model.put("countryList", countryDAO.getList());
                return new ModelAndView("add_bank", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "purorder.update.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Purchase_order values are not valid:", bank.toString());
            model.put("countryList", countryDAO.getList());
            return new ModelAndView("purchase_order", model);
        }
    }

    @RequestMapping(value = "/delete-bank.html")
    @ResponseBody
    public boolean delete_bank(@RequestParam(value = "id") int id) throws Exception {
        logger.log(Level.FINE, "delete-bank called.");
        Bank bank = bankDAO.getRecordByPrimaryKey(id);
        if (bank != null) {
            int updateResult = bankDAO.delete(bank);
            if (updateResult > 0) {
                logger.log(Level.INFO, "Bank with id {0} deleted successfully", bank.getId());
                return true;
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting bank with id {0}", bank.getId());
                return false;
            }
        }
        logger.log(Level.INFO, "Bank with id {0} is already deleted", id);
        return true;
    }

}
