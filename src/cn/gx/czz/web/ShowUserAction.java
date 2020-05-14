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
 * �鿴�û���ϢAction
 * 
 * @author ASUS
 *
 */
public class ShowUserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ��ҵ���߼��� ����ҳʵ���ࡣ����ǰ�˷������ĵ�ǰҳ��
	UserService userService = new UserService();
	// �û����󼯺�
	private Page<User> userList;
	private List<User> personalList;
	private User user = new User();
	private int del;
	private String pageNow, message;
	// ����õ�ǰ����Ķ���
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * ���ղ��� ����ʵ����ķ��� ���յ������ݱ��浽 request�У�������ת���Ĵ���
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
				// �����ǰҳΪ�ջ����״�ʹ�ã���pageNowΪ1
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
				System.out.println("ʧ����");
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
