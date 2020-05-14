package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 系统异常页面跳转的action
 * @author ASUS
 *
 */
public class ToErrorAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常页面的处理
	 */
	@Override
	public String execute() throws Exception {
		return "error";
	}
	

}
