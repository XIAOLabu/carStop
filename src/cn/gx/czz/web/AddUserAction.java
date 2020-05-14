package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 新增用户 Action
 * 
 * @author ASUS
 */

public class AddUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	// 私有属性定义
	private String u_user, u_phone, u_pwd, u_pwd2, u_sex, message;
	private int u_del;
	// 声明并初始化用户业务逻辑类
	private UserService userService = new UserService();

	/**
	 * 处理用户增加，增加成功后跳转到用户管理页面 usermanagement.jsp 否则，返回当前页，给出提示信息 adduser.jsp
	 */
	@Override

	public String execute() {
		// 初始化User对象，接收注册信息
		User user = new User();
		// 为user对象的属性设置值
		user.setU_user(u_user);
		user.setU_phone(u_phone);
		user.setU_pwd(u_pwd);
		user.setU_sex(u_sex);
		user.setU_del(u_del);
		try {
			if (userService.register(user)) {
				// 新增成功后跳转至用户管理页面
				System.out.println("// 1.新增成功后跳转至用户管理页面");
				return "usermanagement";
			} else {
				// 新增失败后返回当前页，并弹出失败提示！
				System.out.println("// 失败啦！！！！！！！！");
				message = "该用户名已经存在";
				return "register";
			}
		} catch (AppException e) {
			e.printStackTrace();
			// 系统异常，跳转到异常页面 error.jsp
			System.out.println("// 系统异常，跳转到异常页面 error.jsp");
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
