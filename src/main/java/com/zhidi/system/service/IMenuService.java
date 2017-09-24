package com.zhidi.system.service;

import java.util.List;

import com.zhidi.system.entity.vo.MenuVO;

public interface IMenuService {

	List<MenuVO> queryByUserId(String userId);
}
