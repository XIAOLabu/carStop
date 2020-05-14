package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.MomCost;
import cn.gx.czz.util.AppException;

/**
 * �±������ݵķ��ʲ�ӿ�
 * 
 * @author ASUS
 *
 */
public interface MomCostDao {

	public boolean saveData(MomCost momcost) throws AppException;

	/**
	 * ����ʱ�� ��ѯ�±�
	 * 
	 * @param sql_date
	 *            ÿ�µ�һ��
	 * @param sql_date1
	 *            ÿ�����һ��
	 * @return
	 * @throws AppException
	 */
	public List<MomCost> selectDate(java.sql.Date sql_date, java.sql.Date sql_date1) throws AppException;

}
