package cn.gx.czz.model;

/**
 * 停车位实体类
 * 
 * @author ASUS
 *
 */
public class PosiTion {

	// 字符串型： 车位号,车位位置,购买者,车位状态 .
	private String cw_no, cw_wz, cw_user, cw_state;
	// 整数类形：车位ID,车位类型 0/1/2\私家车位/临时车位/社会公用车位
	private int cw_id, cw_type;

	/**
	 * 无参构造
	 */
	public PosiTion() {
		super();
	}

	/**
	 * 有参构造，为对象属性赋初始值
	 * 
	 * @param cw_no
	 *            车位号
	 * @param cw_wz
	 *            车位位置
	 * @param cw_user
	 *            购买者
	 * @param cw_state
	 *            车位状态
	 * @param cw_id
	 *            车位ID
	 * @param cw_type
	 *            车位类型
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
	 * 返回此对象本身
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
