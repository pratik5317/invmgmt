/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tss.ocean.controller;

import com.tss.ocean.dto.EntityWiseACLDetailDTO;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.pojo.ACL;
import com.tss.ocean.pojo.ACLEntity;
import com.tss.ocean.pojo.EmployeeCategory;
import com.tss.ocean.util.Constants;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bhavik
 */
@Controller
public class ACLController {

    private static final Logger logger = LoggerFactory.getLogger(ACLController.class);
    @Autowired
    IEmployeeCategoryDAO employeeCategoryDAO;

    @Autowired
    IACLEntityDAO aclEntityDAO;

    @Autowired
    IACLDAO aclDAO;

    @RequestMapping(value = "/updateACL.html", method = RequestMethod.POST)
    public ModelAndView updateControlParent(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            Locale locale, HttpServletRequest req) throws Exception {
        logger.info("Updating ACL.");
        ModelAndView mav = new ModelAndView("redirect:/access_control.html");
        updateACL(req);

        return mav;
    }

    @RequestMapping(value = "/access_control.html", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView accessControlParent(@RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            Locale locale) throws Exception {
        logger.info("access_control called.");
        ModelAndView mav = new ModelAndView("access_control");
        List<EmployeeCategory> employeeCategoryList = employeeCategoryDAO.getList();
        logger.info("access_control called." + employeeCategoryDAO.getList());
        mav.getModelMap().put("employeeCategoryList", employeeCategoryList);

        if (categoryId != null) {
            logger.info("Processing for category " + categoryId);
            List<ACL> aclEntityList = aclDAO.getList();

            List<Object[]> listByHQLQuery = aclEntityDAO.getListByHQLQuery("select aclEntity.Id,acl.aclModule,aclEntity.aclId,aclEntity.permissionLevel from ACL acl, ACLEntity aclEntity where acl.aclId = aclEntity.aclId and aclEntity.entityType = " + Constants.SECURITY_USER_TYPE_BASED + " and aclEntity.entityId = " + categoryId);
            List<EntityWiseACLDetailDTO> entityWiseACLDetails = new ArrayList<EntityWiseACLDetailDTO>();
            if (listByHQLQuery != null) {
                for (Object[] values : listByHQLQuery) {
                    EntityWiseACLDetailDTO aCLDetailDTO = new EntityWiseACLDetailDTO();
                    aCLDetailDTO.setAclEntityId(((Number) values[0]).intValue());
                    aCLDetailDTO.setAclModule((String) values[1]);
                    aCLDetailDTO.setAclId((String) values[2]);
                    aCLDetailDTO.setPermissionLevel((Integer) values[3]);
                    entityWiseACLDetails.add(aCLDetailDTO);
                }
            }

            logger.info("access_control called." + entityWiseACLDetails);
            mav.getModelMap().put("entityWiseACLDetails", entityWiseACLDetails);
//            mav.getModelMap().put("entityWiseACLList", entityWiseACLList);
            mav.getModelMap().put("categoryId", categoryId);
        } else {
            mav.getModelMap().put("categoryId", -1);
        }
        if (success != null) {
            mav.getModelMap().put("success", success);
        }
        if (error != null) {
            mav.getModelMap().put("error", error);
        }
        return mav;
    }

    public void updateACL(HttpServletRequest req) {
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            ACLEntity aCLEntity = aclEntityDAO.getRecordByPrimaryKey(Integer.valueOf(paramName));
            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                aCLEntity.setPermissionLevel(Integer.valueOf(paramValue));
            }
            aclEntityDAO.update(aCLEntity);
        }
        return ;
    }
}
