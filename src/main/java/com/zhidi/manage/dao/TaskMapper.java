package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Task;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskid);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskid);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKeyWithBLOBs(Task record);

    int updateByPrimaryKey(Task record);
}