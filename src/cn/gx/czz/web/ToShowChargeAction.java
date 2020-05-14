package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Mrate;
import cn.gx.czz.service.MrateService;
import cn.gx.czz.util.AppException;

/**
 * 配置查看收费规则的Action
 * 
 * @author ASUS
 *
 */
public class ToShowChargeAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private MrateService mrateService = new MrateService();
	private List<Mrate> MrateList;
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			MrateList = mrateService.showMrate();
			System.out.println(MrateList + "配置查看收费规则的ActionToShowChargeAction");
			request.setAttribute("MrateList", MrateList);
			return "toShowCharge";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
