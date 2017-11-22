package com.zhidi.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.zhidi.common.SpringBeanFactoryUtils;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.IFunctionService;

/**
 * ���ذ�ťȨ��
 * @author ÷�ѽ�
 *
 */
public class FunctionTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PageContext pageContext;

	/**
	 * Ȩ������
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
		
		//��ȡ��¼�û�
		User user = (User) session.getAttribute("user");
		
		IFunctionService functionService = (IFunctionService) SpringBeanFactoryUtils.getBean("functionServiceImpl");
		
		Boolean status = functionService.authorFunc(user.getId(), funcCode);
		//���Ϊtrue�����жϳɹ�����ʾ�Զ����ǩ�еİ�ť��������ʾ
		if (status) {
			return TagSupport.EVAL_BODY_INCLUDE;
		} else {
			return TagSupport.SKIP_BODY;
		}
	}

}
