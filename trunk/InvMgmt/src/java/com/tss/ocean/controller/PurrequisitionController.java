package com.tss.ocean.controller;

import com.tss.ocean.idao.IAccountsDAO;
import com.tss.ocean.idao.IItemDAO;
import com.tss.ocean.idao.IPurrequisitionDAO;
import com.tss.ocean.pojo.Accounts;
import com.tss.ocean.pojo.Purrequisition;
import com.tss.ocean.util.Constants;
import com.tss.ocean.util.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PurrequisitionController {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());
    
    @Autowired
    private IPurrequisitionDAO purrequisitionDAO;
    
    @Autowired
    private IAccountsDAO accountsDAO;
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private IItemDAO itemDAO;
    
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {   
        binder.registerCustomEditor(Set.class, new CustomCollectionEditor(Set.class) {
            @Override
            protected Object convertElement(Object element) {
              String itemId = (String) element;
              return itemDAO.getRecordByPrimaryKey(Integer.valueOf(itemId));
            }
        });
    }
    
    @RequestMapping(value="/add-purchase_requisition.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','add')")
    public ModelAndView add_purrequisition_get(@RequestParam(value = "success",required = false)String success,
                                                @RequestParam(value = "error",required = false)String error,
                                                Locale locale) throws Exception {
        logger.log(Level.FINE,"add-purchase_requisition called.");
        ModelAndView mav = new ModelAndView("purchase_requisition");
        Purrequisition purrequisition = new Purrequisition();
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
        mav.getModelMap().put("supplierList",getSupplierList());
        mav.getModelMap().put("statusList",getStatusList(locale));
	mav.getModelMap().put("purrequisition", purrequisition);
        mav.getModelMap().put("itemList",itemDAO.getList());        
        return mav;
    }
    
    @RequestMapping(value="/add-purchase_requisition.html",method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','add')")
    public ModelAndView add_purrequisition_post(@ModelAttribute("purrequisition") @Valid Purrequisition purrequisition,
                                        BindingResult result,
                                        ModelMap model,
                                        Locale locale) throws Exception {
        logger.log(Level.FINE,"add-purchase_requisition-post called.");        
        if (!result.hasErrors()) {
            purrequisition.setCreatedby(1);
            purrequisition.setPrno(Utilities.getRandomString(10));
            int insertResult = purrequisitionDAO.insert(purrequisition);
            if(insertResult > 0) {
                logger.log(Level.INFO, "Purrequisition Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add-purchase_requisition.html")
                    .addObject("success",Utilities.getSpringMessage(messageSource,"purrequisition.add.success",locale));
            }
            else {
                logger.log(Level.WARNING, "Error occurred inserting purrequisition:{0}", purrequisition.toString());
                model.put("supplierList",getSupplierList());
                model.put("itemList",itemDAO.getList());
                model.put("statusList",getStatusList(locale));
                return new ModelAndView("purchase_requisition",model)
                    .addObject("error",Utilities.getSpringMessage(messageSource,"purrequisition.add.error", locale));
            }
        }
        else {
            logger.log(Level.WARNING, "Purchase_requisition values are not valid:", purrequisition.toString());
            model.put("supplierList",getSupplierList());
            model.put("itemList",itemDAO.getList());
            model.put("statusList",getStatusList(locale));
            return new ModelAndView("purchase_requisition",model);
        }
    }
    
    @RequestMapping(value="/edit-purchase_requisition.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','update')")
    public ModelAndView edit_purrequisition_get(@RequestParam(value = "id")int id,
                                    Locale locale,
                                    @RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error) throws Exception {
        logger.log(Level.FINE,"edit-purchase_requisition called.");
        ModelAndView mav;
        Purrequisition purrequisition = purrequisitionDAO.getRecordByPrimaryKey(id);
        if(purrequisition != null ) {
            mav = new ModelAndView("purchase_requisition");            
            mav.getModelMap().put("purrequisition", purrequisition);
            mav.getModelMap().put("supplierList",getSupplierList());
            mav.getModelMap().put("itemList",itemDAO.getList());
            mav.getModelMap().put("statusList",getStatusList(locale));
        }
        else {
            mav = new ModelAndView("redirect:purchase_requisition.html");
        }
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }	
        return mav;
    }
    
    @RequestMapping(value="/edit-purchase_requisition.html",method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','update')")
    public ModelAndView edit_purrequisition_post(@ModelAttribute("purrequisition") @Valid Purrequisition purrequisition,
                                        BindingResult result,
                                        ModelMap model,                                        
                                        Locale locale) throws Exception {
        logger.log(Level.FINE,"edit-purchase_requisition-post called.");
        if (!result.hasErrors()) {
            int updateResult = purrequisitionDAO.update(purrequisition);
            if(updateResult > 0) {
                logger.log(Level.INFO, "purchase_requisition updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:purchase_requisition.html")
                    .addObject("success",Utilities.getSpringMessage(messageSource,"purrequisition.update.success", locale));
            }
            else {
                logger.log(Level.WARNING, "Error occurred updating purchase_requisition:{0}", purrequisition.toString());
                model.put("supplierList",getSupplierList());
                model.put("itemList",itemDAO.getList());
                model.put("statusList",getStatusList(locale));
                return new ModelAndView("purchase_requisition",model)
                    .addObject("error",Utilities.getSpringMessage(messageSource,"purrequisition.update.error", locale));
            }
        }
        else {
            logger.log(Level.WARNING, "Purchase_requisition values are not valid:", purrequisition.toString());
            model.put("supplierList",getSupplierList());
            model.put("itemList",itemDAO.getList());
            model.put("statusList",getStatusList(locale));
            return new ModelAndView("purchase_requisition",model);
        }
    }
    
    @RequestMapping(value="/purchase_requisition.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','view')")
    public ModelAndView purrequisition(@RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error,
                                    Locale locale) throws Exception {
        logger.log(Level.FINE,"purchase_requisition called.");
        ModelAndView mav = new ModelAndView("purchase_requisition-list");
        List<Accounts> accountsList = accountsDAO.getList();
        HashMap<Integer,String> accountMap = new HashMap<>(accountsList.size());
        for (Accounts account : accountsList) {
            accountMap.put(account.getId(), account.getName());            
        }
        mav.getModelMap().put("purrequisitionList", purrequisitionDAO.getList());
        mav.getModelMap().put("accountMap", accountMap);
        mav.getModelMap().put("statusList",getStatusList(locale));
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }
    
    @RequestMapping(value="/delete-purchase_requisition.html")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('purchaserequisition','delete')")
    public boolean delete_purrequisition(@RequestParam(value = "id")int id) throws Exception {
        logger.log(Level.FINE,"delete-purchase_requisition called.");        
        Purrequisition purrequisition = purrequisitionDAO.getRecordByPrimaryKey(id);
        if(purrequisition != null ) {
            int updateResult = purrequisitionDAO.delete(purrequisition);
            if(updateResult > 0) {
                logger.log(Level.INFO,"Purrequisition with id {0} deleted successfully",purrequisition.getId());
                return true;
            }
            else {
                logger.log(Level.WARNING,"Error occurred while deleting purrequisition with id {0}",purrequisition.getId());
                return false;
            }
        }
        logger.log(Level.INFO,"Purrequisition with id {0} is already deleted",id);
        return true;
    }
    
    private List<Accounts> getSupplierList() {
        return accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true and a.type="+Constants.SUPPLIER);        
    }
    
    private Map<Integer,String> getStatusList(Locale local) {
        Map<Integer,String> statusList = new HashMap();        
        statusList.put(Constants.CREATED, Utilities.getSpringMessage(messageSource,"label.purrequisition.status.created", local));
        statusList.put(Constants.SUSPENDED, Utilities.getSpringMessage(messageSource,"label.purrequisition.status.suspended", local));
        statusList.put(Constants.PLACED, Utilities.getSpringMessage(messageSource,"label.purrequisition.status.placed", local));
        return statusList;        
    }
}