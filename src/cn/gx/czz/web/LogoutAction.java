package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û��ǳ�Action
 * 
 * @author ASUS
 *
 */
public class LogoutAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ע���û����Ƴ�session���û���Ϣ����ת����ҳ
	 */
	@Override
	public String execute() throws Exception {
		// ��ʼ��һ��session����
		Map<String, Object> session = ActionContext.getContext().getSession();
		// �Ƴ�session�е��û���Ϣ
		session.remove("user");
		// �û��ǳ�ʱ�������������ջ��ơ���
		System.gc();
		Thread.sleep(50);
		// ��ת����¼ҳ
		return "index";
	}
}
