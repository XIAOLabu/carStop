package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Mrate;
import cn.gx.czz.service.MrateService;
import cn.gx.czz.util.AppException;

/**
 * 修改收费费率的Action
 * @author ASUS
 *
 */
public class UpChargeRules extends ActionSupport implements ModelDriven<Mrate> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private Mrate mrate = new Mrate(); // 前端传回来的数据
	private List<Mrate> showmrate;
	private MrateService mrateService = new MrateService();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public Mrate getModel() {
		// TODO Auto-generated method stub
		return mrate;
	}

	@Override
	public String execute() throws AppException {
		try {
			// 由于前端的值开始为0 所以加了这个判断
			if (mrate.getR_scu() != 0 && mrate.getR_scutmp() != 0) {
				System.out.println("运行了UpChargeRules 38 ");
				mrateService.up1Mrate(mrate);
				showmrate = mrateService.showMrate();
				request.setAttribute("showmrate", showmrate);
				return "up2chargeRules";
			} else {
				System.out.println("运行了UpChargeRules 44 ");
				showmrate = mrateService.showMrate();
				request.setAttribute("showmrate", showmrate);
				return "upchargeRules";
			}

		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
