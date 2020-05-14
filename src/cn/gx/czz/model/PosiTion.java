package cn.gx.czz.model;

/**
 * ͣ��λʵ����
 * 
 * @author ASUS
 *
 */
public class PosiTion {

	// �ַ����ͣ� ��λ��,��λλ��,������,��λ״̬ .
	private String cw_no, cw_wz, cw_user, cw_state;
	// �������Σ���λID,��λ���� 0/1/2\˽�ҳ�λ/��ʱ��λ/��ṫ�ó�λ
	private int cw_id, cw_type;

	/**
	 * �޲ι���
	 */
	public PosiTion() {
		super();
	}

	/**
	 * �вι��죬Ϊ�������Ը���ʼֵ
	 * 
	 * @param cw_no
	 *            ��λ��
	 * @param cw_wz
	 *            ��λλ��
	 * @param cw_user
	 *            ������
	 * @param cw_state
	 *            ��λ״̬
	 * @param cw_id
	 *            ��λID
	 * @param cw_type
	 *            ��λ����
	 */
	public PosiTion(String cw_no, String cw_wz, String cw_user, String cw_state, int cw_id, int cw_type) {
		super();
		this.cw_no = cw_no;
		this.cw_wz = cw_wz;
		this.cw_user = cw_user;
		this.cw_state = cw_state;
		this.cw_id = cw_id;
		this.cw_type = cw_type;
	}

	/**
	 * ���ش˶�����
	 */
	@Override
	public String toString() {
		return "Position [cw_no=" + cw_no + ", cw_wz=" + cw_wz + ", cw_user=" + cw_user + ", cw_state=" + cw_state
				+ ", cw_id=" + cw_id + ", cw_type=" + cw_type + "]";
	}

	public String getCw_no() {
		return cw_no;
	}

	public String getCw_wz() {
		return cw_wz;
	}

	public String getCw_user() {
		return cw_user;
	}

	public String getCw_state() {
		return cw_state;
	}

	public int getCw_id() {
		return cw_id;
	}

	public int getCw_type() {
		return cw_type;
	}

	public void setCw_no(String cw_no) {
		this.cw_no = cw_no;
	}

	public void setCw_wz(String cw_wz) {
		this.cw_wz = cw_wz;
	}

	public void setCw_user(String cw_user) {
		this.cw_user = cw_user;
	}

	public void setCw_state(String cw_state) {
		this.cw_state = cw_state;
	}

	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}

	public void setCw_type(int cw_type) {
		this.cw_type = cw_type;
	}
}
