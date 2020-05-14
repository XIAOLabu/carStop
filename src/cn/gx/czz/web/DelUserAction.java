package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 删除用户action
 * 
 * @author ASUS
 *
 */
public class DelUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 获取HttpServletRequest对象
	HttpServletRequest request = ServletActionContext.getRequest();
	private int u_id;
	private String message;
	// 初始化用户业务逻辑类
	private UserService userService = new UserService();

	/**
	 * 处理删除用户后的跳转和方法连接
	 */
	@Override
	public String execute() throws AppException {
		try {
			/**
			 * 删除成功，跳转到用户页
			 */
			// 调用删除用户方法
			if (userService.deleteUser(u_id)) {
				message = "删除成功";
			} else {
				message = "删除失败";
			}

		} catch (AppException e) {
			// 系统异常，跳转到异常页面
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
