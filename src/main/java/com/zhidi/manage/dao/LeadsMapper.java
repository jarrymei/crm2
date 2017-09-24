package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Leads;

public interface LeadsMapper {
    int deleteByPrimaryKey(String leadsid);

    int insert(Leads record);

    int insertSelective(Leads record);

    Leads selectByPrimaryKey(String leadsid);

    int updateByPrimaryKeySelective(Leads record);

    int updateByPrimaryKey(Leads record);
}