package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户管理跳转的Action
 */
public class ToUserManaGementAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理页面跳转
	 */
	@Override
	public String execute() throws Exception {
		return "usermanagement";	//跳转到用户管理页面usermanagement.jsp
	}

}
