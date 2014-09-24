/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.controller;

import com.tss.ocean.idao.ICreditDebitDAO;
import com.tss.ocean.pojo.CreditDebit;
import com.tss.ocean.util.Utilities;
import java.util.List;
import java.util.Locale;
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
 * @author ssweta
 */
@Controller
public class CreditDebitController {
     private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @Autowired
    private ICreditDebitDAO creditDebitDAO;
   @Autowired
    private MessageSource messageSource;
   
    @RequestMapping(value = "/add_creditdebit.html", method = RequestMethod.GET)
    public ModelAndView add_creditdebit_get(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add_creditdebit called.");
        ModelAndView mav = new ModelAndView("add_creditdebit");
        CreditDebit creditDebit = new CreditDebit();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("creditDebit", creditDebit);
        return mav;
    }

    @RequestMapping(value = "/add_creditdebit.html", method = RequestMethod.POST)
    public ModelAndView add_credidebit_post(@ModelAttribute("creditDebit") @Valid CreditDebit creditDebit,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add_creditdebit-post called.");
        if (!result.hasErrors()) {
            int insertResult = creditDebitDAO.insert(creditDebit);
            if (insertResult > 0) {
                System.out.println("creditDebit Added");
                logger.log(Level.INFO, "creditDebit Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add_creditdebit.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "creditdebit.add.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred inserting bank:{0}", creditDebit);
               
                return new ModelAndView("purchase_order", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "creditdebit.add.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "CreditDebit values are not valid:", creditDebit);
            return new ModelAndView("add_creditdebit", model);
        }
    }

    @RequestMapping(value = "/credit_debit.html", method = RequestMethod.GET)
    public ModelAndView getCreditDebit(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("fetch Banks called.");
        ModelAndView mav = new ModelAndView("credit_debit");
        List<CreditDebit> creditDebitList = creditDebitDAO.getList();
        mav.getModelMap().put("creditDebitList", creditDebitList);
        return mav;
    }

    @RequestMapping(value = "/edit_creditdebit.html", method = RequestMethod.GET)
    public ModelAndView edit_creditdebit_get(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.log(Level.FINE, "edit_creditdebit called.");
        ModelAndView mav;
        CreditDebit creditDebit = creditDebitDAO.getRecordByPrimaryKey(id);
        if (creditDebit != null) {
            mav = new ModelAndView("add_creditdebit");
            mav.getModelMap().put("creditDebit", creditDebit);
           
        } else {
            mav = new ModelAndView("redirect:add_creditdebit.html");
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_creditdebit.html", method = RequestMethod.POST)
    public ModelAndView edit_creditdebit_post(@ModelAttribute("creditDebit") @Valid CreditDebit creditDebit,
            BindingResult result,
            ModelMap model,
            Locale locale,HttpServletRequest request) throws Exception {
        logger.log(Level.FINE, "edit_creditdebit-post called.");
        if (!result.hasErrors()) {
            int updateResult = creditDebitDAO.update(creditDebit);
            if (updateResult > 0) {
                logger.log(Level.INFO, "creditdebit updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:credit_debit.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "creditdebit.update.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred updating creditdebit:{0}", creditDebit);
                return new ModelAndView("add_bank", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "creditdebit.update.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Purchase_order values are not valid:", creditDebit);
            return new ModelAndView("purchase_order", model);
        }
    }

    @RequestMapping(value = "/delete_creditdebit.html")
    @ResponseBody
    public boolean delete_bank(@RequestParam(value = "id") int id) throws Exception {
        logger.log(Level.FINE, "delete_creditdebit called.");
       CreditDebit creditDebit = creditDebitDAO.getRecordByPrimaryKey(id);
        if (creditDebit != null) {
            int updateResult = creditDebitDAO.delete(creditDebit);
            if (updateResult > 0) {
                logger.log(Level.INFO, "creditdebit with id {0} deleted successfully", creditDebit.getId());
                return true;
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting creditdebit with id {0}", creditDebit.getId());
                return false;
            }
        }
        logger.log(Level.INFO, "creditdebit with id {0} is already deleted", id);
        return true;
    }
}
