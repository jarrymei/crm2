package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Contacts;

public interface ContactsMapper {
    int deleteByPrimaryKey(String contactsid);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(String contactsid);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);
}