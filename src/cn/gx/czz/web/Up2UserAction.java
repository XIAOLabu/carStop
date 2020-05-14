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
 * 进行用户信息更新action
 * 
 * @author ASUS
 *
 */
public class Up2UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化用户业务逻辑类
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
			// 初始化接收对象
			message = null;
			Map<String, Object> session = ActionContext.getContext().getSession();
			user0 = (User) session.get("user");
			user1 = userService.showid(user.getU_id());
			flag = user.equals(user1);
			if (!flag) {
				userService.updateUser(user);
				message = "更新成功";
			} else {
				message = "用户未进行信息改动！";
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
			// 系统异常，跳转到异常页面
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
