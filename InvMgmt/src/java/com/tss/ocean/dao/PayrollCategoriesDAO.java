package com.tss.ocean.dao;

import com.tss.ocean.idao.IPayrollCategoriesDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.PayrollCategories;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("payrollCategoriesDAO")
public class PayrollCategoriesDAO extends GenericDAOImpl<PayrollCategories, Integer> implements IPayrollCategoriesDAO {
}