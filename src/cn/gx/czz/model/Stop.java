package cn.gx.czz.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 停车计时实体类
 * 
 * @author ASUS
 *
 */
public class Stop {
	private String s_tcn, s_tcw, s_user; // 入场车牌号,停车位置
	private int s_id, s_tcu, s_time; // 停车实体类的ID;车辆用户类型 0 小区用户 1 非小区用户;停车时间;
	private Timestamp s_cit, s_cot; // 入场时间,出场时间
	private BigDecimal s_cost; // 每次停车产生的费用

	/**
	 * 无参构造
	 */
	public Stop() {
		super();
	}

	/**
	 * 有参构造
	 * 
	 * @param s_tcn
	 *            入场车牌号
	 * @param s_tcw
	 *            停车位置
	 * @param s_user
	 *            停车小区车主
	 * @param s_id
	 *            停车实体类的ID
	 * @param s_tcu
	 *            车辆用户类型
	 * @param s_time
	 *            停车时间
	 * @param s_cit
	 *            入场时间
	 * @param s_cot
	 *            出场时间
	 * @param s_cost
	 *            每次停车产生的费用
	 */
	public Stop(String s_tcn, String s_tcw, String s_user, int s_id, int s_tcu, int s_time, Timestamp s_cit,
			Timestamp s_cot, BigDecimal s_cost) {
		super();
		this.s_tcn = s_tcn;
		this.s_tcw = s_tcw;
		this.s_user = s_user;
		this.s_id = s_id;
		this.s_tcu = s_tcu;
		this.s_time = s_time;
		this.s_cit = s_cit;
		this.s_cot = s_cot;
		this.s_cost = s_cost;
	}

	public String getS_tcn() {
		return s_tcn;
	}

	/**
	 * 返回此对象本身
	 */
	@Override
	public String toString() {
		return "Stop [s_tcn=" + s_tcn + ", s_tcw=" + s_tcw + ", s_user=" + s_user + ", s_id=" + s_id + ", s_tcu="
				+ s_tcu + ", s_time=" + s_time + ", s_cit=" + s_cit + ", s_cot=" + s_cot + ", s_cost=" + s_cost + "]";
	}

	public String getS_tcw() {
		return s_tcw;
	}

	public int getS_id() {
		return s_id;
	}

	public int getS_tcu() {
		return s_tcu;
	}

	public int getS_time() {
		return s_time;
	}

	public Timestamp getS_cit() {
		return s_cit;
	}

	public Timestamp getS_cot() {
		return s_cot;
	}

	public BigDecimal getS_cost() {
		return s_cost;
	}

	public void setS_tcn(String s_tcn) {
		this.s_tcn = s_tcn;
	}

	public void setS_tcw(String s_tcw) {
		this.s_tcw = s_tcw;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public void setS_tcu(int s_tcu) {
		this.s_tcu = s_tcu;
	}

	public void setS_time(int s_time) {
		this.s_time = s_time;
	}

	public void setS_cit(Timestamp s_cit) {
		this.s_cit = s_cit;
	}

	public void setS_cot(Timestamp s_cot) {
		this.s_cot = s_cot;
	}

	public void setS_cost(BigDecimal s_cost) {
		this.s_cost = s_cost;
	}

	public String getS_user() {
		return s_user;
	}

	public void setS_user(String s_user) {
		this.s_user = s_user;
	}

}
