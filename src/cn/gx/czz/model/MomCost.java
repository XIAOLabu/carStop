package cn.gx.czz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建存储月报表元素的实体类
 * 
 * @author ASUS
 *
 */
public class MomCost {
	private String mc_week; // 申明变量星期
	private Date mc_time;
	private BigDecimal mc_icost, mc_zcost, mc_sumcost; // 小区用户收费, 非小区用户收费,总收费

	public MomCost(String mc_week, Date mc_time, BigDecimal mc_icost, BigDecimal mc_zcost, BigDecimal mc_sumcost) {
		super();
		this.mc_week = mc_week;
		this.mc_time = mc_time;
		this.mc_icost = mc_icost;
		this.mc_zcost = mc_zcost;
		this.mc_sumcost = mc_sumcost;
	}

	public MomCost() {
		super();
	}

	@Override
	public String toString() {
		return "MomCost [mc_week=" + mc_week + ", mc_time=" + mc_time + ", mc_icost=" + mc_icost + ", mc_zcost="
				+ mc_zcost + ", mc_sumcost=" + mc_sumcost + "]";
	}

	public String getMc_week() {
		return mc_week;
	}

	public BigDecimal getMc_icost() {
		return mc_icost;
	}

	public BigDecimal getMc_zcost() {
		return mc_zcost;
	}

	public BigDecimal getMc_sumcost() {
		return mc_sumcost;
	}

	public void setMc_week(String mc_week) {
		this.mc_week = mc_week;
	}

	public void setMc_icost(BigDecimal mc_icost) {
		this.mc_icost = mc_icost;
	}

	public void setMc_zcost(BigDecimal mc_zcost) {
		this.mc_zcost = mc_zcost;
	}

	public void setMc_sumcost(BigDecimal mc_sumcost) {
		this.mc_sumcost = mc_sumcost;
	}

	public Date getMc_time() {
		return mc_time;
	}

	public void setMc_time(Date mc_time) {
		this.mc_time = mc_time;
	}

}
