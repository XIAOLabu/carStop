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
 * ��ͣ��������Ϣ���и��µ�Action1 ʵ�ֲ�ѯ���ض�����Ϣ
 * 
 * @author ASUS
 *
 */
public class Up1StopCarAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop();
	private List<Stop> stopUpList;
	private StopService stopService = new StopService();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	/**
	 * ������
	 */
	@Override
	public String execute() throws AppException {
		try {
			System.out.println("                                                   ���е�����");
			stopUpList = stopService.up1Stop(stop.getS_id());
			request.setAttribute("stopUpList", stopUpList);
			return "up1Stop";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
