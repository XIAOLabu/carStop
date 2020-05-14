package cn.gx.czz.model;

import java.util.Objects;

/**
 * �û�ʵ����
 * 
 * @author ASUS
 */

public class User {
	private String u_user, u_phone, u_pwd, u_sex;// �û������ֻ��ţ����룬�Ա�
	private int u_id, u_del;// �û�����,�û�id 0/1\����Ա/��ͨ�û�

	/**
	 * �вι��췽����Ϊ�������Ը���ʼֵ
	 */
	public User(String u_user, String u_phone, String u_pwd, String u_sex, int u_id, int u_del) {
		super();
		this.u_user = u_user;
		this.u_phone = u_phone;
		this.u_pwd = u_pwd;
		this.u_sex = u_sex;
		this.u_id = u_id;
		this.u_del = u_del;
	}

	/**
	 * �޲ι���
	 */
	public User() {
		super();
	}

	/**
	 * ���ش˶�����
	 */
	@Override
	public String toString() {
		return "User [u_user=" + u_user + ", u_phone=" + u_phone + ", u_pwd=" + u_pwd + ", u_sex=" + u_sex + ", u_id="
				+ u_id + ", u_del=" + u_del + "]";
	}

	/**
	 * ��дequals() ����
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println(obj + "      equals        ");
		// ���Ϊͬһ����Ĳ�ͬ����,�򷵻�true
		if (this == obj) {
			return true;
		}
		// �������Ķ���Ϊ��,�򷵻�false
		if (obj == null) {
			return false;
		}
		// ����������ڲ�ͬ������,�򷵻�false
		if (!(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;
		// �����������u_user, u_phone, u_pwd, u_sex������ȣ�������Ϊ�����������
		if (Objects.equals(u_sex, user.getU_sex()) && Objects.equals(u_user, user.getU_user())
				&& Objects.equals(u_pwd, user.getU_pwd()) && Objects.equals(u_phone, user.getU_phone())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * ��д hashCode() ����
	 */
	@Override
	public int hashCode() {
		int result = u_user.hashCode();
		result = 31 * result + u_sex.hashCode();
		result = 31 * result + u_pwd.hashCode();
		result = 31 * result + u_phone.hashCode();
		return result;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getU_del() {
		return u_del;
	}

	public void setU_del(int u_del) {
		this.u_del = u_del;
	}

	public String getU_user() {
		return u_user;
	}

	public void setU_user(String u_user) {
		this.u_user = u_user;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

}
