package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * ����cw_idɾ����λaction
 * 
 * @author ASUS
 *
 */
public class DelPosiAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ȡHttpServletRequest���� ��ʼ��cw_id ����������λҵ����
	HttpServletRequest request = ServletActionContext.getRequest();
	private int cw_id;
	private PosiTionService positionService = new PosiTionService();

	/**
	 * ����λɾ�����ܺ���ת
	 */
	@Override
	public String execute() throws AppException {

		try {
			positionService.deletePosi(cw_id);
		} catch (AppException e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return "delposi";
	}

	public int getCw_id() {
		return cw_id;
	}

	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}

}
