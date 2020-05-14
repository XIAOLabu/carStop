package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * ���г�λ��Ϣ���µ�action
 * 
 * @author ASUS
 *
 */
public class Up2PosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * ������
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
	 * ���³�λʵ���Ĵ���
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (position.getCw_user().equals("��ʱ�û�")) {
				position.setCw_type(1);
				positionService.updatePosi(position);
			} else if (position.getCw_user().equals("��������û�")) {
				position.setCw_type(2);
				positionService.updatePosi(position);
			} else {
				positionService.updatePosi(position);
				message = "���³ɹ�";
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
