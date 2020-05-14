package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * ������λ Action
 * 
 * @author ASUS
 *
 */
public class AddPosiAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ����λʵ����
	private PosiTion position = new PosiTion();
	private String message;
	// ��������ʼ����λҵ���߼���
	private PosiTionService positionService = new PosiTionService();

	/**
	 * ģ�ͻ���λ��
	 */
	@Override
	public PosiTion getModel() {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * ��������ʵ��
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (!positionService.isnoadd(position.getCw_no())) {
				if (position.getCw_type() == 0) {
					if (position.getCw_user().equals("��ʱ�û�")) {
						position.setCw_type(1);
					} else if (position.getCw_user().equals("��������û�")) {
						position.setCw_type(2);
					}
					positionService.addseve(position);
					message = "˽�ҳ���λ���ӳɹ���";
				} else if (position.getCw_type() == 1) {
					position.setCw_user("��ʱ�û�");
					positionService.addseve(position);
					System.out.println(position.getCw_user());
					message = "��ʱ��λ���ӳɹ���";
				} else if (position.getCw_type() == 2) {
					position.setCw_user("��������û�");
					positionService.addseve(position);
					message = "������λ���ӳɹ���";
				}
			} else {
				message = "��λ����ʧ�ܣ�";
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
