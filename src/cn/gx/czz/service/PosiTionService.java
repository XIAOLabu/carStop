package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.PosiTionDao;
import cn.gx.czz.dao.impl.PosiTionDaoImpl;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.util.AppException;

/**
 * ��λҵ���߼���
 * 
 * @author ASUS
 *
 */
public class PosiTionService {
	// ��ʼ���û����ݿ����ʵ�ֲ�
	private PosiTionDao positionDao = new PosiTionDaoImpl();

	/**
	 * ���������ж�
	 * 
	 * @param cw_no
	 *            ��λ��
	 * @return
	 * @throws AppException
	 */
	public boolean isnoadd(String cw_no) throws AppException {
		boolean flag = true;
		try {
			flag = positionDao.isPosi(cw_no);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.isnoadd");
		}
		return flag;

	}

	/**
	 * �����ӳ�λ���б��浽���ݿ�
	 * 
	 * @param position
	 *            ��λ��Ϣ����
	 * @return
	 * @throws AppException
	 */
	public boolean addseve(PosiTion position) throws AppException {
		boolean flag = false;
		try {
			// �Գ�λ�Ž�����ͬ�ж�
			if (!positionDao.isPosi(position.getCw_no())) {
				flag = positionDao.addPosi(position);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.addseve");
		}
		// ���ӳɹ�������true ,���߷���false
		return flag;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<PosiTion> querPage(Integer pageSize, Integer pageNow) throws AppException {
		try {
			return positionDao.querPage(pageSize, pageNow);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.querPage");
		}

	}

	/**
	 * ���ݳ�λIDɾ���ó�λ����
	 * 
	 * @param cw_id
	 *            ��λID
	 * @return
	 * @throws AppException
	 */
	public boolean deletePosi(int cw_id) throws AppException {
		try {
			return positionDao.deleteUser(cw_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.deletePosi");
		}
	}

	/**
	 * ���ݳ�λID��ѯ��λ������Ϣ
	 * 
	 * @param cw_id
	 *            ��λID
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_id(cw_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_id");
		}
		return flag;
	}

	/**
	 * ���ݳ�λ�û���ѯ��λ������Ϣ
	 * 
	 * @param cw_user
	 *            ��λ�û�
	 * @return
	 */
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_user(cw_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_user");
		}
		return flag;
	}

	/**
	 * ���ݳ�λλ�ò�ѯ��λ������Ϣ
	 * 
	 * @param cw_wz
	 *            ��λλ��
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_wz(cw_wz);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_wz");
		}
		return flag;
	}

	/**
	 * ���ݳ�λ״̬��ѯ��λ������Ϣ
	 * 
	 * @param cw_state
	 *            ��λ״̬
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_state(cw_state);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_state");
		}
		return flag;
	}

	/**
	 * ���ݳ�λ���Ͳ�ѯ��λ������Ϣ
	 * 
	 * @param cw_type
	 *            ��λ����
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_type(cw_type);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_type");
		}
		return flag;
	}

	/**
	 * ��ʵ��������ݸ���
	 * 
	 * @param position
	 *            ��λʵ�����
	 * @return
	 * @throws AppException
	 */
	public boolean updatePosi(PosiTion position) throws AppException {
		boolean flag;
		try {
			flag = positionDao.updatePosi(position);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.updatePosi");
		}

	}

	/**
	 * ���ݴ������ĳ�λ�� �Գ�λ״̬���и��� �������� �����볡ʱ����һ�� ��������ʱ����һ��
	 * 
	 * @param cw_no
	 *            ��λ��
	 * @return
	 * @throws AppException
	 */
	public boolean upcw_state(String cw_no, String cw_state) throws AppException {
		boolean flag = false;
		try {
			flag = positionDao.upcw_state(cw_no, cw_state);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.upcw_state");
		}
		return flag;

	}

	/**
	 * ɾ��ѡ�еĳ�λ��Ϣ
	 * 
	 * @param pidList
	 *            ��λID����
	 * @return
	 * @throws AppException
	 */
	public boolean deleteAllPosi(String[] pidList) throws AppException {
		try {
			boolean flag = false;
			for (String cw_id : pidList) {
				flag = positionDao.deleteUser(Integer.parseInt(cw_id));
			}
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.upcw_state");
		}
	}

}
