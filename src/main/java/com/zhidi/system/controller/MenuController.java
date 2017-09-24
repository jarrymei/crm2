package com.zhidi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhidi.common.ResultData;
import com.zhidi.system.entity.vo.MenuVO;
import com.zhidi.system.service.IMenuService;

@RestController
@RequestMapping("/system")
public class MenuController {
	
	@Autowired
	private IMenuService menuService;

	
	@GetMapping("/{id}")
	public ResultData menu(@PathVariable("id") String id) {
		List<MenuVO> vos = menuService.queryByUserId(id);
		return ResultData.buildSuccessResult("菜单加载成功", vos);
	}
}
