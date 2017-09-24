package com.zhidi.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.system.entity.Role;

public interface RoleMapper extends IBaseDao<Role> {
	
	List<Role> queryRoleByUserId(String userId);
    
	List<Role> queryAll();
	
	void removeRelation(String userId);
	
	void addRelation(@Param("userId") String userId, @Param("roleId") String roleId);
}