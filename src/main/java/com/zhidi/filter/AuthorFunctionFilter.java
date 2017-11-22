package com.zhidi.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 正对于直接通过浏览器地址栏访问时的权限验证
 * @author 梅佳杰
 *
 */
public class AuthorFunctionFilter implements Filter{
	
	Logger log = Logger.getLogger(AuthorFunctionFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		//获取用户权限
		List<String> userUrls = (List<String>) session.getAttribute("userUrls");
		//获取所有系统权限
		List<String> urls = (List<String>) context.getAttribute("urls");
		//获取请求uri
		String URI = request.getRequestURI();
		//截取？之前
		int index = URI.indexOf("?");
		if (index != -1) {
			URI = URI.substring(0, index);
		}
		log.info("对请求：" + URI + "进行权限验证");
		for (String url : urls) {
			if (URI.equals(url)) {
				for (String userUrl : userUrls) {
					if (url.equals(userUrl)) {
						chain.doFilter(request, response);
						log.info("对请求：" + URI + "进行权限验证通过");
						return;
					}
				}
				log.info("用户没有该URI的访问权限！！！");
				response.sendRedirect(request.getContextPath() + "/nofunc.html");
				return;
			}
		}
		//如果是不在权限列表中URL就继续执行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
