package com.techshark.hibernate.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class gurrenty that only one single SessionFactory is instantiated and
 * that the configuration is done thread safe as singleton.
 *
 * Generated Sep 1, 2011 02:10:00 PM
 *
 */
public class HibernateUtil {

    static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;
    private static final String MODULE = "[HibernateUtil]";

    /**
     * disable constructor to guaranty a single instance
     */
    private HibernateUtil() {
    }

    /**
     * create one time session Factory from static block.
     */
    public synchronized static SessionFactory createSessionFactory() {

        if (sessionFactory == null) {
            LOG.debug(MODULE + "in createSessionFactory");
            sessionFactory = new Configuration().configure().buildSessionFactory();
//                        ApplicationContext appcontext = ApplicationContextProvider.getApplicationContext();
//                        sessionFactory = (SessionFactory) appcontext.getBean("sessionFactory");
            LOG.debug(MODULE + "sessionFactory created");
        }

        return sessionFactory;
    }

    public static SessionFactory getInstance() {
        return createSessionFactory();
    }

    public static Session openSession() {

        if (sessionFactory == null) {
            createSessionFactory();
        }

//		String statistics_status=PropertyReader.getProperty("hibernate_statistics");
//		if(statistics_status.equals("true")){
//			Statistics stats =sessionFactory.getStatistics();
//			stats.setStatisticsEnabled(true);
//			for(String s:stats.getSecondLevelCacheRegionNames()){
//				LOG.debug("Domain Pojo :"+s+": with statistics:"+stats.getSecondLevelCacheStatistics(s));
//				//IMSLogger.hibernatestatusLog.debug("Domain Pojo Tblmerchant with statistics:"+stats.getSecondLevelCacheStatistics("cyberoam.corporate.paymentgateway.entity.Tblmerchant"));
//			}
//			LOG.debug("*******************************************************");
//			//IMSLogger.hibernatestatusLog.debug("SessionImpl:"+stats);
//		}

        return sessionFactory.openSession();
    }

    /**
     * Returns a session from the session context. If there is no session in	the
     * context it opens a session, stores it in the context and returns it. This
     * factory is intended to be used with a hibernate.cfg.xml including the
     * following property <property
     * name="current_session_context_class">thread</property> This would	return
     * the current open session or if this does not exist, will create a new
     * session
     *
     * @return the session
     */
    public static Session getCurrentSession() {
        //LOG.debug(MODULE + "Get CurrentSession");

        /* This code is to find who has called the method only for debugging and testing purpose.
         try {
         throw new Exception("Who called Me : ");
         } catch (Exception e) {
         //LOG.debug("I was called by " + e.getStackTrace()[2].getClassName() + "." + e.getStackTrace()[2].getMethodName() + "()!");
         LOG.debug("I was called by : ", e);
         }
         */
        return openSession();
        //return sessionFactory.getCurrentSession();
    }

    /**
     * closes the session factory
     */
    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        LOG.debug(MODULE + "SessionFactory Close");
        sessionFactory = null;
    }

    public List find(final String hqlQuery) throws Exception {

        List results = new ArrayList();
        //
        // Prepare a Hibernate query
        //
        Query query = getCurrentSession().createQuery(hqlQuery);
        //
        // Determine the return type for this query
        //
        Type beanType = query.getReturnTypes()[0];
        Class beanClass = beanType.getReturnedClass();
        //
        // Extract the list of columns returned by this query
        //
//        String[] columns = extractColumns(hqlQuery);
//        //
//        // Pre-process bean attribute names, stripping spaces 'as' clauses
//        //
//        String[] attributeNames = getAttributeFieldNames(columns);
//        //
//        // Pre-process result field names, stripping spaces and retaining
//        // alias field names instead of the original column names where necessary
//        //
//        String[] resultFieldNames = getResultFieldNames(columns);
        //
        // Execute query and build result list
        //
        Iterator iter = query.iterate();
        while (iter.hasNext()) {
            Object[] row = (Object[]) iter.next();
            Object bean = beanClass.newInstance();
            for (int j = 0; j < row.length; j++) {
                if (row[j] != null) {
//                    initialisePath(bean, attributeNames[j]);
//                    PropertyUtils.setProperty(bean, attributeNames[j], row[j]);
                }
            }
            results.add(bean);
        }
        return results;
    }

    private static void initialisePath(final Object bean,
            final String fieldName)
            throws Exception {
        int dot = fieldName.indexOf('.');
        while (dot >= 0) {
            String attributeName = fieldName.substring(0, dot);
//            Class attributeClass = PropertyUtils.getPropertyType(bean, attributeName);
//            if (PropertyUtils.getProperty(bean, attributeName) == null) {
//                PropertyUtils.setProperty(bean, attributeName, attributeClass.newInstance());
//            }
            dot = fieldName.indexOf('.', dot + 1);
        }
    }
}
