package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * �����û� Action
 * 
 * @author ASUS
 */

public class AddUserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	// ˽�����Զ���
	private String u_user, u_phone, u_pwd, u_pwd2, u_sex, message;
	private int u_del;
	// ��������ʼ���û�ҵ���߼���
	private UserService userService = new UserService();

	/**
	 * �����û����ӣ����ӳɹ�����ת���û�����ҳ�� usermanagement.jsp ���򣬷��ص�ǰҳ��������ʾ��Ϣ adduser.jsp
	 */
	@Override

	public String execute() {
		// ��ʼ��User���󣬽���ע����Ϣ
		User user = new User();
		// Ϊuser�������������ֵ
		user.setU_user(u_user);
		user.setU_phone(u_phone);
		user.setU_pwd(u_pwd);
		user.setU_sex(u_sex);
		user.setU_del(u_del);
		try {
			if (userService.register(user)) {
				// �����ɹ�����ת���û�����ҳ��
				System.out.println("// 1.�����ɹ�����ת���û�����ҳ��");
				return "usermanagement";
			} else {
				// ����ʧ�ܺ󷵻ص�ǰҳ��������ʧ����ʾ��
				System.out.println("// ʧ��������������������");
				message = "���û����Ѿ�����";
				return "register";
			}
		} catch (AppException e) {
			e.printStackTrace();
			// ϵͳ�쳣����ת���쳣ҳ�� error.jsp
			System.out.println("// ϵͳ�쳣����ת���쳣ҳ�� error.jsp");
			return "error";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getU_user() {
		return u_user;
	}

	public void setU_user(String u_user) {
		this.u_user = u_user;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_pwd2() {
		return u_pwd2;
	}

	public void setU_pwd2(String u_pwd2) {
		this.u_pwd2 = u_pwd2;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public int getU_del() {
		return u_del;
	}

	public void setU_del(int u_del) {
		this.u_del = u_del;
	}

}
