package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.util.AppException;

/**
 * ��ת���û����˳�����Ϣ
 * 
 * @author ASUS
 *
 */
public class ToUserCarAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ������ת����
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
