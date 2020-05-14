package cn.gx.czz.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * �����û���Ϣ����action
 * 
 * @author ASUS
 *
 */
public class Up2UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ���û�ҵ���߼���
	private UserService userService = new UserService();
	HttpServletRequest request = ServletActionContext.getRequest();
	private String message;
	Boolean flag;
	private User user = new User();
	private User user1 = new User();
	private User user0 = new User();
	List<User> userList;

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public String execute() throws AppException {
		try {
			// ��ʼ�����ն���
			message = null;
			Map<String, Object> session = ActionContext.getContext().getSession();
			user0 = (User) session.get("user");
			user1 = userService.showid(user.getU_id());
			flag = user.equals(user1);
			if (!flag) {
				userService.updateUser(user);
				message = "���³ɹ�";
			} else {
				message = "�û�δ������Ϣ�Ķ���";
			}
			if (user0.getU_del() != 0) {
				System.out.println("run   64");
				userList = userService.selectUser(user.getU_user());
				request.setAttribute("userList", userList);
				return "selectUser";
			} else {
				return "selectUser1";
			}

		} catch (AppException e) {
			// ϵͳ�쳣����ת���쳣ҳ��
			e.printStackTrace();
			return "error";
		}
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
