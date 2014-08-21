/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techshark.hibernate.base;

import com.techshark.hibernate.ibase.DAOFactory;
import com.tss.ocean.dao.EmployeesDAO;
import com.tss.ocean.idao.IEmployeesDAO;

/**
 *
 * @author TSUser
 */
public class HibernateDAOFactory extends DAOFactory {

//	
//	//@Override
//	public SmsGatewayDAO getSmsGatewayDAO() {
//		// TODO Auto-generated method stub
//		return (SmsGatewayDAO)instantiateDAO(SmsGatewayDAOHibernate.class);
//	}
//		/**
//	 * Use to instantiateDAO object, which is subclass of GenericDAOImpl
//	 * @param daoClass 
//	 * @return
//	 */
    private GenericDAOImpl instantiateDAO(Class daoClass) {
        try {
            GenericDAOImpl dao = (GenericDAOImpl) daoClass.newInstance();

            /*
             * Set Current Session from HibernateUtil for each instance.
             */
            //dao.setSession(HibernateUtil.getCurrentSession());
            return dao;

        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);

        }
    }
//
//    //@Override
//    public IStudentDAO getStudentDAO() {
//        // TODO Auto-generated method stub
//
//        return (IStudentDAO) instantiateDAO(StudentDAO.class);
//    }
//

    @Override
    public IEmployeesDAO getEmployeesDAO() {
        return (IEmployeesDAO) instantiateDAO(EmployeesDAO.class);
    }


    
}
