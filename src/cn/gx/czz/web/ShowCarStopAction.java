package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.Stop;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 对停车信息进行分页显示的action
 * 
 * @author ASUS
 *
 */
public class ShowCarStopAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private StopService stopService = new StopService();
	private Page<Stop> stop;
	private String pageNow;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 接收参数 调用实体类的方法 接收到的数据保存到 request中，并进行转发的处理
	 */
	@Override
	public String execute() throws AppException {
		try {
			if (pageNow == null || pageNow.isEmpty()) {
				stop = stopService.querPage(5, 1);
				request.setAttribute("stopList", stop);
				System.out.println("1: " + stop.getPageNow());
			} else {
				stop = stopService.querPage(5, Integer.parseInt(pageNow));
				request.setAttribute("stopList", stop);
				System.out.println("2: " + stop);
			}
			return "showstop";
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
