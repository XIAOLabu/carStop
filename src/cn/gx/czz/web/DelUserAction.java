package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * ɾ���û�action
 * 
 * @author ASUS
 *
 */
public class DelUserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ȡHttpServletRequest����
	HttpServletRequest request = ServletActionContext.getRequest();
	private int u_id;
	private String message;
	// ��ʼ���û�ҵ���߼���
	private UserService userService = new UserService();

	/**
	 * ����ɾ���û������ת�ͷ�������
	 */
	@Override
	public String execute() throws AppException {
		try {
			/**
			 * ɾ���ɹ�����ת���û�ҳ
			 */
			// ����ɾ���û�����
			if (userService.deleteUser(u_id)) {
				message = "ɾ���ɹ�";
			} else {
				message = "ɾ��ʧ��";
			}

		} catch (AppException e) {
			// ϵͳ�쳣����ת���쳣ҳ��
			e.printStackTrace();
			return "error";
		}
		System.out.println(message + " 52        DelUserAction.java");
		return "delUser";
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
