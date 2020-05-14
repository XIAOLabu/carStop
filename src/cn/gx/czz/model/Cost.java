package cn.gx.czz.model;

import java.math.BigDecimal;

/**
 * �ܷ��õ�ʵ����
 * 
 * @author ASUS
 *
 */
public class Cost {
	private String m_cno; // ͣ���ĳ��ƺ���
	private int m_id, m_time; // �շ�ID, ͣ����ʱ��
	private double m_charge; // ͣ���շѹ���
	private BigDecimal m_cost; // ����ͣ���ܷ���

	@Override
	public String toString() {
		return "Cost [m_cno=" + m_cno + ", m_id=" + m_id + ", m_time=" + m_time + ", m_charge=" + m_charge + ", m_cost="
				+ m_cost + "]";
	}

	public Cost(String m_cno, int m_id, int m_time, double m_charge, BigDecimal m_cost) {
		super();
		this.m_cno = m_cno;
		this.m_id = m_id;
		this.m_time = m_time;
		this.m_charge = m_charge;
		this.m_cost = m_cost;
	}

	public Cost() {
		super();
	}

	public String getM_cno() {
		return m_cno;
	}

	public int getM_id() {
		return m_id;
	}

	public int getM_time() {
		return m_time;
	}

	public double getM_charge() {
		return m_charge;
	}

	public BigDecimal getM_cost() {
		return m_cost;
	}

	public void setM_cno(String m_cno) {
		this.m_cno = m_cno;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public void setM_time(int m_time) {
		this.m_time = m_time;
	}

	public void setM_charge(double m_charge) {
		this.m_charge = m_charge;
	}

	public void setM_cost(BigDecimal m_cost) {
		this.m_cost = m_cost;
	}

}
