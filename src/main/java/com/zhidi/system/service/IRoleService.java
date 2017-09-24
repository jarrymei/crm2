package com.zhidi.system.service;

import java.util.List;

import com.zhidi.base.service.IBaseService;
import com.zhidi.system.entity.Role;

public interface IRoleService extends IBaseService<Role> {
	
	List<Role> queryRoleByUserId(String userId);
	
	List<Role> queryAll();
	
	/**
	 * 根据用户id移除依赖关系
	 * @param userId
	 */
	void removeRelation(String userId);
	
	/**
	 * 根据用户id和角色id建立依赖关系
	 * @param userId
	 * @param roleId
	 */
	void addRelation(String userId, String[] roleIds);

}
