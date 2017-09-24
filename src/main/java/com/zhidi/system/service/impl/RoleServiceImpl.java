package com.zhidi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.RoleMapper;
import com.zhidi.system.entity.Role;
import com.zhidi.system.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		super.setBaseDao(roleMapper);
	}

	@Override
	public List<Role> queryRoleByUserId(String userId) {
		return roleMapper.queryRoleByUserId(userId);
	}

	@Override
	public List<Role> queryAll() {
		return roleMapper.queryAll();
	}

	@Override
	public void removeRelation(String userId) {
		roleMapper.removeRelation(userId);
	}

	@Override
	public void addRelation(String userId, String[] roleIds) {
		if (roleIds != null && roleIds.length > 0) {
			for (String roleId : roleIds) {
				roleMapper.addRelation(userId, roleId);
			}
		}
	}
}
