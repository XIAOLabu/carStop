package cn.gx.czz.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.Stop;
import cn.gx.czz.model.SumCostUser;
import cn.gx.czz.model.SumUserCost;
import cn.gx.czz.util.AppException;

public interface StopDao {

	/**
	 * 增加入场车辆
	 * 
	 * @param stop
	 *            停车对象信息
	 * @return
	 * @throws AppException
	 */
	public boolean addStop(Stop stop) throws AppException;

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
	public Page<Stop> querPage(Integer pageSize, Integer pageNow) throws AppException;

	/**
	 * 对停车数据根据ID进行删除
	 * 
	 * @param s_id
	 *            停车ID
	 * @return
	 * @throws AppException
	 */
	public boolean delStop(int s_id) throws AppException;

	/**
	 * 根据停车车辆ID查询停车信息，并返回停车对象集合
	 * 
	 * @param s_id
	 *            停车ID
	 * @return
	 * @throws AppException
	 */
	public List<Stop> up1Stop(int s_id) throws AppException;

	/**
	 * 对停车车辆的信息进行更新处理
	 * 
	 * @param stop
	 *            停车对象
	 * @return
	 * @throws AppException
	 */
	public Boolean up2Stop(Stop stop) throws AppException;

	/**
	 * 根据传回的停车ID 获取该ID的对象信息
	 * 
	 * @param s_id
	 *            停车ID
	 * @return
	 * @throws AppException
	 */
	public Stop selectStop(int s_id) throws AppException;

	/**
	 * 根据条件查询停车信息
	 * 
	 * @param stop
	 *            停车对象
	 * @return
	 * @throws AppException
	 */
	public List<Stop> queryStop(Stop stop, Timestamp s_citt) throws AppException;

	/**
	 * 通过用户名 查询该用户的收费情况
	 * 
	 * @param s_user
	 *            用户名
	 * @return
	 * @throws AppException
	 */
	public List<SumCostUser> chargeCost(String s_user) throws AppException;

	/**
	 * 通过输入用户名 获取用户停车车辆的信息
	 * 
	 * @param c_user
	 *            用户名
	 * @return
	 * @throws AppException
	 */
	public List<SumUserCost> showCnoCostAll(String c_user) throws AppException;

	public List<Stop> selectc_tcn(String c_tcn) throws AppException;

}
