/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techshark.hibernate.ibase;

import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeesDAO;

/**
 *
 * @author TSUser
 */
public abstract class DAOFactory {

    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO beans for use
     * in any environment Hibernate has been configured for.
     */
    public static final Class HIBERNATE = com.techshark.hibernate.base.HibernateDAOFactory.class;
    public static final DAOFactory instance = new com.techshark.hibernate.base.HibernateDAOFactory();

    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return instance;
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory + ":" + ex);
        }
    }

    //public abstract  IStudentDAO getStudentDAO();
    public abstract IEmployeesDAO getEmployeesDAO();

    public abstract IEmployeeCategoryDAO getEmployeeCategoryDAO();

}
