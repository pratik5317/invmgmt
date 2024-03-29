package com.tss.ocean.controller;

import com.tss.ocean.idao.IAccountsDAO;
import com.tss.ocean.pojo.Accounts;
import com.tss.ocean.util.Utilities;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());
    
    @Autowired
    IAccountsDAO accountsDAO;
    
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value="/add-account.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','add')")
    public ModelAndView add_account_get(@RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error) throws Exception {
        logger.log(Level.FINE,"add-account called.");
        
        ModelAndView mav = new ModelAndView("account");
        Accounts account = new Accounts();
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
	mav.getModelMap().put("account", account);
        return mav;
    }
    
    @RequestMapping(value="/add-account.html",method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','add')")
    public ModelAndView add_account_post(@ModelAttribute("account") @Valid Accounts account,
                                        BindingResult result,
                                        ModelMap model,
                                        @RequestParam(value="imageUpload",required = false) MultipartFile upload, 
                                        Locale locale) throws Exception {
        logger.log(Level.FINE,"add-account-post called.");
        if (!result.hasErrors()) {
            if(upload != null) {
                account.setImage(upload.getBytes());
            }
            account.setVisible(true);
            int insertResult = accountsDAO.insert(account);
            if(insertResult > 0) {
                logger.log(Level.INFO, "Account Added Successfully with id={0}", insertResult);
                return new ModelAndView("redirect:add-account.html")
                    .addObject("success",Utilities.getSpringMessage(messageSource,"account.add.success", locale));
            }
            else {
                logger.log(Level.WARNING, "Error occurred inserting account:{0}", account.toString());
                return new ModelAndView("account",model)                
                    .addObject("error",Utilities.getSpringMessage(messageSource,"account.add.error", locale));
            }
        }
        else {
            logger.log(Level.WARNING, "Account values are not valid:", account.toString());
            return new ModelAndView("account",model);
        }
    }
    
    @RequestMapping(value="/edit-account.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','update')")
    public ModelAndView edit_account_get(@RequestParam(value = "id")int id,
                                    @RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error) throws Exception {
        logger.log(Level.FINE,"edit-account called.");
        ModelAndView mav;
        Accounts account = accountsDAO.getRecordByPrimaryKey(id);
        if(account != null ) {
            mav = new ModelAndView("account");
            mav.getModelMap().put("account", account);
        }
        else {
            mav = new ModelAndView("redirect:account");
        }
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }	
        return mav;
    }
    
    @RequestMapping(value="/edit-account.html",method= RequestMethod.POST)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','update')")
    public ModelAndView edit_account_post(@ModelAttribute("account") @Valid Accounts account,
                                        BindingResult result,
                                        ModelMap model,
                                        @RequestParam(value="imageUpload",required = false) MultipartFile upload, 
                                        Locale locale) throws Exception {
        logger.log(Level.FINE,"edit-account-post called.");
        if (!result.hasErrors()) {
            if(upload != null) {
                account.setImage(upload.getBytes());
            }
            else {
                Accounts oldAccount = accountsDAO.getRecordByPrimaryKey(account.getId());
                account.setImage(oldAccount.getImage());
            }
            int updateResult = accountsDAO.update(account);
            if(updateResult > 0) {
                logger.log(Level.INFO, "Account updated Successfully with id={0}", updateResult);
                return new ModelAndView("redirect:account.html")
                    .addObject("success",Utilities.getSpringMessage(messageSource,"account.update.success", locale));
            }
            else {
                logger.log(Level.WARNING, "Error occurred updating account:{0}", account.toString());
                return new ModelAndView("account",model)                
                    .addObject("error",Utilities.getSpringMessage(messageSource,"account.update.error", locale));
            }
        }
        else {
            logger.log(Level.WARNING, "Account values are not valid:", account.toString());
            return new ModelAndView("account",model);
        }
    }
    
    @RequestMapping(value="/account.html",method= RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','view')")
    public ModelAndView account(@RequestParam(value = "success",required = false)String success,
                                    @RequestParam(value = "error",required = false)String error) throws Exception {
        logger.log(Level.FINE,"add-account called.");
        ModelAndView mav = new ModelAndView("account-list");
        List<Accounts> accountsList = accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true");
        if(success != null) {
            mav.getModelMap().put("success", success);
        }
        if(error != null) {
            mav.getModelMap().put("error", error);
        }
	mav.getModelMap().put("accountList", accountsList);
        return mav;
    }
    
    @RequestMapping(value="/delete-account.html")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','delete')")
    public boolean delete_account(@RequestParam(value = "id")int id) throws Exception {
        logger.log(Level.FINE,"delete-account called.");        
        Accounts account = accountsDAO.getRecordByPrimaryKey(id);
        if(account != null ) {
            account.setVisible(false);
            int updateResult = accountsDAO.update(account);
            if(updateResult > 0) {
                logger.log(Level.INFO,"Account with id {0} deleted successfully",account.getId());
                return true;
            }
            else {
                logger.log(Level.WARNING,"Error occurred while deleting account with id {0}",account.getId());
                return false;
            }
        }
        logger.log(Level.INFO,"Account with id {0} is already deleted",id);
        return true;
    }  
}