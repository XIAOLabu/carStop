package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 用户登录Action
 * 
 * @author ASUS
 *
 */
public class LoginAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 创建成员变量
	 */
	private String u_user, u_pwd, message, del; // del 用户类型。 message 提示错误
	// 初始化用户业务逻辑
	private UserService userService = new UserService();

	/**
	 * 处理用户登录，登录成功进入管理页面，失败则跳转到登录页面给出提示信息
	 */
	@Override
	public String execute() throws Exception {
		/**
		 * 进行登录处理，调用逻辑层UserService类的login(u_user,u_pwd)方法 查询匹配用户，返回用户对象
		 */
		try {
			// 登录查询
			User user = userService.login(u_user, u_pwd);
			if (user != null) {
				// 初始化一个session对象
				Map<String, Object> session = ActionContext.getContext().getSession();
				// 查询到匹配用户，保存至session中，跳转到用户中心页面
				if (user.getU_del() == 0) {
					del = "普通用户";
				} else {
					del = "管理员";
				}
				session.put("del", del);
				session.put("user", user);
				session.put("u_user", user.getU_user());
				session.put("u_del", user.getU_del());
				System.out.println("运行到LoginAction.java，用户信息进行保存了");
				return "hostIndex";
			} else {
				// 2.登录失败，返回至登录页，提示错误信息
				System.out.println("登录失败，返回至登录页，");
				message = "用户登录信息错误" + "/n" + "请重新登录！";
				return "login";
			}
		} catch (AppException e) {
			// 3.系统异常，跳转到异常页面
			e.printStackTrace();
			return "error";
		}

	}

	// 成员变量的get ,set 方法

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
