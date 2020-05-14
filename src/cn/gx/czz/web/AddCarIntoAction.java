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
 * 处理汽车入场的Action
 * 
 * @author ASUS
 *
 */
public class AddCarIntoAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private StopService stopService = new StopService();
	private CarService carService = new CarService();
	private PosiTionService positionService = new PosiTionService();
	private Date date; // 获取当前时间
	private boolean a, b, d; // 获取该车是否为小区用户的, 判断车位是否被占用
	private String c, message; // 获取停车位置的号码

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
			// 判断是否有该车牌号，有则为小区车辆，否者为非小区用户
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
				// 入场时，记录该车位，并更新车位状态
				d = positionService.upcw_state(c, "占用");
			}
			if (d) {
				stopService.addStop(stop);
				message = "车辆入场成功";
			} else {
				message = "车辆入场失败,车位已停有车了";
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
