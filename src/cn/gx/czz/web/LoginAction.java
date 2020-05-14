package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * �û���¼Action
 * 
 * @author ASUS
 *
 */
public class LoginAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ������Ա����
	 */
	private String u_user, u_pwd, message, del; // del �û����͡� message ��ʾ����
	// ��ʼ���û�ҵ���߼�
	private UserService userService = new UserService();

	/**
	 * �����û���¼����¼�ɹ��������ҳ�棬ʧ������ת����¼ҳ�������ʾ��Ϣ
	 */
	@Override
	public String execute() throws Exception {
		/**
		 * ���е�¼���������߼���UserService���login(u_user,u_pwd)���� ��ѯƥ���û��������û�����
		 */
		try {
			// ��¼��ѯ
			User user = userService.login(u_user, u_pwd);
			if (user != null) {
				// ��ʼ��һ��session����
				Map<String, Object> session = ActionContext.getContext().getSession();
				// ��ѯ��ƥ���û���������session�У���ת���û�����ҳ��
				if (user.getU_del() == 0) {
					del = "��ͨ�û�";
				} else {
					del = "����Ա";
				}
				session.put("del", del);
				session.put("user", user);
				session.put("u_user", user.getU_user());
				session.put("u_del", user.getU_del());
				System.out.println("���е�LoginAction.java���û���Ϣ���б�����");
				return "hostIndex";
			} else {
				// 2.��¼ʧ�ܣ���������¼ҳ����ʾ������Ϣ
				System.out.println("��¼ʧ�ܣ���������¼ҳ��");
				message = "�û���¼��Ϣ����" + "/n" + "�����µ�¼��";
				return "login";
			}
		} catch (AppException e) {
			// 3.ϵͳ�쳣����ת���쳣ҳ��
			e.printStackTrace();
			return "error";
		}

	}

	// ��Ա������get ,set ����

	public String getU_user() {
		return u_user;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public void setU_user(String u_user) {
		this.u_user = u_user;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
