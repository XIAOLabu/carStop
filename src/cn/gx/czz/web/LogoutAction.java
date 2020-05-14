package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登出Action
 * 
 * @author ASUS
 *
 */
public class LogoutAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 注销用户，移除session中用户信息，跳转到首页
	 */
	@Override
	public String execute() throws Exception {
		// 初始化一个session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 移除session中的用户信息
		session.remove("user");
		// 用户登出时，调用垃圾回收机制——
		System.gc();
		Thread.sleep(50);
		// 跳转到登录页
		return "index";
	}
}
