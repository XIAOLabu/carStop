package cn.gx.czz.service;

import java.sql.Timestamp;
import java.util.List;

import cn.gx.czz.dao.StopDao;
import cn.gx.czz.dao.impl.StopDaoImpl;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.Stop;
import cn.gx.czz.model.SumCostUser;
import cn.gx.czz.model.SumUserCost;
import cn.gx.czz.util.AppException;

/**
 * ͣ��ҵ���߼���
 * 
 * @author ASUS
 *
 */
public class StopService {
	// ��ʼ�����ݿ����ʵ�ֲ�
	private StopDao stopDao = new StopDaoImpl();

	/**
	 * �����볡����
	 * 
	 * @param stop
	 *            ͣ��������Ϣ
	 */
	public Boolean addStop(Stop stop) throws AppException {
		try {
			boolean flag = false;
			flag = stopDao.addStop(stop);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.addStop");
		}

	}

	/**
	 * ��ͣ�����ݽ��з�ҳ��ѯ
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<Stop> querPage(Integer pageSize, Integer pageNow) throws AppException {
		try {
			return stopDao.querPage(pageSize, pageNow);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.querPage");
		}
	}

	/**
	 * ��ͣ�����ݸ���ID����ɾ��
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public boolean delStop(int s_id) throws AppException {
		try {
			boolean flag = false;
			flag = stopDao.delStop(s_id);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.delStop");
		}
	}

	/**
	 * ����ͣ������ID��ѯͣ����Ϣ��������ͣ�����󼯺�
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public List<Stop> up1Stop(int s_id) throws AppException {
		try {
			List<Stop> flag;
			flag = stopDao.up1Stop(s_id);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.up1Stop");
		}

	}

	/**
	 * ��ͣ����������Ϣ���и��´���
	 * 
	 * @param stop
	 *            ͣ����������
	 * @return
	 * @throws AppException
	 */
	public boolean up2Stop(Stop stop) throws AppException {
		try {
			Boolean flag = stopDao.up2Stop(stop);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.up2Stop");
		}

	}

	/**
	 * ���ݴ��ص�ͣ��ID ��ȡ��ID�Ķ�����Ϣ
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public Stop selectStop(int s_id) throws AppException {
		try {
			Stop flag = null;
			flag = stopDao.selectStop(s_id);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.selectStop");
		}
	}

	/**
	 * ����������ѯͣ����Ϣ
	 * 
	 * @param stop
	 *            ͣ������
	 * @return
	 * @throws AppException
	 */
	public List<Stop> queryStop(Stop stop, Timestamp s_citt) throws AppException {
		System.out.println("run queryStop");
		try {
			List<Stop> flag = null;
			flag = stopDao.queryStop(stop, s_citt);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.queryStop");
		}
	}

	/**
	 * ͨ���û��� ��ѯ���û����շ����
	 * 
	 * @param s_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<SumCostUser> chargeCost(String s_user) throws AppException {
		try {
			return stopDao.chargeCost(s_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.chargeCost");
		}

	}

	/**
	 * ͨ�������û��� ��ȡ�û�ͣ����������Ϣ
	 * 
	 * @param c_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<SumUserCost> showCnoCostAll(String c_user) throws AppException {
		try {
			return stopDao.showCnoCostAll(c_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.showCnoCostAll");
		}

	}

	/**
	 * ɾ��ѡ�еĳ�λ��Ϣ
	 * 
	 * @param pidList
	 *            ��λID����
	 * @return
	 * @throws AppException
	 */
	public boolean delAllStop(String[] pidList) throws AppException {
		try {
			boolean flag = false;
			for (String s_id : pidList) {
				flag = stopDao.delStop(Integer.parseInt(s_id));
			}
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.delAllStop");
		}
	}

	public List<Stop> selectc_tcn(String c_tcn) throws AppException{
		try {
			List<Stop> flag = null;
			flag = stopDao.selectc_tcn(c_tcn);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.StopService.selectc_tcn");
		}
	}

}
