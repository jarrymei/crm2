package com.zhidi.manage.dao;

import com.zhidi.manage.entity.BusinessStatus;

public interface BusinessStatusMapper {
    int deleteByPrimaryKey(String statusid);

    int insert(BusinessStatus record);

    int insertSelective(BusinessStatus record);

    BusinessStatus selectByPrimaryKey(String statusid);

    int updateByPrimaryKeySelective(BusinessStatus record);

    int updateByPrimaryKey(BusinessStatus record);
}