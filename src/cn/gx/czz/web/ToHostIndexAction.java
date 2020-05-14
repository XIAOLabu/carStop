package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;

/**
 * 用户中心页面跳转的Action
 * 
 * @author ASUS
 *
 */
public class ToHostIndexAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws Exception {
		// 初始化一个session对象
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 获取session中的用户信息
		User user = (User) session.get("user");
		// 验证用户是否登录
		if (user != null) {
			// 已登录则跳转到用户中心页面
			return "hostIndex";
		} else {
			// 未登录则跳转到登录页面
			return "longin";
		}

	}

}
