package cn.gx.czz.model;

/**
 * 费率实体类
 * 
 * @author ASUS
 *
 */
public class Mrate {

	private double r_scu, r_scutmp; // 小区用户费用，非小区用户费用

	/**
	 * 无参构造函数
	 */
	public Mrate() {
		super();
	}

	/**
	 * 有参构造
	 * 
	 * @param r_scu
	 *            小区用户费用
	 * @param r_scutmp
	 *            非小区用户费用
	 */
	public Mrate(double r_scu, double r_scutmp) {
		super();
		this.r_scu = r_scu;
		this.r_scutmp = r_scutmp;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "mrate [ r_scu=" + r_scu + ", r_scutmp=" + r_scutmp + "]";
	}

	public double getR_scu() {
		return r_scu;
	}

	public double getR_scutmp() {
		return r_scutmp;
	}

	public void setR_scu(double r_scu) {
		this.r_scu = r_scu;
	}

	public void setR_scutmp(double r_scutmp) {
		this.r_scutmp = r_scutmp;
	}

}
