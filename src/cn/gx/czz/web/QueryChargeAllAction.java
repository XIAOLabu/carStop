package cn.gx.czz.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Car;
import cn.gx.czz.model.Stop;
import cn.gx.czz.service.CarService;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * �����շѲ�ѯ��Action ���ݳ��ƺ� ���� ��������
 * 
 * @author ASUS
 * @param <E>
 *
 */
public class QueryChargeAllAction<E> extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private String s_tcn; // ����ͣ����Ϣ�ı�����в�ѯ
	private String c_user; // �����û������ı�����в�ѯ�����������س�����Ϣ
	private CarService carService = new CarService();
	private StopService stopService = new StopService();
	private Stop stop = new Stop();
	private List<Car> carList; // �����û����µĳ�����Ϣ
	private List<Stop> stopList; // ���泵��ͣ����Ϣ
	private int z; // ������ж�����
	HttpServletRequest request = ServletActionContext.getRequest();
	private String message;

	/**
	 * ����ʵ�ַ���
	 */
	@Override
	public String execute() throws AppException {
		try {
			System.out.println(s_tcn);
			System.out.println(c_user);
			carList = carService.showCar(c_user);
			System.out.println(carList);
			System.out.println(stop);
			List<Stop> stopList1 = new ArrayList<>();
			if ("".equals(s_tcn)) {
				z = 2;
			}
			if ("".equals(c_user)) {
				z = 1;
			}
			if (!"".equals(s_tcn) && !"".equals(c_user)) {
				z = 3;
			}
			switch (z) {
			case 1:
				System.out.println("             ���г��ƺŲ�ѯ");
				stop.setS_tcn(s_tcn);
				stopList = stopService.queryStop(stop, null);
				stopList1.addAll(stopList);
				break;

			case 2:

				System.out.println("             �����û�����ѯ");
				for (int i = 0; i < carList.size(); i++) {
					System.out.println(carList.get(i).getC_cno());
					String cno = carList.get(i).getC_cno();
					stop.setS_tcn(cno);
					stopList = stopService.queryStop(stop, null);
					stopList1.addAll(stopList);
				}
				break;

			case 3:
				System.out.println("�������û����ͳ��ƺŵĲ�ѯ");
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getC_cno().equals(s_tcn)) {
						String cno = carList.get(i).getC_cno();
						stop.setS_user(cno);
						stop.setS_tcn(cno);
						stopList = stopService.queryStop(stop, null);
						stopList1.addAll(stopList);
					}
				}
				break;

			default:
				message = "û�з��������ĳ���";
			}
			z = 0;
			request.setAttribute("stopList", stopList1);
			request.setAttribute("userList", carList);
			if (stopList1.size() > 0) {
				message = "������Ϣ���£�";
			} else {
				message = "û�з��������ĳ���";
			}
			System.out.println(stopList1);
			return "showCost";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getS_tcn() {
		return s_tcn;
	}

	public String getC_user() {
		return c_user;
	}

	public void setS_tcn(String s_tcn) {
		this.s_tcn = s_tcn;
	}

	public void setC_user(String c_user) {
		this.c_user = c_user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
