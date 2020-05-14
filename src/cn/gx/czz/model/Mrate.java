package cn.gx.czz.model;

/**
 * ����ʵ����
 * 
 * @author ASUS
 *
 */
public class Mrate {

	private double r_scu, r_scutmp; // С���û����ã���С���û�����

	/**
	 * �޲ι��캯��
	 */
	public Mrate() {
		super();
	}

	/**
	 * �вι���
	 * 
	 * @param r_scu
	 *            С���û�����
	 * @param r_scutmp
	 *            ��С���û�����
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
