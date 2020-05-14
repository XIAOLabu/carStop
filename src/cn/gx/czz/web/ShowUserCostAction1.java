package cn.gx.czz.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.SumUserCost;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 1，通过用户名 查询到自己的车辆车牌-----显示出每量车的消费总金额 --第一个Actions
 * 
 * @author ASUS
 *
 */
public class ShowUserCostAction1 extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;

	private String c_user, message;
	private StopService stopService = new StopService();
	private List<SumUserCost> userCostList = new ArrayList<SumUserCost>();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			System.out.println(c_user);
			// 进行判断
			if (c_user != null) {
				// 直接通过用户名查询该用户的车辆信息和收费信息
				userCostList = stopService.showCnoCostAll(c_user);
			} else {
				Map<String, Object> session = ActionContext.getContext().getSession();
				c_user = (String) session.get("u_user");
				userCostList = stopService.showCnoCostAll(c_user);
			}
			message = c_user;
			request.setAttribute("userCostList", userCostList);
			System.out.println(userCostList+"                 33333333");
			return "showusercost1";
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

	public String getC_user() {
		return c_user;
	}

	public void setC_user(String c_user) {
		this.c_user = c_user;
	}

}
