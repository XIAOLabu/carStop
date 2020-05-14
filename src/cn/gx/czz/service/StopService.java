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
 * 停车业务逻辑类
 * 
 * @author ASUS
 *
 */
public class StopService {
	// 初始化数据库访问实现层
	private StopDao stopDao = new StopDaoImpl();

	/**
	 * 增加入场车辆
	 * 
	 * @param stop
	 *            停车对象信息
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
	 * 对停车数据进行分页查询
	 * 
	 * @param pageSize
	 *            每一页行数
	 * @param pageNow
	 *            当前页数
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
	 * 对停车数据根据ID进行删除
	 * 
	 * @param s_id
	 *            停车ID
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
	 * 根据停车车辆ID查询停车信息，并返回停车对象集合
	 * 
	 * @param s_id
	 *            停车ID
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
	 * 对停车车辆的信息进行更新处理
	 * 
	 * @param stop
	 *            停车车辆对象
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
	 * 根据传回的停车ID 获取该ID的对象信息
	 * 
	 * @param s_id
	 *            停车ID
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
	 * 根据条件查询停车信息
	 * 
	 * @param stop
	 *            停车对象
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
	 * 通过用户名 查询该用户的收费情况
	 * 
	 * @param s_user
	 *            用户名
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
	 * 通过输入用户名 获取用户停车车辆的信息
	 * 
	 * @param c_user
	 *            用户名
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
	 * 删除选中的车位信息
	 * 
	 * @param pidList
	 *            车位ID集合
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
