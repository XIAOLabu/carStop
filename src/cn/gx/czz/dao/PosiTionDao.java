package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.util.AppException;

/**
 * ��λ���� ���ʽӿ�
 * 
 * @author ASUS
 *
 */
public interface PosiTionDao {

	/**
	 * ����Ƿ��г�λ���ظ�
	 * 
	 * @param cw_no
	 *            ��λ��
	 * @return
	 * @throws AppException
	 */
	public boolean isPosi(String cw_no) throws AppException;

	/**
	 * ������λ��Ϣ
	 * 
	 * @param positon
	 *            ��λ����
	 * @return
	 * @throws AppException
	 */
	public boolean addPosi(PosiTion position) throws AppException;

	/**
	 * ��λ��ҳ��ѯ��ʾ
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<PosiTion> querPage(int pageSize, int pageNow) throws AppException;

	/**
	 * ���ݳ�λIDɾ����λ����
	 * 
	 * @param cw_id
	 *            ��λID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteUser(int cw_id) throws AppException;

	/**
	 * ���ݳ�λID��ѯ��λ������Ϣ �����س�λ���󼯺�
	 * 
	 * @param cw_id
	 *            ��λID
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException;

	/**
	 * ���ݳ�λ�û���ѯ��λ������Ϣ �����س�λ���󼯺�
	 * 
	 * @param cw_user
	 *            ��λ�û�
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException;

	/**
	 * ���ݳ�λ���Ͳ�ѯ��λ������Ϣ �����س�λ���󼯺�
	 * 
	 * @param cw_type
	 *            ��λ����
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException;

	/**
	 * ���ݳ�λ״̬��ѯ��λ������Ϣ �����س�λ���󼯺�
	 * 
	 * @param cw_state
	 *            ��λ״̬
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException;

	/**
	 * ���ݳ�λλ�ò�ѯ��λ������Ϣ �����س�λ���󼯺�
	 * 
	 * @param cw_wz
	 *            ��λλ��
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException;

	/**
	 * �Ի�ȡ���ĳ�λ������и���
	 * 
	 * @param position
	 *            ��λ����ʵ��
	 * @return
	 * @throws AppException
	 */
	public boolean updatePosi(PosiTion position) throws AppException;

	/**
	 * ���ݴ������ĳ�λ�� �Գ�λ״̬���и��� �������� �����볡ʱ����һ�� ��������ʱ����һ��
	 * 
	 * @param cw_no
	 *            ��λ��
	 * @return
	 * @throws AppException
	 */
	public boolean upcw_state(String cw_no, String cw_state) throws AppException;

}
