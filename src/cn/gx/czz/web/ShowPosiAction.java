package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * �Գ�λ��Ϣ���з�ҳ��ʾ��action
 * 
 * @author ASUS
 *
 */
public class ShowPosiAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ��ҵ���߼��� ,��ҳ��ѯģ��, ����ǰ�˷������ĵ�ǰҳ�� ,��ȡHttpServletRequest����
	private PosiTionService positionService = new PosiTionService();
	private Page<PosiTion> position;
	private String pageNow;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * ���ղ��� ����ʵ����ķ��� ���յ������ݱ��浽 request�У�������ת���Ĵ���
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (pageNow == null || pageNow.isEmpty()) {
				position = positionService.querPage(5, 1);
				request.setAttribute("posiList", position);
				System.out.println("1: " + position.getPageNow());
			} else {
				position = positionService.querPage(5, Integer.parseInt(pageNow));
				request.setAttribute("posiList", position);
				System.out.println("2: " + position);
			}
			return "showposi";
		} catch (AppException e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

	public Page<PosiTion> getPosition() {
		return position;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPosition(Page<PosiTion> position) {
		this.position = position;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

}
