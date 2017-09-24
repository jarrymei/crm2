package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}