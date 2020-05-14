package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.util.AppException;

/**
 * 跳转到用户个人车辆信息
 * 
 * @author ASUS
 *
 */
public class ToUserCarAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 进行跳转处理
	 */
	@Override
	public String execute() throws AppException {
		try {
			return "toshowcar";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
