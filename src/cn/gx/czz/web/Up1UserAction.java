package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 根据id查询用户 并跳转到更新用户信息页面的action
 *
 * @author ASUS
 *
 */
public class Up1UserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化用户业务逻辑类，获取HttpServletRequest对象
	private UserService userService = new UserService();
	HttpServletRequest request = ServletActionContext.getRequest();
	List<User> userid;
	private int u_id;

	/**
	 * 根据用户id查询用户，并跳转到更新用户页面
	 */
	@Override
	public String execute() throws AppException {
		try {
			// 传参到查询方法中 获取返回用户对象
			System.out.println(u_id);
			userid = userService.selectUserId(u_id);
			// 把获取的值存到request里面
			request.setAttribute("userid", userid);
			// 无误后进行跳转到更新页面
			return "selectUser";
		} catch (AppException e) {
			// 系统异常，跳转到异常页面
			e.printStackTrace();
			return "error";
		}

	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<User> getUserid() {
		return userid;
	}

	public void setUserid(List<User> userid) {
		this.userid = userid;
	}

}
