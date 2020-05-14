package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.MomCostDao;
import cn.gx.czz.dao.impl.MomCostDaoImpl;
import cn.gx.czz.model.MomCost;
import cn.gx.czz.util.AppException;

public class MomCostService {

	private MomCostDao momcostDao = new MomCostDaoImpl();

	public boolean saveData(MomCost momcost) throws AppException {
		try {
			boolean flag = false;
			flag = momcostDao.saveData(momcost);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.MomCostService.saveData");
		}
	}

	/**
	 * 插入时间 查询月表
	 * 
	 * @param sql_date
	 *            每个月的第一天
	 * @param sql_date1
	 *            每个月的最后一天
	 * @return
	 * @throws AppException
	 */
	public List<MomCost> selectDate(java.sql.Date sql_date, java.sql.Date sql_date1) throws AppException {
		try {
			List<MomCost> flag;
			flag = momcostDao.selectDate(sql_date, sql_date1);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.MomCostService.selectDate");
		}
	}

}
