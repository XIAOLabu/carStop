package cn.gx.czz.service;

import cn.gx.czz.dao.CostDao;
import cn.gx.czz.dao.impl.CostDaoImpl;
import cn.gx.czz.model.Cost;
import cn.gx.czz.util.AppException;

/**
 * ͣ�����õ�ҵ���߼���
 * 
 * @author ASUS
 *
 */
public class CostService {
	// ��ʼ��ͣ���������ݿ����ʵ�ֲ�
	private CostDao costDao = new CostDaoImpl();

	/**
	 * д��ͣ���շ�����
	 * 
	 * @param cost
	 *            ͣ���շ�ʵ�����
	 * @return
	 * @throws AppException
	 */
	public boolean addCost(Cost cost) throws AppException {
		try {
			boolean flag = false;
			flag = costDao.addCost(cost);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CostService.addCost");
		}

	}

}
