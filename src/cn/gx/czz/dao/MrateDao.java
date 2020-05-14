package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Mrate;
import cn.gx.czz.util.AppException;

/**
 * 收费数据访问层接口
 * 
 * @author ASUS
 *
 */
public interface MrateDao {

	/**
	 * 返回对象的集合
	 * 
	 * @return
	 * @throws AppException
	 */
	public List<Mrate> showMrate() throws AppException;

	/**
	 * 更新收费标准
	 * 
	 * @param mrate
	 *            收费实体类
	 * @return
	 * @throws AppException
	 */
	public boolean up1Mrate(Mrate mrate) throws AppException;

	/**
	 * 返回对象
	 * 
	 * @return
	 * @throws AppException
	 */
	public Mrate showMrateObj() throws AppException;
}
