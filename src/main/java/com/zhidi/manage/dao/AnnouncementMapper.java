package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Announcement;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(String announcementid);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(String announcementid);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKeyWithBLOBs(Announcement record);

    int updateByPrimaryKey(Announcement record);
}