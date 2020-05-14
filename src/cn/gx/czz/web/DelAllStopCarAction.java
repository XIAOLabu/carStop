package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ����ɾ��ѡ��ͣ����Ϣ��Action
 * 
 * @author ASUS
 *
 */
public class DelAllStopCarAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private String[] sidList;
	private String message;
	private StopService stopService = new StopService();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			sidList = request.getParameterValues("id[]");
			System.out.println(sidList);
			for (String sid : sidList) {
				System.out.println(Integer.parseInt(sid));
			}
			if (stopService.delAllStop(sidList)) {
				message = "ɾ��ѡ���볡���������ɹ�";
			} else {
				message = "ɾ��ѡ���볡��������ʧ��";
			}
			System.out.println(message);
			return "delAllStop";
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

	public String[] getSidList() {
		return sidList;
	}

	public void setSidList(String[] sidList) {
		this.sidList = sidList;
	}

}
