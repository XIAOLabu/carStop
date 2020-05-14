package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * �����û���ѯ��ϢAction
 * 
 * @author ASUS
 *
 */
public class ToQueryUserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private List<User> userList;
	// ��ʼ���û�ҵ���߼���
	private UserService userService = new UserService();
	private String u_user, message;
	// ����õ�ǰ����Ķ���
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("run toQueryUserAction");

		try {
			userList = userService.selectUser(u_user);
			request.setAttribute("userList", userList);
			if (userList.size() != 0) {
				message = "�û���Ϣ���£�";
			} else {
				message = "���û������ڻ����ѱ�ɾ��";
			}
		} catch (AppException e) {
			// ϵͳ�쳣����ת���쳣ҳ��
			e.printStackTrace();
			return "error";
		}
		return "quser";
	}

	public String getU_user() {
		return u_user;
	}

	public void setU_user(String u_user) {
		this.u_user = u_user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
