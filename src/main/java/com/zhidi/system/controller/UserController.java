package com.zhidi.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zhidi.system.entity.vo.MenuVO;
import com.zhidi.system.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zhidi.common.Pager;
import com.zhidi.common.ResultData;
import com.zhidi.system.dao.RoleMapper;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.IRoleService;
import com.zhidi.system.service.IUserService;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/system/user")
public class UserController {
	
	@Autowired
	private IUserService userSerivce;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/login")
	public ResultData login(HttpSession session, HttpServletRequest request, String username, String password) {
		
		if (StringUtils.isEmpty(username)) {
			return ResultData.buildFailureResult("请输入用户名");
		}
		if (StringUtils.isBlank(password)) {
			return ResultData.buildFailureResult("请输入密码");
		}
		User user = userSerivce.queryByUserName(username);
		if (user == null) {
			return ResultData.buildFailureResult("用户不存在");
		}
		if (!password.equals(user.getPassword())) {
			return ResultData.buildFailureResult("密码不正确");
		}
		
		session.setAttribute("user", user);

		//将用户对应权限放入Session中
		List<MenuVO> menuVos = menuService.queryByUserId(user.getId());
		List<String> userUrls = new ArrayList<String>();
		for (MenuVO vo : menuVos) {
			userUrls.add(request.getContextPath() + "/" +vo.getUrl());
		}
		session.setAttribute("userUrls", userUrls);

		return ResultData.buildSuccessResult("登录成功");
	}
	
	@RequestMapping("/logout")
	public ResultData logout(HttpSession session) {
		session.invalidate();
		return ResultData.buildSuccessResult();
	}
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("system/list_user");
		return mv;
	}
	
	@PostMapping("/findByPage")
	public ResultData findByPage(Integer page, Integer rows) {
		Pager pager = userSerivce.queryByPage(page, rows);
		return ResultData.buildSuccessResult("数据请求成功", pager);
	}
	
	@GetMapping("/edit")
	public ModelAndView add(ModelAndView mv, String id) {
		if (StringUtils.isNotBlank(id)) {
			User user = userSerivce.selectByPrimaryKey(id);
			mv.addObject("user", user);
		}
		mv.setViewName("system/edit_user");
		return mv;
	}
	
	@PostMapping("/saveOrUpdate")
	public ResultData saveOrUpdate(HttpSession session, User user) {
		User sessionUser = (User) session.getAttribute("user");
		if (StringUtils.isEmpty(user.getId())) {
			//如果id为null为新增
			user.setCreateby(sessionUser.getId());
			user.setCreatetime(new Date());
			userSerivce.insert(user);
		} else {
			User target = userSerivce.selectByPrimaryKey(user.getId());
			BeanUtils.copyProperties(user, target);
			target.setUpdateby(sessionUser.getId());
			target.setUpdatetime(new Date());
			userSerivce.updateByPrimaryKey(target);
		}
		return ResultData.buildSuccessResult();
	}
	
	@GetMapping("{userName}/validateUserName")
	public ResultData validateUserName(@PathVariable("userName") String userName) {
		User user = userSerivce.queryByUserName(userName);
		if (user == null) {
			return ResultData.buildSuccessResult();
		}
		return ResultData.buildFailureResult();
	}
	
	@RequestMapping("/delete")
	public ResultData delete(String[] ids) {
		//判断是否有子记录
		List<String> idList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		for (String id : ids) {
			List<Role> roleList = roleService.queryRoleByUserId(id);
			if (roleList == null || roleList.size() <= 0) {
				idList.add(id);
			} else {
				User user = userSerivce.selectByPrimaryKey(id);
				nameList.add(user.getUsername());
			}
		}
		
		if (idList.size() > 0) {
			userSerivce.delBatch(idList);
		}
		return ResultData.buildSuccessResult("删除成功", nameList);
	}
	
	//跳转到分配角色页面
	@GetMapping("/{id}/assign")
	public ModelAndView assign(ModelAndView mv, @PathVariable("id") String id) {
		mv.addObject("id", id);
		mv.setViewName("system/assign_user");
		return mv;
	}
	
	//加载所有角色
	@PostMapping("/getRoleList")
	public ResultData getRoleList() {
		List<Role> list = roleService.queryAll();
		return ResultData.buildSuccessResult("请求数据成功", list);
	}
	
	//获取用户相应角色
	@GetMapping("/{id}/role")
	public ResultData userRoleList(@PathVariable("id") String id) {
		List<Role> list = roleService.queryRoleByUserId(id);
		return ResultData.buildSuccessResult("请求数据成功", list);
	}
}
