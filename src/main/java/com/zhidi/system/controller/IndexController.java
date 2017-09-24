package com.zhidi.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/system")
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
}
