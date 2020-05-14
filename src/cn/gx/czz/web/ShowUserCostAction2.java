package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 查询该车牌车辆的具体出入信息的Action
 * 
 * @author ASUS
 *
 */
public class ShowUserCostAction2 extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private String c_tcn, message;
	private StopService stopService = new StopService();
	private Stop stop = new Stop();
	private List<Stop> stopList;
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			message = c_tcn;
			stop.setS_tcn(c_tcn);
			System.out.println(c_tcn);
			stopList = stopService.selectc_tcn(c_tcn);
//			stopList = stopService.queryStop(stop, null);
			System.out.println(stopList);
			request.setAttribute("stopList", stopList);
			return "showusercost2";
		} catch (Exception e) {
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

	public String getC_tcn() {
		return c_tcn;
	}

	public void setC_tcn(String c_tcn) {
		this.c_tcn = c_tcn;
	}

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

}
