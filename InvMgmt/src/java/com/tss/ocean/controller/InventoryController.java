/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.idao.IItemDAO;
import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.idao.IItemunitDAO;
import com.tss.ocean.pojo.Item;
import com.tss.ocean.pojo.Itemtype;
import com.tss.ocean.pojo.Itemunit;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    IItemunitDAO itemunitDAO;

    @Autowired
    IItemDAO itemDAO;
    

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
            return new ModelAndView("redirect:/item_category.html");
        }
    }

    @RequestMapping(value = "/UpdateItemCategory.html", method = RequestMethod.POST)
    public ModelAndView updateItemCategory(@ModelAttribute("itemTypeForm") @Valid Itemtype itemTypeForm, BindingResult result, Map<String, Object> model) throws Exception {
        logger.log(Level.WARNING, "Update Inventory called with inventory details ####### ." + itemTypeForm);

        if (result.hasErrors()) {
            logger.log(Level.OFF, "Error occured while inserting the reconrd for the item type." + result.getAllErrors());
            ModelAndView modelAndView = new ModelAndView("add-item_category");
            //modelAndView.addObject("itemTypeForm", new Itemtype());
            modelAndView.addAllObjects(model);
            return modelAndView;
        } else {
            Itemtype oldType = itemTypeDAO.getRecordByPrimaryKey(itemTypeForm.getId());
            if(oldType != null) {
                oldType.setName(itemTypeForm.getName());
                oldType.setDescription(itemTypeForm.getDescription());
                int status = itemTypeDAO.update(oldType);
                logger.log(Level.OFF, "Insert result ####### ." + status);
            }
            return new ModelAndView("redirect:/item_category.html");
        }
    }

    @RequestMapping(value = "/AddItemUnits.html", method = RequestMethod.POST)
    public ModelAndView addItemUnits(@ModelAttribute("itemUnit") @Valid Itemunit itemUnit, BindingResult result, Map<String, Object> model) throws Exception {
        logger.log(Level.OFF, "Add Item Units with detail ####### ." + itemUnit);

        if (result.hasErrors()) {
            logger.log(Level.OFF, "Error occured while inserting the reconrd for the item unit." + result.getAllErrors());
            ModelAndView modelAndView = new ModelAndView("add-item_unit");
            //modelAndView.addObject("itemTypeForm", new Itemtype());
            modelAndView.addAllObjects(model);
            return modelAndView;
        } else {
            int status = -1;
            if (itemUnit.getId() == null){
                status = itemunitDAO.insert(itemUnit);
            }else{
                Itemunit oldItemUnit = itemunitDAO.getRecordByPrimaryKey(itemUnit.getId());
                oldItemUnit.setName(itemUnit.getName());
                oldItemUnit.setDescription(itemUnit.getDescription());
                status = itemunitDAO.update(oldItemUnit);
            }
            logger.log(Level.OFF, "Insert result ####### success." + status);
            return new ModelAndView("redirect:/item_unit.html");
        }
    }

    @RequestMapping(value = "/AddItem.html", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute("itemForm") @Valid Item item, BindingResult result, Map<String, Object> model) throws Exception {
        if(item.getId() == null) {
            logger.log(Level.OFF, "Add Item with detail ####### ." + item);
            if (result.hasErrors()) {
                logger.log(Level.OFF, "Error occured while inserting the reconrd for the item." + result.getAllErrors());
                ModelAndView modelAndView = new ModelAndView("add-item");
                //modelAndView.addObject("itemTypeForm", new Itemtype());
                model.put("itemUnitList", itemunitDAO.getList());
                model.put("itemTypeList", itemTypeDAO.getList());
                modelAndView.addAllObjects(model);
                return modelAndView;
            } else {
                item.setAlias("123");
                logger.log(Level.OFF, "Insert result ####### ." + itemDAO.insert(item));
                return new ModelAndView("redirect:/item.html");
            }
        }
        else {
            logger.log(Level.OFF, "Edit Item with detail ####### ." + item);
            if (result.hasErrors()) {
                logger.log(Level.OFF, "Error occured while editing the reconrd for the item." + result.getAllErrors());
                ModelAndView modelAndView = new ModelAndView("add-item");
                //modelAndView.addObject("itemTypeForm", new Itemtype());
                model.put("itemUnitList", itemunitDAO.getList());
                model.put("itemTypeList", itemTypeDAO.getList());
                modelAndView.addAllObjects(model);
                return modelAndView;
            } else {
                Item oldItem = itemDAO.getRecordByPrimaryKey(item.getId());
                oldItem.setName(item.getName());
                oldItem.setPrice(item.getPrice());
                oldItem.setTaxid(item.getTaxid());
                oldItem.setCategoryid(item.getCategoryid());
                oldItem.setCurrstock(item.getCurrstock());            
                logger.log(Level.OFF, "Update result ####### ." + itemDAO.update(oldItem));
                return new ModelAndView("redirect:/item.html");
            }   
        }
    }
    @RequestMapping(value = "/EditItem.html", method = RequestMethod.POST)
    public ModelAndView editItem(@ModelAttribute("itemForm") @Valid Item item, BindingResult result, Map<String, Object> model) throws Exception {
        logger.log(Level.OFF, "Edit Item with detail ####### ." + item);
        if (result.hasErrors()) {
            logger.log(Level.OFF, "Error occured while editing the reconrd for the item." + result.getAllErrors());
            ModelAndView modelAndView = new ModelAndView("add-item");
            //modelAndView.addObject("itemTypeForm", new Itemtype());
            model.put("itemUnitList", itemunitDAO.getList());
            model.put("itemTypeList", itemTypeDAO.getList());
            modelAndView.addAllObjects(model);
            return modelAndView;
        } else {
            Item oldItem = itemDAO.getRecordByPrimaryKey(item.getId());
            oldItem.setName(item.getName());
            oldItem.setPrice(item.getPrice());
            oldItem.setTaxid(item.getTaxid());
            oldItem.setCategoryid(item.getCategoryid());
            oldItem.setCurrstock(item.getCurrstock());            
            logger.log(Level.OFF, "Update result ####### ." + itemDAO.update(oldItem));
            return new ModelAndView("redirect:/item_unit.html");
        }
    }
    @RequestMapping(value = "/DeleteItemCategory.html", method = RequestMethod.POST)
    public ModelAndView deleteItemCategory(@RequestParam("deleteId") int deleteId, Map<String, Object> model) throws Exception {
        logger.log(Level.FINE, "Delete item category called.");
        Itemtype itemType = itemTypeDAO.getRecordByPrimaryKey(deleteId);
        if (itemType != null) {
            int updateResult = itemTypeDAO.delete(itemType);
            if (updateResult > 0) {
                logger.log(Level.INFO, "Item Type with id {0} deleted successfully", itemType.getId());
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting item type with id {0}", itemType.getId());
            }
        }
        logger.log(Level.INFO, "Item Type with id {0} is already deleted", deleteId);
        return new ModelAndView("redirect:/item_category.html");
    }

    @RequestMapping(value = "/DeleteItemUnits.html", method = RequestMethod.POST)
    public ModelAndView deleteItemUnits(@RequestParam("deleteId") int deleteId, Map<String, Object> model) throws Exception {
        logger.log(Level.FINE, "Delete item category units called.");
        Itemunit itemUnit = itemunitDAO.getRecordByPrimaryKey(deleteId);
        if (itemUnit != null) {
            int updateResult = itemunitDAO.delete(itemUnit);
            if (updateResult > 0) {
                logger.log(Level.INFO, "Item Units with id {0} deleted successfully", itemUnit.getId());
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting item units with id {0}", itemUnit.getId());
            }
        }
        logger.log(Level.INFO, "Item Units with id {0} is already deleted", deleteId);
        return new ModelAndView("redirect:/item_unit.html");
    }

    @RequestMapping(value = "/UpdateItemUnits.html")
    public String updateItemUnits(@RequestParam("updateItemId") int updateItemId, Map<String, Object> model) throws Exception {
        logger.log(Level.OFF, "Update Item Unit called.");
        model.put("itemUnit", itemunitDAO.getRecordByPrimaryKey(updateItemId));
        return "update-item_unit";
    }

    @RequestMapping(value = "/UpdateItemCategory.html")
    public String updateItemCategory(@RequestParam("updateItemId") int updateItemId, Map<String, Object> model) throws Exception {
        logger.log(Level.OFF, "Update Item Category called.");
        model.put("itemTypeForm", itemTypeDAO.getRecordByPrimaryKey(updateItemId));
        return "update-item_category";
    }
    @RequestMapping(value = "/UpdateItem.html", method = RequestMethod.GET)
    public String edit_item(@RequestParam("updateItemId") int updateItemId,Map<String, Object> model, HttpServletRequest request) throws Exception {
        logger.log(Level.OFF, "add-item called.");
        model.put("itemForm", itemDAO.getRecordByPrimaryKey(updateItemId));
        model.put("itemUnitList", itemunitDAO.getList());
        model.put("itemTypeList", itemTypeDAO.getList());
        return "add-item";
    }
    
}
