package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 查询单个车位对象Action
 * 
 * @author ASUS
 *
 */
public class ToQueryPosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private PosiTionService positionService = new PosiTionService();
	private List<PosiTion> posiList;
	private String message;
	private PosiTion position = new PosiTion();

	/**
	 * 分别对获取的值进行对应的查询处理
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (position.getCw_user() != null) {
				// 根据车位户主名
				posiList = positionService.selectPostcw_user(position.getCw_user());
				request.setAttribute("posiList", posiList);
				position = null;
			} else if (position.getCw_wz() != null) {
				// 根据车位区域
				posiList = positionService.selectPostcw_wz(position.getCw_wz());
				request.setAttribute("posiList", posiList);
				position = null;
			} else if (position.getCw_state() != null) {
				// 根据车位使用情况
				posiList = positionService.selectPostcw_state(position.getCw_state());
				request.setAttribute("posiList", posiList);
				position = null;
			}
			if (posiList.size() != 0) {
				message = "车位信息如下：";
			} else {
				message = "查询不到车位信息";
			}
			return "showup";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public PosiTion getModel() {
		// TODO Auto-generated method stub
		return position;
	}

}
