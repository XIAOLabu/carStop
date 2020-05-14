package cn.gx.czz.web;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 新增车位跳转的Action
 * 
 * @author ASUS
 *
 */
public class ToAddPosiAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private List<User> useru_user;
	private UserService userService = new UserService();

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws AppException {
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			// 保存车位用户到session中，方便前端获取
			useru_user = userService.showAllUser();
			session.put("u_s", useru_user);
			/*
			 * List useru_user; UserService userService = new UserService();
			 * HttpServletRequest request = ServletActionContext.getRequest(); useru_user =
			 * userService.showAllUser(); request.setAttribute("u_user", useru_user);
			 * System.out.println(useru_user);
			 */
			if (user == null) {
				// 如果用户没有登录，则跳转到登录页面
				return "login";
			}
			return "addcw"; // 跳转新增车位页面
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

}
