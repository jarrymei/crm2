package com.zhidi.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.zhidi.common.SpringBeanFactoryUtils;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.IFunctionService;

/**
 * 加载按钮权限
 * @author 梅佳杰
 *
 */
public class FunctionTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PageContext pageContext;

	/**
	 * 权限类型
	 */
	private String funcCode;
	
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
	
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	@Override
	public int doStartTag() throws JspException {
		
		HttpSession session = pageContext.getSession();
		
		//获取登录用户
		User user = (User) session.getAttribute("user");
		
		IFunctionService functionService = (IFunctionService) SpringBeanFactoryUtils.getBean("functionServiceImpl");
		
		Boolean status = functionService.authorFunc(user.getId(), funcCode);
		//如果为true，则判断成功，显示自定义标签中的按钮，否则不显示
		if (status) {
			return TagSupport.EVAL_BODY_INCLUDE;
		} else {
			return TagSupport.SKIP_BODY;
		}
	}

}
