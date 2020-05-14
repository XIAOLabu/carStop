package cn.gx.czz.model;

import java.util.Objects;

/**
 * 汽车实体类
 * 
 * @author ASUS
 *
 */
public class Car {

	private String c_cno, c_csd, c_ccr; // 车辆号码，车辆品牌，车辆颜色
	private int c_cid; // 车辆ID
	private String c_user; // 车辆用户

	/**
	 * 无参构造
	 */
	public Car() {
		super();
	}

	/**
	 * 有参构造
	 * 
	 * @param c_cno
	 *            车辆号码
	 * @param c_csd
	 *            车辆品牌
	 * @param c_ccr
	 *            车辆颜色
	 * @param c_user
	 *            车辆用户
	 * @param c_cid
	 *            车辆ID
	 */
	public Car(String c_cno, String c_csd, String c_ccr, String c_user, int c_cid) {
		super();
		this.c_cno = c_cno;
		this.c_csd = c_csd;
		this.c_ccr = c_ccr;
		this.c_user = c_user;
		this.c_cid = c_cid;
	}

	/**
	 * 返回此对象本身
	 */
	@Override
	public String toString() {
		return "Car [c_cno=" + c_cno + ", c_csd=" + c_csd + ", c_ccr=" + c_ccr + ", c_cid=" + c_cid + ", c_user="
				+ c_user + "]";
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
		if (!(obj instanceof Car)) {
			return false;
		}

		Car car = (Car) obj;
		// 如果两个对象c_ccr, c_cno, c_csd属性相等，我们认为两个对象相等
		if (Objects.equals(c_ccr, car.getC_ccr()) && Objects.equals(c_cno, car.getC_cno())
				&& Objects.equals(c_csd, car.getC_csd())) {
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
		int result = c_ccr.hashCode();
		result = 31 * result + c_cno.hashCode();
		result = 31 * result + c_csd.hashCode();
		return result;
	}

	public String getC_cno() {
		return c_cno;
	}

	public String getC_csd() {
		return c_csd;
	}

	public String getC_ccr() {
		return c_ccr;
	}

	public int getC_cid() {
		return c_cid;
	}

	public void setC_cno(String c_cno) {
		this.c_cno = c_cno;
	}

	public void setC_csd(String c_csd) {
		this.c_csd = c_csd;
	}

	public void setC_ccr(String c_ccr) {
		this.c_ccr = c_ccr;
	}

	public void setC_cid(int c_cid) {
		this.c_cid = c_cid;
	}

	public String getC_user() {
		return c_user;
	}

	public void setC_user(String c_user) {
		this.c_user = c_user;
	}

}
