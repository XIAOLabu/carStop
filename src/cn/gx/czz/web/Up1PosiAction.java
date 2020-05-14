package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 根据cw_id查询车位 并跳转到更新车位信息页面的action
 * 
 * @author ASUS
 *
 */
public class Up1PosiAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化业务逻辑类，获取HttpServletRequest对象 声明集合positionid 获取前端传回来的
	HttpServletRequest request = ServletActionContext.getRequest();
	private PosiTionService positionService = new PosiTionService();
	private List<PosiTion> positionid;
	private int cw_id;

	/**
	 * 根据车位ID查询车位，并跳转到更新车位页面
	 */
	@Override
	public String execute() throws AppException {
		System.out.println("Up1PosiAction");
		try {
			// 传参到查询方法中 获取返回用户对象
			positionid = positionService.selectPostcw_id(cw_id);
			// 把获取的值存到request里面
			request.setAttribute("positionid", positionid);
			// 无误后进行跳转到更新页面
			return "selectPosi";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public int getCw_id() {
		return cw_id;
	}

	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}

}
