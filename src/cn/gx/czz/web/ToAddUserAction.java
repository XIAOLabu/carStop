package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;

/**
 * �����û���ת��Action
 */
public class ToAddUserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// ��ȡsession�е��û�����
		Map<?, ?> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			// ����û�û�е�¼������ת����¼ҳ��
			return "login";
		}

		return "adduser"; // ��ת�����û�ҳ�� adduser.jsp
	}

}
