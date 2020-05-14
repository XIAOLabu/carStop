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
 * ��ѯ������λ����Action
 * 
 * @author ASUS
 *
 */
public class ToQueryPosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private PosiTionService positionService = new PosiTionService();
	private List<PosiTion> posiList;
	private String message;
	private PosiTion position = new PosiTion();

	/**
	 * �ֱ�Ի�ȡ��ֵ���ж�Ӧ�Ĳ�ѯ����
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (position.getCw_user() != null) {
				// ���ݳ�λ������
				posiList = positionService.selectPostcw_user(position.getCw_user());
				request.setAttribute("posiList", posiList);
				position = null;
			} else if (position.getCw_wz() != null) {
				// ���ݳ�λ����
				posiList = positionService.selectPostcw_wz(position.getCw_wz());
				request.setAttribute("posiList", posiList);
				position = null;
			} else if (position.getCw_state() != null) {
				// ���ݳ�λʹ�����
				posiList = positionService.selectPostcw_state(position.getCw_state());
				request.setAttribute("posiList", posiList);
				position = null;
			}
			if (posiList.size() != 0) {
				message = "��λ��Ϣ���£�";
			} else {
				message = "��ѯ������λ��Ϣ";
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
