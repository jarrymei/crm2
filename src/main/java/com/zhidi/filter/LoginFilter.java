package com.zhidi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhidi.system.entity.User;

/**
 * 登录验证过滤器
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		/**
		 * 1.获取请求信息
		 * 2.或会话中的登录用户信息
		 * 3.判断是否存在登录用户->存在：请求继续执行    ->不存在：栏会登录页面
		 * 4.URI:login.do的请求不拦截
		 */
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		String uri = request.getRequestURI();
		
		if (user == null && !uri.equals(request.getContextPath() + "/system/user/login.do")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
