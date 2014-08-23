package com.tss.ocean.dao;

import com.tss.ocean.idao.IApplyLeavesDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.ApplyLeaves;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhavik.ambani
 */
@Repository("applyLeavesDAO")
public class ApplyLeavesDAO extends GenericDAOImpl<ApplyLeaves, Integer> implements IApplyLeavesDAO {
}
