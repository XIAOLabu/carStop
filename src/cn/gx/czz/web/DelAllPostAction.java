package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * ����ɾ��ѡ�г�λ��Action
 * 
 * @author ASUS
 *
 */
public class DelAllPostAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private String[] pidList;
	private String message;
	private PosiTionService posiTionService = new PosiTionService();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			pidList = request.getParameterValues("check");
			for (String s_id : pidList) {
				System.out.println(s_id);
			}
			if (posiTionService.deleteAllPosi(pidList)) {
				message = "ѡ�г�λɾ���ɹ�";
			} else {
				message = "ѡ�г�λɾ��ʧ��";
			}
			System.out.println(message);
			return "delallposi";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String[] getPidList() {
		return pidList;
	}

	public void setPidList(String[] pidList) {
		this.pidList = pidList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
