package com.tss.ocean.dao;

import com.tss.ocean.idao.IPurrequisitiondtDAO;
import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.pojo.Purrequisitiondt;
import org.springframework.stereotype.Repository;

@Repository("purrequisitiondtDAO")
public class PurrequisitiondtDAO extends GenericDAOImpl<Purrequisitiondt, Integer> implements IPurrequisitiondtDAO{

}