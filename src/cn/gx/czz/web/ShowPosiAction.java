package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.util.AppException;

/**
 * 对车位信息进行分页显示的action
 * 
 * @author ASUS
 *
 */
public class ShowPosiAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化业务逻辑类 ,分页查询模板, 接收前端返回来的当前页数 ,获取HttpServletRequest对象
	private PosiTionService positionService = new PosiTionService();
	private Page<PosiTion> position;
	private String pageNow;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 接收参数 调用实体类的方法 接收到的数据保存到 request中，并进行转发的处理
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
