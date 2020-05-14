package cn.gx.czz.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * ͣ����ʱʵ����
 * 
 * @author ASUS
 *
 */
public class Stop {
	private String s_tcn, s_tcw, s_user; // �볡���ƺ�,ͣ��λ��
	private int s_id, s_tcu, s_time; // ͣ��ʵ�����ID;�����û����� 0 С���û� 1 ��С���û�;ͣ��ʱ��;
	private Timestamp s_cit, s_cot; // �볡ʱ��,����ʱ��
	private BigDecimal s_cost; // ÿ��ͣ�������ķ���

	/**
	 * �޲ι���
	 */
	public Stop() {
		super();
	}

	/**
	 * �вι���
	 * 
	 * @param s_tcn
	 *            �볡���ƺ�
	 * @param s_tcw
	 *            ͣ��λ��
	 * @param s_user
	 *            ͣ��С������
	 * @param s_id
	 *            ͣ��ʵ�����ID
	 * @param s_tcu
	 *            �����û�����
	 * @param s_time
	 *            ͣ��ʱ��
	 * @param s_cit
	 *            �볡ʱ��
	 * @param s_cot
	 *            ����ʱ��
	 * @param s_cost
	 *            ÿ��ͣ�������ķ���
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
	 * ���ش˶�����
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
