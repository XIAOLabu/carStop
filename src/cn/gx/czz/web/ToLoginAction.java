package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��¼ҳ����ת��action
 * 
 * @author ASUS
 *
 */
public class ToLoginAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws Exception {
		// ��ת����¼ҳ��
		return "login";
	}

}
