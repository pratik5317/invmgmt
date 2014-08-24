/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techshark.hibernate.base;

//import com.techshark.hibernate.util.HibernateUtil;
import com.techshark.hibernate.ibase.GenericDAO;
import com.techshark.hibernate.util.HibernateUtil;
//import com.tss.sg.jqgrid.JqGridData;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
//import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TSUser
 */
public abstract class GenericDAOImpl<DomainObject extends Serializable, KeyType extends Serializable>
        implements GenericDAO<DomainObject, KeyType> {

    static final Logger LOG = LoggerFactory.getLogger(GenericDAOImpl.class);
    private Class<DomainObject> persistentClass;
    private Session session;
    private SessionFactory sessionFactory;
    private boolean sessionStatus = true;
    private static String MODULE = "GENERICDAOIMPL";
    //private IMSLogger.appLog IMSLogger.appLog = IMSLogger.appLog.getIMSLogger.appLog(this.getClass());

    /**
     * Set persistentClass object with Given Domain Object Class Name
     */
    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.persistentClass = (Class<DomainObject>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<DomainObject> getPersistentClass() {
        return persistentClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        LOG.trace("setted seesion factory....");
    }

    /**
     * Give list of all entities of underlying Domain Object.
     *
     * @return List of all entities.
     */
    @SuppressWarnings("unchecked")
    public List<DomainObject> getList() {
        Session session = getSession();
        try {
            session.flush();
            return session.createQuery("from " + getPersistentClass().getName()).list();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getList() Method:" + e, e);
            throw e;
        }
    }

    /**
     * Returns the total number of Entities that is affected by sql query,
     *
     * @param sql SQL Query
     * @return Number of Entities affected By SQL Query.
     */
    public int getRecordBySQLQuery(String sql) {
        Session session = getSession();
//        Transaction tx = null;
        int rows = 0;
        try {
//            tx = session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(getPersistentClass());
            rows = query.executeUpdate();
//            tx.commit();
        } catch (RuntimeException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            LOG.error(MODULE + "Exception in getRecordBySQLQuery() Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return rows;
    }

    public int getExecuteUpdate(String hql) {
        Session session = getSession();
//        Transaction tx = null;
        int rows = 0;
        try {
//            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            LOG.debug(MODULE + "getExecuteUpdate" + "# Query : " + hql);
            rows = query.executeUpdate();
//            tx.commit();
        } catch (RuntimeException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            LOG.error(MODULE + "Exception in getExecuteUpdate Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return rows;
    }

    /**
     * Returns Domain object whose Key-value pair matched.
     *
     * @param keyName Column name
     * @param keyValue any value that is being matched under Column name.
     * @return DomainObject
     */
    public DomainObject getRecordByKeyandValue(String keyName, Object keyValue) {
        DomainObject returnValue = null;
        Session session = getSession();
        List<DomainObject> lst = null;
        try {
            Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(keyName, keyValue));
            lst = query.list();
            if (lst != null && lst.size() > 0) {
                returnValue = lst.get(0);
            }
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getRecordByKeyandValue Method:" + e, e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return returnValue;
    }

    /**
     * Returns list of Domainobjects whose Key-value pair matched.
     *
     * @param colname Column name
     * @param value
     * @return List<DomainObject> according to the Condition satisfied.
     */
    public List<DomainObject> getListByKeyandValue(String colname, Object value) {
        Session session = getSession();
        List<DomainObject> retList = null;
        try {
            Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(colname, value));
            retList = query.list();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getListByKeyandValue Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return retList;
    }

    /**
     * Returns list of Domainobjects whose Key-value pair matched.
     *
     * @param colname Column name
     * @param keyValue List of values.
     * @return List<DomainObject> according to the Condition satisfied.
     */
    public List<DomainObject> getListByKeyandValue(String colname, List<Object> keyValue) {
        Session session = getSession();
        List<DomainObject> retList = null;
        try {
            Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.in(colname, keyValue));
            retList = query.list();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getListByKeyandValue with List<Values> Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return retList;
    }

    /**
     * Returns the list of Entities according to the condition applied.
     *
     * @param condition Condition
     * @return List<DomainObject> according to condition satisfied.
     */
    public List<DomainObject> getListByCondition(String condition) {
        Session session = getSession();
        List<DomainObject> lst = null;
        try {
            if (condition == null || "null".equals(condition)) {
                condition = " ";
            }
            lst = session.createQuery("from " + getPersistentClass().getName() + " " + condition).list();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getListByCondition Method:" + e, e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return lst;
    }

    /**
     * Find Object based on primary key.
     *
     * @param id Identifier value is passed.
     * @return DomainObject i.e POJO which has the passed id value.
     */
    @SuppressWarnings("unchecked")
    public DomainObject getRecordByPrimaryKey(KeyType id) {
        Session session = getSession();
        try {
            return (DomainObject) session.get(getPersistentClass(), id);
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getRecordByPrimaryKey Method:" + e, e);
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * get the list of primary keys based on the condition.
     *
     * @param condition Condition
     * @return List<KeyType> of Primary Keys according to the Condition.
     */
    public List<KeyType> getPrimaryKeyCollection(String condition) {
        Session session = getSession();
        List<KeyType> lst = null;
        try {
            if (condition == null || "null".equals(condition)) {
                condition = " ";
            }
            ClassMetadata cm = sessionFactory.getClassMetadata(getPersistentClass().getName());
            String type = cm.getIdentifierPropertyName();
            lst = session.createQuery("select t." + type + " from " + getPersistentClass().getName() + " t" + " " + condition).list();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getPrimaryKeyCollection Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    /**
     * Insert the Domain Object that is going to persist into the Database.
     *
     * @param object Domain Object which is going to persist into the Database
     * @return KeyType Serializable value generated By Hibernate due to
     * session.save().
     */
    public KeyType insert(DomainObject object) {
        Session session = getSession();
        KeyType serialid;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            serialid = (KeyType) session.save(object);
            tx.commit();
        } catch (RuntimeException e) {
            LOG.error(MODULE + "Exception in insert Method:" + e, e);
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return serialid;
    }

    /**
     * Update the Domain Object.
     *
     * @param object Domain Object that is being changed/updated.
     * @return 1 if Domain Object is being successfully updated 0 if Exception
     * Generation while updating the Object.
     */
    public int update(DomainObject object) {
        int updateValue = -1;
        Session session = getSession();
        Transaction tx = null;
        try {
            if (object == null) {
                LOG.debug(MODULE + " Null object could not update....RETURNING");
                return updateValue;
            }
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
            updateValue = 1;
        } catch (RuntimeException e) {
            updateValue = -1;
            LOG.error(MODULE + "Exception in update Method." + e, e);
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return updateValue;
    }

    /**
     * Deleting Domain Object.
     *
     * @param object Domain Object that is going to be delete.
     */
    public int delete(DomainObject object) {
        Session session = getSession();
        int deletestatus = -1;
        Transaction tx = null;
        try {
            if (object == null) {
                LOG.debug(MODULE + " Null object could not delete....RETURNING");
                return deletestatus;
            }
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
            deletestatus = 1;
            System.out.println("record deleted");
        }catch(StaleStateException e){
            deletestatus = -1;
            LOG.error(MODULE + "Exception in delete Method." + e, e);
            if (tx != null) {
                tx.rollback();
            }
        } catch (RuntimeException e) {
            deletestatus = -1;
            LOG.error(MODULE + "Exception in delete Method." + e, e);
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return deletestatus;
    }

    /**
     * Delete Object whose oid(Object Identifier) matched with given Primary
     * Key.
     *
     * @param id Identifier value.
     */
    public void deleteById(KeyType id) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(session.get(getPersistentClass(), id));
            tx.commit();
        } catch (RuntimeException e) {
            LOG.error(MODULE + "Exception in deletion through id." + e, e);
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Count the total number of Entities.
     *
     * @return integer value that specifies the Total number of Entities.
     */
    public int count() {
        Session session = getSession();
        Long count = new Long(0);
        try {
            count = (Long) session.createQuery("select count(t) from " + getPersistentClass().getName() + " t ").uniqueResult();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in count Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return count.intValue();
    }

    /**
     * Count the total Entities based on Condition.
     *
     * @param condition Condition
     * @return integer value that specifies the Total number of Entities based
     * on the condtion.
     */
    public int count(String condition) {
        Session session = getSession();
        Long count = null;
        try {
            if (condition == null || "null".equals(condition)) {
                condition = " ";
            }
            count = (Long) session.createQuery("select count(t) from " + getPersistentClass().getName() + " t " + condition).uniqueResult();
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in count Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return count.intValue();
    }

    /*
     * public int count(String condition){
     Session session=getSession();
     Long count = null;
     try{
     count = (Long)session.createQuery("select count(1) from "+getPersistentClass().getName()+" "+condition).list().get(0);
     }catch (HibernateException e) {
     LOG.error("Exception in count Method:"+e,e);
     }finally{
     session.close();
     }
     return count.intValue();
     }
     */
    /**
     *
     */
    public List getListBySQLQuery(String sql) {
        Session session = getSession();
        List lst = null;
        try {
            if (sql != null) {
                lst = session.createSQLQuery(sql).list();
            }
        } catch (RuntimeException e) {
            lst = null;
            LOG.error(MODULE + "Exception in getRecordBySQLQuery Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    /**
     *
     * @param hql Query
     * @return - returns list of objects either in List<Primitive type> or
     * List<Object[]>
     */
    public List getListByHQLQuery(String hql) {
        Session session = getSession();
        List lst = null;
        try {
            lst = session.createQuery(hql).list();
        } catch (RuntimeException e) {
            lst = null;
            LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    /**
     * @param form Query. Method called only if String in From HQL Query Format
     * Ex. (From Tblname Query)
     */
    public List getListByFromClause(String hql) {
        return getListByHQLQuery(hql);
    }

    /**
     *
     */
    public List<DomainObject> getListByPage(String columnName, String sortOrder, int limit, int offset) {
        Session session = getSession();
        List<DomainObject> lst = null;
        try {
            String query = " from " + getPersistentClass().getName() + " order by " + columnName + " " + sortOrder;
            lst = session.createQuery(query).setMaxResults(limit).setFirstResult(offset).list();
        } catch (RuntimeException e) {
            lst = null;
            LOG.error(MODULE + "Exception in getListByFromClause Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    /**
     * @param query: hql query
     * @param limit: maximum number of records
     * @param offset: starting limit Method for Pagination - Limit offset ..
     */
    public List getListByPage(String query, int limit, int offset) {
        Session session = getSession();
        List lst = null;
        try {
            lst = session.createQuery(query).
                    setMaxResults(limit).
                    setFirstResult(offset).
                    list();
        } catch (RuntimeException e) {
            lst = null;
            LOG.error(MODULE + "Exception in getListByFromClause Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    @Override
    public String getJsonPageData(final int pageNo, final int offset,
            final String sortColumn, final String sortOrder) {
        LOG.debug(MODULE + "Reached here for getting json response.");

//        int pageNo = (beginIndex / offset) + 1;
        int beginIndex=(pageNo-1)*offset;
        int totalRecods = count();
        int totalPages = (totalRecods / offset);
        LOG.debug(MODULE + "pageNo:" + pageNo + ":" + totalRecods + ":" + totalPages + ":" + (totalRecods % offset));

        if (totalPages == 0) {
            totalPages = 1;
        } else {
            totalPages = (totalRecods / offset) + ((totalRecods % offset) != 0 ? 1 : 0);
        }

        LOG.debug(MODULE + "OFFSET : " + offset);
        LOG.debug(MODULE + "TOTAL RECORDS : " + totalRecods);
        LOG.debug(MODULE + "TOTAL PAGES : " + totalPages);
        LOG.debug(MODULE + "CURRENT PAGE : " + pageNo);

        List<DomainObject> listByPage = getListByPage(sortColumn, sortOrder, offset, beginIndex);
        int totalSize = (listByPage != null ? listByPage.size() : 0);

        LOG.debug(MODULE + "TOTAL RECORDS : " + ((offset > totalSize) ? totalSize : offset));

        //Parse the Response String
//        final String parse = new JqGridData(totalPages, pageNo, totalRecods, listByPage).getJsonString();
        String parse="";
        return parse;
    }

    @Override
    public String getJson(int pageNo, int offset, String sortColumn, String sortOrder,List<DomainObject> list) {
        LOG.debug(MODULE + "Reached here for getting json response.");

//        int pageNo = (beginIndex / offset) + 1;
        int beginIndex=(pageNo-1)*offset;
        int totalRecods = count();
        int totalPages = (totalRecods / offset);
        LOG.debug(MODULE + "pageNo:" + pageNo + ":" + totalRecods + ":" + totalPages + ":" + (totalRecods % offset));

        if (totalPages == 0) {
            totalPages = 1;
        } else {
            totalPages = (totalRecods / offset) + ((totalRecods % offset) != 0 ? 1 : 0);
        }

        LOG.debug(MODULE + "OFFSET : " + offset);
        LOG.debug(MODULE + "TOTAL RECORDS : " + totalRecods);
        LOG.debug(MODULE + "TOTAL PAGES : " + totalPages);
        LOG.debug(MODULE + "CURRENT PAGE : " + pageNo);

        
        int totalSize = (list != null ? list.size() : 0);

        LOG.debug(MODULE + "TOTAL RECORDS : " + ((offset > totalSize) ? totalSize : offset));

        //Parse the Response String
        //final String parse = new JqGridData(totalPages, pageNo, totalRecods, list).getJsonString();
        String parse="";
        return parse;
    }

    /**
     *
     * @param hql Query
     * @return - returns list of objects either in List<Primitive type> or
     * List<Object[]>
     */
    public List getListByHQLQuery(String hql,int totalrows,int firstrow) {
        Session session = getSession();
        List lst = null;
        try {
            lst = session.createQuery(hql).setMaxResults(totalrows).setFirstResult(firstrow).list();
        } catch (RuntimeException e) {
            lst = null;
            LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return lst;
    }

    public String[] getQueryAlias(String hql){
        Session session = getSession();
        String[] retalias = null;
        try {
            retalias = session.createQuery(hql).getReturnAliases();
        } catch (RuntimeException e) {
            retalias = null;
            LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
        } finally {
//            if (session.isOpen()) {
//                session.close();
//            }
        }
        return retalias;
    }
    /**
     * Session can be set from parameter. Normal practice should be create
     * Session using this method
     *
     * @param session
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Verify for session. if Session is null then it will create new Session.
     *
     * @return Session : Current Session
     */
    protected Session getSession() {
        if (session == null || !session.isOpen()) {
            LOG.debug("Session is null or not open...");
            return HibernateUtil.getCurrentSession();
        }
        LOG.debug("Session is current...");
        return session;
    }

    /**
     * Returns Domain object whose Key-value pair matched.
     *
     * @param keyName Column name
     * @param keyValue any value that is being matched under Column name.
     * @return DomainObject
     */
    public List getRecordListByKeyandValue(String keyName, Object keyValue) {
        DomainObject returnValue = null;
        Session session = getSession();
        List<DomainObject> lst = null;
        try {
            Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(keyName, keyValue));
            lst = query.list();
            if (lst != null && lst.size() > 0) {
               return lst;
            }
        } catch (HibernateException e) {
            LOG.error(MODULE + "Exception in getRecordByKeyandValue Method:" + e, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lst;
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
}