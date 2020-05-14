package cn.gx.czz.web;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ����������ѯͣ��������Action
 * 
 * @author ASUS
 *
 */
public class QueryStopAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private List<Stop> stopList;
	private StopService stopService = new StopService();
	HttpServletRequest request = ServletActionContext.getRequest();
	private Timestamp s_citt; // ��ȡʱ��εĺ�벿��

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	/**
	 * ʵ�ֲ�ѯ����
	 */
	@Override
	public String execute() throws AppException {
		try {
			System.out.println(stop + "477777777777777");
			System.out.println(s_citt + "          4888888888888");
			stopList = stopService.queryStop(stop, s_citt);
			request.setAttribute("stopList", stopList);
			System.out.println(stopList + "                             49");
			return "showQueryStop";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public Timestamp getS_citt() {
		return s_citt;
	}

	public void setS_citt(Timestamp s_citt) {
		this.s_citt = s_citt;
	}

}
