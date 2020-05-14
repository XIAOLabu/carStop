package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ����ͣ����Ϣ��Action
 * 
 * @author ASUS
 *
 */
public class Up2StopCarAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private String message;
	private StopService stopService = new StopService();

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	/**
	 * ����action�ķ���
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (stopService.up2Stop(stop)) {
				message = "���ݸ��³ɹ�";
			} else {
				message = "���ݸ���ʧ��";
			}
			System.out.println(message);
			return "up2Stop";
		} catch (AppException e) {
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

}
