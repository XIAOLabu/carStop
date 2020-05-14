package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Car;
import cn.gx.czz.service.CarService;
import cn.gx.czz.util.AppException;

/**
 * �Գ�����Ϣ���и��µ�Action2 ʵ�ָ��³�����Ϣ
 * 
 * @author ASUS
 *
 */
public class Up2UserCarAction extends ActionSupport implements ModelDriven<Car> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private CarService carService = new CarService();
	private Car car = new Car();
	private Car car0 = new Car();
	private Boolean flag;
	private String message = null;

	@Override
	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	/**
	 * �Գ�����Ϣ���´���
	 */
	@Override
	public String execute() throws AppException {
		try {
			car0 = carService.showCarid(car.getC_cid());
			flag = car.equals(car0);
			if (!flag) {
				carService.up2Car(car);
				message = "���³ɹ�";
			} else {
				message = "�û�δ������Ϣ�Ķ�";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "up2UserCar";
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
