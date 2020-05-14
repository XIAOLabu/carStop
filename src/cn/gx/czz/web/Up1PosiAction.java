package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * ����cw_id��ѯ��λ ����ת�����³�λ��Ϣҳ���action
 * 
 * @author ASUS
 *
 */
public class Up1PosiAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ��ҵ���߼��࣬��ȡHttpServletRequest���� ��������positionid ��ȡǰ�˴�������
	HttpServletRequest request = ServletActionContext.getRequest();
	private PosiTionService positionService = new PosiTionService();
	private List<PosiTion> positionid;
	private int cw_id;

	/**
	 * ���ݳ�λID��ѯ��λ������ת�����³�λҳ��
	 */
	@Override
	public String execute() throws AppException {
		System.out.println("Up1PosiAction");
		try {
			// ���ε���ѯ������ ��ȡ�����û�����
			positionid = positionService.selectPostcw_id(cw_id);
			// �ѻ�ȡ��ֵ�浽request����
			request.setAttribute("positionid", positionid);
			// ����������ת������ҳ��
			return "selectPosi";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public int getCw_id() {
		return cw_id;
	}

	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}

}
