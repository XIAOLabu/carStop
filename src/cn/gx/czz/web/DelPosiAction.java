package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 根据cw_id删除车位action
 * 
 * @author ASUS
 *
 */
public class DelPosiAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 获取HttpServletRequest对象 初始化cw_id 重新声明车位业务类
	HttpServletRequest request = ServletActionContext.getRequest();
	private int cw_id;
	private PosiTionService positionService = new PosiTionService();

	/**
	 * 处理车位删除功能和跳转
	 */
	@Override
	public String execute() throws AppException {

		try {
			positionService.deletePosi(cw_id);
		} catch (AppException e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "delposi";
	}

	public int getCw_id() {
		return cw_id;
	}

	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}

}
