package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Contract;

public interface ContractMapper {
    int deleteByPrimaryKey(String contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKeyWithBLOBs(Contract record);

    int updateByPrimaryKey(Contract record);
}