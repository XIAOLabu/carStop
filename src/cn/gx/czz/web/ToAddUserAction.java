package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;

/**
 * 新增用户跳转的Action
 */
public class ToAddUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 获取session中的用户对象
		Map<?, ?> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			// 如果用户没有登录，则跳转到登录页面
			return "login";
		}

		return "adduser"; // 跳转新增用户页面 adduser.jsp
	}

}
