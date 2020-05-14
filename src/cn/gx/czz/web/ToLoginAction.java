package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录页面跳转的action
 * 
 * @author ASUS
 *
 */
public class ToLoginAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws Exception {
		// 跳转到登录页面
		return "login";
	}

}
