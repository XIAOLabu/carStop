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
 * �޸��շѷ��ʵ�Action
 * @author ASUS
 *
 */
public class UpChargeRules extends ActionSupport implements ModelDriven<Mrate> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Mrate mrate = new Mrate(); // ǰ�˴�����������
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
			// ����ǰ�˵�ֵ��ʼΪ0 ���Լ�������ж�
			if (mrate.getR_scu() != 0 && mrate.getR_scutmp() != 0) {
				System.out.println("������UpChargeRules 38 ");
				mrateService.up1Mrate(mrate);
				showmrate = mrateService.showMrate();
				request.setAttribute("showmrate", showmrate);
				return "up2chargeRules";
			} else {
				System.out.println("������UpChargeRules 44 ");
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
