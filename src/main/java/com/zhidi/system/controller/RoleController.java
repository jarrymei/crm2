package com.zhidi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhidi.common.ResultData;
import com.zhidi.system.entity.Role;
import com.zhidi.system.service.IRoleService;

@RestController
@RequestMapping("/system/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	// 加载所有角色
	@PostMapping("/getRoleList")
	public ResultData getRoleList() {
		List<Role> list = roleService.queryAll();
		return ResultData.buildSuccessResult("请求数据成功", list);
	}

	// 获取用户相应角色
	@GetMapping("/{id}/role")
	public ResultData userRoleList(@PathVariable("id") String id) {
		List<Role> list = roleService.queryRoleByUserId(id);
		return ResultData.buildSuccessResult("请求数据成功", list);
	}
	
	@PostMapping("/assignRole")
	public ResultData assignRole(@RequestParam("id") String userId, String[] roleIds) {
		//解除依赖关系
		roleService.removeRelation(userId);
		//从新建立关系
		roleService.addRelation(userId, roleIds);
		
		return ResultData.buildSuccessResult();
	}
}
