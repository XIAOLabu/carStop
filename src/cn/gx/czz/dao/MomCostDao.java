package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.MomCost;
import cn.gx.czz.util.AppException;

/**
 * 月报表数据的访问层接口
 * 
 * @author ASUS
 *
 */
public interface MomCostDao {

	public boolean saveData(MomCost momcost) throws AppException;

	/**
	 * 插入时间 查询月表
	 * 
	 * @param sql_date
	 *            每月第一天
	 * @param sql_date1
	 *            每月最后一天
	 * @return
	 * @throws AppException
	 */
	public List<MomCost> selectDate(java.sql.Date sql_date, java.sql.Date sql_date1) throws AppException;

}
