package cn.gx.czz.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 删除选中用户action
 * 
 * @author ASUS
 *
 */
public class DelAllUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private String[] uidList;
	private UserService userService = new UserService();
	HttpServletRequest request = ServletActionContext.getRequest();

	@Override
	public String execute() throws AppException {
		try {
			uidList = request.getParameterValues("id[]");
			/*
			 * for (String id : request.getParameterValues("id[]")) {
			 * System.out.println(Integer.parseInt(id)); }
			 */
			userService.deleteAllUser(uidList);
			return "delAllUser";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String[] getUidList() {
		return uidList;
	}

	public void setUidList(String[] uidList) {
		this.uidList = uidList;
	}

}
