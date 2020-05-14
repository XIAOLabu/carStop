package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Car;
import cn.gx.czz.service.CarService;
import cn.gx.czz.util.AppException;

/**
 * 对车辆信息进行更新的Action1 实现查询返回对象信息
 * 
 * @author ASUS
 *
 */
public class Up1UserCarAction extends ActionSupport implements ModelDriven<Car> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private CarService carService = new CarService();
	HttpServletRequest request = ServletActionContext.getRequest();
	private Car car = new Car();
	private List<Car> carUpList;

	@Override
	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	/**
	 * 处理方法
	 */
	@Override
	public String execute() throws AppException {
		try {
			carUpList = carService.upCar(car.getC_cid());
			request.setAttribute("upcar", carUpList);
			System.out.println(carUpList + "                                  Up1UserCarAction");
			return "up1UserCar";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
