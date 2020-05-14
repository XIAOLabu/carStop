package cn.gx.czz.model;

import java.util.Objects;

/**
 * ����ʵ����
 * 
 * @author ASUS
 *
 */
public class Car {

	private String c_cno, c_csd, c_ccr; // �������룬����Ʒ�ƣ�������ɫ
	private int c_cid; // ����ID
	private String c_user; // �����û�

	/**
	 * �޲ι���
	 */
	public Car() {
		super();
	}

	/**
	 * �вι���
	 * 
	 * @param c_cno
	 *            ��������
	 * @param c_csd
	 *            ����Ʒ��
	 * @param c_ccr
	 *            ������ɫ
	 * @param c_user
	 *            �����û�
	 * @param c_cid
	 *            ����ID
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
	 * ���ش˶�����
	 */
	@Override
	public String toString() {
		return "Car [c_cno=" + c_cno + ", c_csd=" + c_csd + ", c_ccr=" + c_ccr + ", c_cid=" + c_cid + ", c_user="
				+ c_user + "]";
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
		if (!(obj instanceof Car)) {
			return false;
		}

		Car car = (Car) obj;
		// �����������c_ccr, c_cno, c_csd������ȣ�������Ϊ�����������
		if (Objects.equals(c_ccr, car.getC_ccr()) && Objects.equals(c_cno, car.getC_cno())
				&& Objects.equals(c_csd, car.getC_csd())) {
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
