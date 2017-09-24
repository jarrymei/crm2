package com.zhidi.base.service;

import com.zhidi.system.entity.User;

public interface IBaseService<T> {

	int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(User record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
