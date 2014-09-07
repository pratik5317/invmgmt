package com.tss.ocean.controller;

import com.tss.ocean.idao.IAccountsDAO;
import com.tss.ocean.idao.IPurorderDAO;
import com.tss.ocean.idao.IPurrequisitionDAO;
import com.tss.ocean.pojo.Accounts;
import com.tss.ocean.pojo.Purorder;
import com.tss.ocean.pojo.Purrequisition;
import com.tss.ocean.util.Constants;
import com.tss.ocean.util.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * @author Bhavik
 */
@Controller
public class PurorderController {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @Autowired
    IPurorderDAO purorderDAO;

    @Autowired
    IAccountsDAO accountsDAO;

    @Autowired
    IPurrequisitionDAO purrequisitionDAO;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/add-purchase_order.html", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission(#ts_purchaseorder,'add')")
    public ModelAndView add_purorder_get(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add-purchase_order called.");
        ModelAndView mav = new ModelAndView("purchase_order");
        Purorder purorder = new Purorder();
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("supplierList", getSupplierList());
        mav.getModelMap().put("purrequisitionList", getPurrequisitionList());
        mav.getModelMap().put("purorder", purorder);
        return mav;
    }

    @RequestMapping(value = "/add-purchase_order.html", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission(#ts_purchaseorder,'add')")
    public ModelAndView add_purorder_post(@ModelAttribute("purorder") @Valid Purorder purorder,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add-purchase_order-post called.");
        if (!result.hasErrors()) {
            purorder.setCreatedby(1);
            int insertResult = purorderDAO.insert(purorder);
            if (insertResult > 0) {
                logger.log(Level.INFO, "Purorder Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add-purchase_order.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "purorder.add.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred inserting purorder:{0}", purorder.toString());
                model.put("supplierList", getSupplierList());
                model.put("purrequisitionList", getPurrequisitionList());
                return new ModelAndView("purchase_order", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "purorder.add.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Purchase_order values are not valid:", purorder.toString());
            model.put("supplierList", getSupplierList());
            model.put("purrequisitionList", getPurrequisitionList());
            return new ModelAndView("purchase_order", model);
        }
    }

    @RequestMapping(value = "/edit-purchase_order.html", method = RequestMethod.GET)
    public ModelAndView edit_purorder_get(@RequestParam(value = "id") int id,
            Locale locale,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error) throws Exception {
        logger.log(Level.FINE, "edit-purchase_order called.");
        ModelAndView mav;
        Purorder purorder = purorderDAO.getRecordByPrimaryKey(id);
        if (purorder != null) {
            mav = new ModelAndView("purchase_order");
            mav.getModelMap().put("purorder", purorder);
            mav.getModelMap().put("supplierList", getSupplierList());
            mav.getModelMap().put("purrequisitionList", getPurrequisitionList());
        } else {
            mav = new ModelAndView("redirect:purchase_order.html");
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/edit-purchase_order.html", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission(#ts_purchaseorder,'edit')")
    public ModelAndView edit_purorder_post(@ModelAttribute("purorder") @Valid Purorder purorder,
            BindingResult result,
            ModelMap model,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "edit-purchase_order-post called.");
        if (!result.hasErrors()) {
            int updateResult = purorderDAO.update(purorder);
            if (updateResult > 0) {
                logger.log(Level.INFO, "purchase_order updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:purchase_order.html")
                        .addObject("success", Utilities.getSpringMessage(messageSource, "purorder.update.success", locale));
            } else {
                logger.log(Level.WARNING, "Error occurred updating purchase_order:{0}", purorder.toString());
                model.put("supplierList", getSupplierList());
                model.put("purrequisitionList", getPurrequisitionList());
                return new ModelAndView("purchase_order", model)
                        .addObject("error", Utilities.getSpringMessage(messageSource, "purorder.update.error", locale));
            }
        } else {
            logger.log(Level.WARNING, "Purchase_order values are not valid:", purorder.toString());
            model.put("supplierList", getSupplierList());
            model.put("purrequisitionList", getPurrequisitionList());
            return new ModelAndView("purchase_order", model);
        }
    }

    @RequestMapping(value = "/purchase_order.html", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission(#ts_purchaseorder,'view')")
    public ModelAndView purorder(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            Locale locale) throws Exception {
        logger.log(Level.FINE, "add-purchase_order called.");
        ModelAndView mav = new ModelAndView("purchase_order-list");
        List<Purrequisition> purrequisitionList = purrequisitionDAO.getList();
        HashMap<Integer, String> purrequisitionMap = new HashMap<>(purrequisitionList.size());
        for (Purrequisition purrequisition : purrequisitionList) {
            purrequisitionMap.put(purrequisition.getId(), purrequisition.getPrno());
        }

        List<Accounts> accountsList = accountsDAO.getList();
        HashMap<Integer, String> accountMap = new HashMap<>(accountsList.size());
        for (Accounts account : accountsList) {
            accountMap.put(account.getId(), account.getName());
        }

        mav.getModelMap().put("purrequisitionMap", purrequisitionMap);
        mav.getModelMap().put("accountMap", accountMap);
        mav.getModelMap().put("purorderList", purorderDAO.getList());
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    @RequestMapping(value = "/delete-purchase_order.html")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission(#ts_purchaseorder,'delete')")
    public boolean delete_purorder(@RequestParam(value = "id") int id) throws Exception {
        logger.log(Level.FINE, "delete-purchase_order called.");
        Purorder purorder = purorderDAO.getRecordByPrimaryKey(id);
        if (purorder != null) {
            int updateResult = purorderDAO.delete(purorder);
            if (updateResult > 0) {
                logger.log(Level.INFO, "Purorder with id {0} deleted successfully", purorder.getId());
                return true;
            } else {
                logger.log(Level.WARNING, "Error occurred while deleting purorder with id {0}", purorder.getId());
                return false;
            }
        }
        logger.log(Level.INFO, "Purorder with id {0} is already deleted", id);
        return true;
    }

    private List<Accounts> getSupplierList() {
        return accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true and a.type=" + Constants.SUPPLIER);
    }

    private List<Purrequisition> getPurrequisitionList() {
        return purrequisitionDAO.getList();
    }
}