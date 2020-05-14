package cn.gx.czz.web;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * ������λ��ת��Action
 * 
 * @author ASUS
 *
 */
public class ToAddPosiAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private List<User> useru_user;
	private UserService userService = new UserService();

	/**
	 * ����ҳ����ת
	 */
	@Override
	public String execute() throws AppException {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			// ���泵λ�û���session�У�����ǰ�˻�ȡ
			useru_user = userService.showAllUser();
			session.put("u_s", useru_user);
			/*
			 * List useru_user; UserService userService = new UserService();
			 * HttpServletRequest request = ServletActionContext.getRequest(); useru_user =
			 * userService.showAllUser(); request.setAttribute("u_user", useru_user);
			 * System.out.println(useru_user);
			 */
			if (user == null) {
				// ����û�û�е�¼������ת����¼ҳ��
				return "login";
			}
			return "addcw"; // ��ת������λҳ��
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

}
