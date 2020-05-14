package cn.gx.czz.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import cn.gx.czz.model.Car;
import cn.gx.czz.model.SumCostUser;
import cn.gx.czz.model.User;
//import cn.gx.czz.service.CarService;
import cn.gx.czz.service.StopService;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 配置收费统计Action
 * 
 * @author ASUS
 *
 */
public class ChargeTatiAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 申明初始化业务逻辑类
	// private CarService carService = new CarService();
	private StopService stopService = new StopService();
	private UserService userService = new UserService();
	// 申明初始化接收对象集合
	// private List<Car> carList = new ArrayList<Car>();
	private List<SumCostUser> sumCostUserList = new ArrayList<SumCostUser>();
	private List<User> userList = new ArrayList<User>();
	// 申明初始化实体类
	// 申明初始化变量
	private String u_user;

	Map<String, Object> session = ActionContext.getContext().getSession();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			// session.get("user");
			// u_user = (String) session.get("u_user");
			// System.out.println(u_user);

			userList = userService.chargeUser();
			for (int i = 0; i < userList.size(); i++) {
				u_user = userList.get(i).getU_user();
				if (!"".equals(u_user)) {
					// carList = carService.showCar(u_user);
					sumCostUserList.addAll(stopService.chargeCost(u_user));
					System.out.println(sumCostUserList + "    ChargeTatiAction");
				}
			}

			/*
			 * for (int i = 0; i < carList.size(); i++) { s_tcn = carList.get(i).getC_cno();
			 * System.out.println(s_tcn + " " + i);
			 * 
			 * }
			 */
			System.out.println(sumCostUserList + " 11111111111111111111111111111111111111   ChargeTatiAction");
			request.setAttribute("allUserCost", sumCostUserList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "showTati";
	}

}
