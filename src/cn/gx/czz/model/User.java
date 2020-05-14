package cn.gx.czz.model;

import java.util.Objects;

/**
 * 用户实体类
 * 
 * @author ASUS
 */

public class User {
	private String u_user, u_phone, u_pwd, u_sex;// 用户名，手机号，密码，性别
	private int u_id, u_del;// 用户类型,用户id 0/1\管理员/普通用户

	/**
	 * 有参构造方法，为对象属性赋初始值
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
	 * 无参构造
	 */
	public User() {
		super();
	}

	/**
	 * 返回此对象本身
	 */
	@Override
	public String toString() {
		return "User [u_user=" + u_user + ", u_phone=" + u_phone + ", u_pwd=" + u_pwd + ", u_sex=" + u_sex + ", u_id="
				+ u_id + ", u_del=" + u_del + "]";
	}

	/**
	 * 重写equals() 方法
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println(obj + "      equals        ");
		// 如果为同一对象的不同引用,则返回true
		if (this == obj) {
			return true;
		}
		// 如果传入的对象为空,则返回false
		if (obj == null) {
			return false;
		}
		// 如果两者属于不同的类型,则返回false
		if (!(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;
		// 如果两个对象u_user, u_phone, u_pwd, u_sex属性相等，我们认为两个对象相等
		if (Objects.equals(u_sex, user.getU_sex()) && Objects.equals(u_user, user.getU_user())
				&& Objects.equals(u_pwd, user.getU_pwd()) && Objects.equals(u_phone, user.getU_phone())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 重写 hashCode() 方法
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
