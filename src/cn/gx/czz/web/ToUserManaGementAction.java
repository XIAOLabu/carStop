package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �û�������ת��Action
 */
public class ToUserManaGementAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws Exception {
		return "usermanagement";	//��ת���û�����ҳ��usermanagement.jsp
	}

}
