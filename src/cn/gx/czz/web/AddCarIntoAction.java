package cn.gx.czz.web;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.CarService;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ���������볡��Action
 * 
 * @author ASUS
 *
 */
public class AddCarIntoAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private StopService stopService = new StopService();
	private CarService carService = new CarService();
	private PosiTionService positionService = new PosiTionService();
	private Date date; // ��ȡ��ǰʱ��
	private boolean a, b, d; // ��ȡ�ó��Ƿ�ΪС���û���, �жϳ�λ�Ƿ�ռ��
	private String c, message; // ��ȡͣ��λ�õĺ���

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	@Override
	public String execute() throws AppException {
		try {
			date = new Date();
			stop.setS_cit(new Timestamp(date.getTime()));
			boolean a = carService.isExist(stop.getS_tcn());
			// �ж��Ƿ��иó��ƺţ�����ΪС������������Ϊ��С���û�
			if (a) {
				stop.setS_tcu(0);
				stop.setS_user(carService.addStopUser(stop.getS_tcn()).getC_user());
				System.out.println(stop.getS_user() + "       AddCarIntoAction              ");
			} else {
				stop.setS_tcu(1);
			}

			c = stop.getS_tcw().substring(3);
			b = positionService.isnoadd(c);
			if (b) {
				// �볡ʱ����¼�ó�λ�������³�λ״̬
				d = positionService.upcw_state(c, "ռ��");
			}
			if (d) {
				stopService.addStop(stop);
				message = "�����볡�ɹ�";
			} else {
				message = "�����볡ʧ��,��λ��ͣ�г���";
			}
			System.out.println(message);
			return "addsc";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public boolean isB() {
		return b;
	}

	public boolean isD() {
		return d;
	}

	public String getMessage() {
		return message;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
