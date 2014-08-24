/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.pojo.Itemtype;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bhavik
 */
@Controller

public class InventoryController {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @Autowired
    IItemtypeDAO itemTypeDAO;

    @RequestMapping(value = "/AddInventory.html", method = RequestMethod.POST)
    public ModelAndView inventorymgmt(@ModelAttribute("itemTypeForm") @Valid Itemtype itemTypeForm, BindingResult result, Map<String, Object> model) throws Exception {
        logger.log(Level.OFF, "Add Inventory called with inventory details ####### ." + itemTypeForm);

        if (result.hasErrors()) {
            logger.log(Level.OFF, "Error occured while inserting the reconrd for the item type." + result.getAllErrors());
            ModelAndView modelAndView = new ModelAndView("add-item_category");
            //modelAndView.addObject("itemTypeForm", new Itemtype());
            modelAndView.addAllObjects(model);
            return modelAndView;
        } else {
            logger.log(Level.OFF, "Insert result ####### ." + itemTypeDAO.insert(itemTypeForm));
            return new ModelAndView("redirect://item_category.html");        }
    }

}
