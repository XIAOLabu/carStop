package cn.gx.czz.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Car;
import cn.gx.czz.model.User;
import cn.gx.czz.service.CarService;
import cn.gx.czz.util.AppException;

/**
 * 用户自己增加车辆信息
 * 
 * @author ASUS
 *
 */
public class AddCarUserAction extends ActionSupport implements ModelDriven<Car> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private Car car = new Car();
	private User user = new User();
	private String message;
	private CarService carService = new CarService();
	Map<String, Object> session = ActionContext.getContext().getSession();

	/**
	 * 模型化车辆类
	 */
	@Override
	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public String execute() throws AppException {
		try {
			user = (User) session.get("user");
			car.setC_user(user.getU_user());
			if (!carService.isExist(car.getC_cno())) {
				carService.addsave(car);
				message = "私家车增加成功";
			} else {
				message = "私家车增加失败";
			}
			System.out.println(message);
			return "savecar";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public Car getCar() {
		return car;
	}

	public String getMessage() {
		return message;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
