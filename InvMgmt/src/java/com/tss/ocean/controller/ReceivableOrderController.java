/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tss.ocean.controller;

import com.tss.ocean.idao.ICreditDebitDAO;
import com.tss.ocean.idao.IReceivableOrderDAO;
import com.tss.ocean.pojo.CreditDebit;
import com.tss.ocean.pojo.ReceivableOrder;
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
public class ReceivableOrderController {
     private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @Autowired
    private IReceivableOrderDAO receivableOrderDAO;
   @Autowired
    private MessageSource messageSource;
   
    @RequestMapping(value = "/add_receivableorder.html", method = RequestMethod.GET)
    public ModelAndView add_receivableorder_get(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add_receivableorder called.");
        ModelAndView mav = new ModelAndView("add_receivableorder");
        ReceivableOrder receivableOrder = new ReceivableOrder();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("receivableOrder", receivableOrder);
        return mav;
    }

    @RequestMapping(value = "/add_receivableorder.html", method = RequestMethod.POST)
    public ModelAndView add_receivableorder_post(@ModelAttribute("receivableOrder") @Valid ReceivableOrder receivableOrder,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add_receivableorder-post called.");
        if (!result.hasErrors()) {
            int insertResult = receivableOrderDAO.insert(receivableOrder);
            if (insertResult > 0) {
                System.out.println("Receivable Order Added");
                logger.log(Level.INFO, "Receivable Order Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add_receivableorder.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "receivableorder.add.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred inserting receivableOrder :{0}", receivableOrder);
               
                return new ModelAndView("add_receivableorder", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "receivableorder.add.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Receivable ORder values are not valid:", receivableOrder);
            return new ModelAndView("add_receivableorder", model);
        }
    }

    @RequestMapping(value = "/receivable_order.html", method = RequestMethod.GET)
    public ModelAndView getCreditDebit(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.info("fetch Banks called.");
        ModelAndView mav = new ModelAndView("receivable_order");
        List<ReceivableOrder> receivableOrderList = receivableOrderDAO.getList();
        mav.getModelMap().put("receivableOrderList", receivableOrderList);
        return mav;
    }

    @RequestMapping(value = "/edit_receivableorder.html", method = RequestMethod.GET)
    public ModelAndView edit_add_receivableorder_get(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.log(Level.FINE, "edit_receivableorder called.");
        ModelAndView mav;
        ReceivableOrder receivableOrder = receivableOrderDAO.getRecordByPrimaryKey(id);
        if (receivableOrder != null) {
            mav = new ModelAndView("add_receivableorder");
            mav.getModelMap().put("receivableOrder", receivableOrder);
           
        } else {
            mav = new ModelAndView("redirect:add_receivableorder.html");
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit_receivableorder.html", method = RequestMethod.POST)
    public ModelAndView edit_receivableorder_post(@ModelAttribute("receivableOrder") @Valid ReceivableOrder receivableOrder,
            BindingResult result,
            ModelMap model,
            Locale locale,HttpServletRequest request) throws Exception {
        logger.log(Level.FINE, "edit_receivableorder_post called.");
        if (!result.hasErrors()) {
            int updateResult = receivableOrderDAO.update(receivableOrder);
            if (updateResult > 0) {
                logger.log(Level.INFO, "receivableOrder updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:add_receivableorder.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "receivableorder.update.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred updating receivableOrder:{0}", receivableOrder);
                return new ModelAndView("add_receivableorder", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "receivableorder.update.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "receivableorder values are not valid:", receivableOrder);
            ModelAndView mav = new ModelAndView("add_receivableorder",model);
            mav.getModelMap().put("receivableOrder", receivableOrder);
            return mav;
        }
    }

    @RequestMapping(value = "/delete_receivableorder.html")
    @ResponseBody
    public boolean delete_bank(@RequestParam(value = "id") int id) throws Exception {
        logger.log(Level.FINE, "delete_creditdebit called.");
       ReceivableOrder receivableOrder = receivableOrderDAO.getRecordByPrimaryKey(id);
        if (receivableOrder != null) {
            int updateResult = receivableOrderDAO.delete(receivableOrder);
            if (updateResult > 0) {
                logger.log(Level.INFO, "receivableOrder with id {0} deleted successfully", receivableOrder.getId());
                return true;
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting receivableOrder with id {0}", receivableOrder.getId());
                return false;
            }
        }
        logger.log(Level.INFO, "receivableOrder with id {0} is already deleted", id);
        return true;
    }
}
