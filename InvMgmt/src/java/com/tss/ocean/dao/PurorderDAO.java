package com.tss.ocean.dao;

import com.tss.ocean.idao.IPurorderDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Purorder;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("purorderDAO")
public class PurorderDAO extends GenericDAOImpl<Purorder, Integer> implements IPurorderDAO {

    static final Logger LOG = LoggerFactory.getLogger(GenericDAOImpl.class);

    @Override
    public List<Purorder> getPurOrderList_dateRange(Date fromDate, Date toDate) {
        Session session = getSession();
        List<Purorder> lst = null;
        try {
            lst = session.createQuery("from Purorder p where p.createdat >= :fromDate and p.createdat < :toDate").setParameter("fromDate", fromDate).setParameter("toDate", toDate).list();
            System.out.println("List Size ********************** "+lst.size());
        } catch (HibernateException e) {
            lst = null;
            LOG.error(" [PurorderDAO] Exception in getPurOrderList_dateRange Method:" + e, e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return lst;
    }
}
