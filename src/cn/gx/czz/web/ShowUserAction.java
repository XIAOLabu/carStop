package cn.gx.czz.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * 查看用户信息Action
 * 
 * @author ASUS
 *
 */
public class ShowUserAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	// 初始化业务逻辑类 。分页实体类。接收前端返回来的当前页数
	UserService userService = new UserService();
	// 用户对象集合
	private Page<User> userList;
	private List<User> personalList;
	private User user = new User();
	private int del;
	private String pageNow, message;
	// 来获得当前请求的对象
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 接收参数 调用实体类的方法 接收到的数据保存到 request中，并进行转发的处理
	 */
	@Override
	public String execute() throws AppException {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			del = (int) session.get("u_del");
			user = (User) session.get("user");
			switch (del) {
			case 1:
				// 如果当前页为空或者首次使用，则pageNow为1
				if (pageNow == null || pageNow.isEmpty()) {
					userList = userService.querPage(5, 1);
					request.setAttribute("userList", userList);
				} else {
					userList = userService.querPage(5, Integer.parseInt(pageNow));
					request.setAttribute("userList", userList);
				}
				break;
			case 0:
				personalList = userService.selectUserId(user.getU_id());
				System.out.println(personalList + " 64");
				request.setAttribute("personalList", personalList);
				break;

			default:
				System.out.println("失败啦");
				break;
			}
			if (del != 0) {
				return "myUser";
			} else {
				return "myUser1";
			}
			// message = (String) request.getSession().getAttribute("Up2message");
		} catch (AppException e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

	public Page<User> getUserList() {
		return userList;
	}

	public void setUserList(Page<User> userList) {
		this.userList = userList;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

}
