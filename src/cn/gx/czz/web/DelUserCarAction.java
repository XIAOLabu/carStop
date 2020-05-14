package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Car;
import cn.gx.czz.service.CarService;
import cn.gx.czz.util.AppException;

/**
 * 对车辆ID的数据 进行删除Action
 * 
 * @author ASUS
 *
 */
public class DelUserCarAction extends ActionSupport implements ModelDriven<Car> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private CarService carService = new CarService();
	private Car car = new Car();
	private String message = null;

	@Override
	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public String execute() throws AppException {
		try {
			if (carService.delCar(car.getC_cid())) {
				message = "删除车辆信息成功";
			} else {
				message = "删除车辆信息失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		System.out.println(message + "      44    DelUserCarAction.jsva  ");
		return "delUserCar";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
