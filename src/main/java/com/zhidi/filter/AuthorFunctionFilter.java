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
 * ������ֱ��ͨ���������ַ������ʱ��Ȩ����֤
 * @author ÷�ѽ�
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
		
		//��ȡ�û�Ȩ��
		List<String> userUrls = (List<String>) session.getAttribute("userUrls");
		//��ȡ����ϵͳȨ��
		List<String> urls = (List<String>) context.getAttribute("urls");
		//��ȡ����uri
		String URI = request.getRequestURI();
		//��ȡ��֮ǰ
		int index = URI.indexOf("?");
		if (index != -1) {
			URI = URI.substring(0, index);
		}
		log.info("������" + URI + "����Ȩ����֤");
		for (String url : urls) {
			if (URI.equals(url)) {
				for (String userUrl : userUrls) {
					if (url.equals(userUrl)) {
						chain.doFilter(request, response);
						log.info("������" + URI + "����Ȩ����֤ͨ��");
						return;
					}
				}
				log.info("�û�û�и�URI�ķ���Ȩ�ޣ�����");
				response.sendRedirect(request.getContextPath() + "/nofunc.html");
				return;
			}
		}
		//����ǲ���Ȩ���б���URL�ͼ���ִ��
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
