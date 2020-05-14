package cn.gx.czz.model;

import java.math.BigDecimal;

/**
 * 保存单个用户的总费用 ——用于收费数据统计
 * 
 * @author ASUS
 *
 */
public class SumCostUser {

	private BigDecimal cu_sum; // 记录用户的总费用
	private String cu_user;
	private int cu_id;

	@Override
	public String toString() {
		return "SumCostUser [cu_sum=" + cu_sum + ", cu_user=" + cu_user + ", cu_id=" + cu_id + "]";
	}

	public SumCostUser() {
		super();
	}

	public SumCostUser(BigDecimal cu_sum, String cu_user, int cu_id) {
		super();
		this.cu_sum = cu_sum;
		this.cu_user = cu_user;
		this.cu_id = cu_id;
	}

	public BigDecimal getCu_sum() {
		return cu_sum;
	}

	public String getCu_user() {
		return cu_user;
	}

	public int getCu_id() {
		return cu_id;
	}

	public void setCu_sum(BigDecimal cu_sum) {
		this.cu_sum = cu_sum;
	}

	public void setCu_user(String cu_user) {
		this.cu_user = cu_user;
	}

	public void setCu_id(int cu_id) {
		this.cu_id = cu_id;
	}

}
