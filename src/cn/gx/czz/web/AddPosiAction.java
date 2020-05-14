package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 新增车位 Action
 * 
 * @author ASUS
 *
 */
public class AddPosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化车位实体类
	private PosiTion position = new PosiTion();
	private String message;
	// 声明并初始化车位业务逻辑类
	private PosiTionService positionService = new PosiTionService();

	/**
	 * 模型化车位类
	 */
	@Override
	public PosiTion getModel() {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * 方法调用实现
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (!positionService.isnoadd(position.getCw_no())) {
				if (position.getCw_type() == 0) {
					if (position.getCw_user().equals("临时用户")) {
						position.setCw_type(1);
					} else if (position.getCw_user().equals("公共社会用户")) {
						position.setCw_type(2);
					}
					positionService.addseve(position);
					message = "私家车车位增加成功！";
				} else if (position.getCw_type() == 1) {
					position.setCw_user("临时用户");
					positionService.addseve(position);
					System.out.println(position.getCw_user());
					message = "临时车位增加成功！";
				} else if (position.getCw_type() == 2) {
					position.setCw_user("公共社会用户");
					positionService.addseve(position);
					message = "公共车位增加成功！";
				}
			} else {
				message = "车位增加失败！";
				System.out.println(message);
				return "noadd";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "addcw";

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
