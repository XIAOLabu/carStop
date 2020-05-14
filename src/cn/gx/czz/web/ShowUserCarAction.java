package cn.gx.czz.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Car;
import cn.gx.czz.model.User;
import cn.gx.czz.service.CarService;
import cn.gx.czz.util.AppException;

/**
 * 显示用户自己的车辆
 * 
 * @author ASUS
 *
 */
public class ShowUserCarAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();
	private CarService carService = new CarService();
	private Car car = new Car();
	private User user = new User();
	private List<Car> carList;

	@Override
	public String execute() throws AppException {
		try {
			user = (User) session.get("user");
			car.setC_user(user.getU_user());
			carList = carService.showCar(car.getC_user());
			request.setAttribute("carList", carList);
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public Car getCar() {
		return car;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

}
