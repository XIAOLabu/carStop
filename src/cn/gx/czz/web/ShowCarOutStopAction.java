package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * ʵ�ֳ��������ķ�ҳչʾ��Action
 * 
 * @author ASUS
 *
 */
public class ShowCarOutStopAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private StopService stopService = new StopService();
	private Page<Stop> stop;
	private String pageNow;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * ���ղ��� ����ʵ����ķ��� ���յ������ݱ��浽 request�У�������ת���Ĵ���
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (pageNow == null || pageNow.isEmpty()) {
				stop = stopService.querPage(5, 1);
				request.setAttribute("stopList", stop);
			} else {
				stop = stopService.querPage(5, Integer.parseInt(pageNow));
				request.setAttribute("stopList", stop);
			}
			return "showcoststop";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public Page<Stop> getStop() {
		return stop;
	}

	public void setStop(Page<Stop> stop) {
		this.stop = stop;
	}

}
