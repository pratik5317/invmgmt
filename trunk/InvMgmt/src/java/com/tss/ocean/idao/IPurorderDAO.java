package com.tss.ocean.idao;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.Purorder;
import java.util.Date;
import java.util.List;

public interface IPurorderDAO extends GenericDAO<Purorder, Integer> {

    public List<Purorder> getPurOrderList_dateRange(Date fromDate,Date toDate);
}