package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 根据车位区域 查询对应的车位号,并返回到前端页面 的Action
 * 
 * @author ASUS
 *
 */
public class WherePosiwcAction extends ActionSupport implements ModelDriven<PosiTion> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private PosiTionService positionService = new PosiTionService();
	private int i;
	private String cw_wz;
	private List<PosiTion> posinoList;
	private PosiTion position = new PosiTion();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public PosiTion getModel() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public String execute() throws AppException {
		try {
			System.out.println(i);
			switch (i) {
			case 1:
				cw_wz = "A区";
				break;
			case 2:
				cw_wz = "B区";
				break;
			case 3:
				cw_wz = "C区";
				break;
			case 4:
				cw_wz = "D区";
				break;
			case 5:
				cw_wz = "E区";
				break;
			}
			posinoList = positionService.selectPostcw_wz(cw_wz);
			request.setAttribute("posinoList", posinoList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "posino";
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getCw_wz() {
		return cw_wz;
	}

	public void setCw_wz(String cw_wz) {
		this.cw_wz = cw_wz;
	}

}
