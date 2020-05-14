package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Car;
import cn.gx.czz.util.AppException;

/**
 * 车辆数据访问层接口
 * 
 * @author ASUS
 *
 */
public interface CarDao {

	/**
	 * 查询是否有相同的车牌号码存在 or 判断该车辆是否属于小区固定车辆
	 * 
	 * @param c_cno
	 *            车牌号码
	 * @return
	 * @throws AppException
	 */
	public boolean isExist(String c_cno) throws AppException;

	/**
	 * 对车辆信息进行保存
	 * 
	 * @param car
	 *            车辆信息
	 * @return
	 * @throws AppException
	 */
	public boolean addsave(Car car) throws AppException;

	/**
	 * 根据用户名字 返回车辆数据
	 * 
	 * @param c_user
	 *            用户名字
	 * @return
	 * @throws AppException
	 */
	public List<Car> showCar(String c_user) throws AppException;

	/**
	 * 根据车辆ID 查询车辆信息并返回车辆对象
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public Car showCarid(int c_cid) throws AppException;

	/**
	 * 根据车辆ID 查询车辆信息并返回车辆对象集合
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public List<Car> upCar(int c_cid) throws AppException;

	/**
	 * 对原车辆信息进行更新 并返回车辆信息集合
	 * 
	 * @param car
	 *            车辆信息对象
	 * @return
	 * @throws AppException
	 */
	public Boolean up2Car(Car car) throws AppException;

	/**
	 * 对车辆信息进行删除
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public boolean delCar(int c_cid) throws AppException;

	public Car queryCar(String c_user) throws AppException;

	/**
	 * 通过车牌号码 获取该用户的车辆信息
	 * 
	 * @param c_cno
	 *            车牌号码
	 * @return
	 * @throws AppException
	 */
	public Car addStopUser(String c_cno) throws AppException;

}
