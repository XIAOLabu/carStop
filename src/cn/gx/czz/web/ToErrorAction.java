package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ϵͳ�쳣ҳ����ת��action
 * @author ASUS
 *
 */
public class ToErrorAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �쳣ҳ��Ĵ���
	 */
	@Override
	public String execute() throws Exception {
		return "error";
	}
	

}
