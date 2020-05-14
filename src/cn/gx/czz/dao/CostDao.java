package cn.gx.czz.dao;

import cn.gx.czz.model.Cost;
import cn.gx.czz.util.AppException;

/**
 * 停车费用数据访问层接口
 * 
 * @author ASUS
 *
 */
public interface CostDao {

	/**
	 * 写入停车收费数据
	 * 
	 * @param cost
	 *            停车收费实体对象
	 * @return
	 * @throws AppException
	 */
	public boolean addCost(Cost cost) throws AppException;

}
