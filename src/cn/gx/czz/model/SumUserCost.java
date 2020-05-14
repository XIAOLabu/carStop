package cn.gx.czz.model;

import java.math.BigDecimal;

/**
 * 某个用户的具体车辆的消费记录总汇
 * 
 * @author ASUS
 *
 */
public class SumUserCost {
	private BigDecimal sum_cost;
	private int sum_time;
	private String s_tcn, s_user;

	public SumUserCost(BigDecimal sum_cost, int sum_time, String s_tcn, String s_user) {
		super();
		this.sum_cost = sum_cost;
		this.sum_time = sum_time;
		this.s_tcn = s_tcn;
		this.s_user = s_user;
	}

	public SumUserCost() {
		super();
	}

	@Override
	public String toString() {
		return "SumUserCost [sum_cost=" + sum_cost + ", sum_time=" + sum_time + ", s_tcn=" + s_tcn + ", s_user="
				+ s_user + "]";
	}

	public BigDecimal getSum_cost() {
		return sum_cost;
	}

	public int getSum_time() {
		return sum_time;
	}

	public String getS_tcn() {
		return s_tcn;
	}

	public String getS_user() {
		return s_user;
	}

	public void setSum_cost(BigDecimal sum_cost) {
		this.sum_cost = sum_cost;
	}

	public void setSum_time(int sum_time) {
		this.sum_time = sum_time;
	}

	public void setS_tcn(String s_tcn) {
		this.s_tcn = s_tcn;
	}

	public void setS_user(String s_user) {
		this.s_user = s_user;
	}

}
