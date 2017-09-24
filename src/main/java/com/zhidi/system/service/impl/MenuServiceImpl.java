package com.zhidi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.vo.MenuVO;
import com.zhidi.system.service.IFunctionService;
import com.zhidi.system.service.IMenuService;
import com.zhidi.system.service.IRoleService;
import com.zhidi.system.service.IUserService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IFunctionService functionService;
	

	@Override
	public List<MenuVO> queryByUserId(String userId) {
		//查询用户对应的角色信息
		List<Role> roles = roleService.queryRoleByUserId(userId);
		if (roles == null && roles.size() == 0) {
			return null;
		}
		String[] roleIds = new String[roles.size()];
		for (int i = 0; i < roles.size(); i++) {
			roleIds[i] = roles.get(i).getId();
		}
		
		//根据角色id查询对应角色
		List<Function> funcs = functionService.queryFuncByRoleIds(roleIds);
		
		List<MenuVO> menuVOs = new ArrayList<MenuVO>();
		//将菜单封装到vo中
		for (Function func : funcs) {
			MenuVO menuVO = new MenuVO();
			menuVO.setId(func.getId());
			menuVO.setName(func.getFuncname());
			menuVO.setOpen(true);
			if (func.getParentid() == null) {
				menuVO.setpId("");
				menuVO.setUrl("");
			} else {
				menuVO.setpId(func.getParentid());
				menuVO.setUrl(func.getFuncurl());
			}
			menuVOs.add(menuVO);
		}
		return menuVOs;
	}

}
