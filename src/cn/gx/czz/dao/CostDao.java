package cn.gx.czz.dao;

import cn.gx.czz.model.Cost;
import cn.gx.czz.util.AppException;

/**
 * ͣ���������ݷ��ʲ�ӿ�
 * 
 * @author ASUS
 *
 */
public interface CostDao {

	/**
	 * д��ͣ���շ�����
	 * 
	 * @param cost
	 *            ͣ���շ�ʵ�����
	 * @return
	 * @throws AppException
	 */
	public boolean addCost(Cost cost) throws AppException;

}
