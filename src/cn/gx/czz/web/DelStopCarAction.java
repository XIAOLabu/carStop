package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ɾ��ͣ����Ϣ��Action
 * 
 * @author ASUS
 *
 */
public class DelStopCarAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private StopService stopService = new StopService();
	private String message;

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	@Override
	public String execute() throws AppException {
		try {
			if (stopService.delStop(stop.getS_id())) {
				message = "ɾ���ɹ�";
			} else {
				message = "ɾ��ʧ��";
			}
			System.out.println(message);
			return "delStop";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
