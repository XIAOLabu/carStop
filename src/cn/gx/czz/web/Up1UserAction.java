package cn.gx.czz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.User;
import cn.gx.czz.service.UserService;
import cn.gx.czz.util.AppException;

/**
 * ����id��ѯ�û� ����ת�������û���Ϣҳ���action
 *
 * @author ASUS
 *
 */
public class Up1UserAction extends ActionSupport {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	// ��ʼ���û�ҵ���߼��࣬��ȡHttpServletRequest����
	private UserService userService = new UserService();
	HttpServletRequest request = ServletActionContext.getRequest();
	List<User> userid;
	private int u_id;

	/**
	 * �����û�id��ѯ�û�������ת�������û�ҳ��
	 */
	@Override
	public String execute() throws AppException {
		try {
			// ���ε���ѯ������ ��ȡ�����û�����
			System.out.println(u_id);
			userid = userService.selectUserId(u_id);
			// �ѻ�ȡ��ֵ�浽request����
			request.setAttribute("userid", userid);
			// ����������ת������ҳ��
			return "selectUser";
		} catch (AppException e) {
			// ϵͳ�쳣����ת���쳣ҳ��
			e.printStackTrace();
			return "error";
		}

	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<User> getUserid() {
		return userid;
	}

	public void setUserid(List<User> userid) {
		this.userid = userid;
	}

}
