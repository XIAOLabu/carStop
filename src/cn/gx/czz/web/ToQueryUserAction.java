package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 单个用户查询信息Action
 * 
 * @author ASUS
 *
 */
public class ToQueryUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private List<User> userList;
	// 初始化用户业务逻辑类
	private UserService userService = new UserService();
	private String u_user, message;
	// 来获得当前请求的对象
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("run toQueryUserAction");

		try {
			userList = userService.selectUser(u_user);
			request.setAttribute("userList", userList);
			if (userList.size() != 0) {
				message = "用户信息如下：";
			} else {
				message = "该用户不存在或者已被删除";
			}
		} catch (AppException e) {
			// 系统异常，跳转到异常页面
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
