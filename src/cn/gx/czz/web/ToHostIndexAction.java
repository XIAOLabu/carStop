package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;

/**
 * �û�����ҳ����ת��Action
 * 
 * @author ASUS
 *
 */
public class ToHostIndexAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws Exception {
		// ��ʼ��һ��session����
		Map<String, Object> session = ActionContext.getContext().getSession();
		// ��ȡsession�е��û���Ϣ
		User user = (User) session.get("user");
		// ��֤�û��Ƿ��¼
		if (user != null) {
			// �ѵ�¼����ת���û�����ҳ��
			return "hostIndex";
		} else {
			// δ��¼����ת����¼ҳ��
			return "longin";
		}

	}

}
