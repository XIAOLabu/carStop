package cn.gx.czz.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 更新停车信息的Action
 * 
 * @author ASUS
 *
 */
public class Up2StopCarAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * 兼容性
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
	 * 处理action的方法
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (stopService.up2Stop(stop)) {
				message = "数据更新成功";
			} else {
				message = "数据更新失败";
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
