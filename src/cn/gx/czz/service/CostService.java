package cn.gx.czz.service;

import cn.gx.czz.dao.CostDao;
import cn.gx.czz.dao.impl.CostDaoImpl;
import cn.gx.czz.model.Cost;
import cn.gx.czz.util.AppException;

/**
 * 停车费用的业务逻辑类
 * 
 * @author ASUS
 *
 */
public class CostService {
	// 初始化停车费用数据库访问实现层
	private CostDao costDao = new CostDaoImpl();

	/**
	 * 写入停车收费数据
	 * 
	 * @param cost
	 *            停车收费实体对象
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
