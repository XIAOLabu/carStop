package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 进行车位信息更新的action
 * 
 * @author ASUS
 *
 */
public class Up2PosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private PosiTion position = new PosiTion();
	private PosiTionService positionService = new PosiTionService();
	HttpServletRequest request = ServletActionContext.getRequest();
	private String message;

	@Override
	public PosiTion getModel() {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * 更新车位实例的处理
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (position.getCw_user().equals("临时用户")) {
				position.setCw_type(1);
				positionService.updatePosi(position);
			} else if (position.getCw_user().equals("公共社会用户")) {
				position.setCw_type(2);
				positionService.updatePosi(position);
			} else {
				positionService.updatePosi(position);
				message = "更新成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		System.out.println(message);
		return "selectPosi";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
