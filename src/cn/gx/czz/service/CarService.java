package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.CarDao;
import cn.gx.czz.dao.impl.CarDaoImpl;
import cn.gx.czz.model.Car;
import cn.gx.czz.util.AppException;

/**
 * 车辆的业务逻辑类
 * 
 * @author ASUS
 *
 */
public class CarService {
	// 初始化车辆数据库访问实现层
	private CarDao carDao = new CarDaoImpl();

	/**
	 * 判断车牌是否相同 or 判断该车辆是否属于小区固定车辆
	 * 
	 * @param c_cno
	 *            车牌号码
	 * @return
	 * @throws AppException
	 */
	public boolean isExist(String c_cno) throws AppException {
		boolean flag;
		try {
			flag = carDao.isExist(c_cno);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.isExist");
		}
		return flag;
	}

	/**
	 * 进行车辆增加，增加成功返回true,失败返回false. 不区分是因为存在车牌相同还是增加操作失败，统一为增加失败
	 * 
	 * @param car
	 *            车辆对象
	 * @throws AppException
	 */
	public boolean addsave(Car car) throws AppException {
		boolean flag = false;
		try {
			// 验证不存在同名用户
			if (!carDao.isExist(car.getC_cno())) {
				// 不存在同名用户执行保存操作
				flag = carDao.addsave(car);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.addsave");
		}
		return flag;

	}

	/**
	 * 根据用户名字 返回车辆数据集合
	 * 
	 * @param c_user
	 *            用户名字
	 * @return
	 * @throws AppException
	 */
	public List<Car> showCar(String c_user) throws AppException {
		List<Car> flag = null;
		try {
			flag = carDao.showCar(c_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.showCar");
		}
		return flag;
	}

	/**
	 * 根据用户车辆ID查询车辆信息，并返回车辆对象
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public Car showCarid(int c_cid) throws AppException {
		Car flag = null;
		try {
			flag = carDao.showCarid(c_cid);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.showCar");
		}
		return flag;
	}

	/**
	 * 根据用户车辆ID查询车辆信息，并返回车辆对象集合
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public List<Car> upCar(int c_cid) throws AppException {
		List<Car> flag = null;
		try {
			flag = carDao.upCar(c_cid);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.upCar");
		}
		return flag;
	}

	/**
	 * 对原车辆信息进行更新 并返回车辆信息集合
	 * 
	 * @param car
	 *            车辆对象
	 * @return
	 * @throws AppException
	 */
	public Boolean up2Car(Car car) throws AppException {
		Boolean flag = false;
		try {
			flag = carDao.up2Car(car);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.up2Car");
		}
		return flag;

	}

	/**
	 * 对原车辆信息进行删除
	 * 
	 * @param c_cid
	 *            车辆ID
	 * @return
	 * @throws AppException
	 */
	public boolean delCar(int c_cid) throws AppException {
		boolean flag = false;
		try {
			flag = carDao.delCar(c_cid);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.delCar");
		}
		return flag;
	}

	/**
	 * 根据用户名字 返回车辆数据对象
	 * 
	 * @param c_user
	 *            车主名字
	 * @return
	 * @throws AppException
	 */
	public Car queryCar(String c_user) throws AppException {
		try {
			Car flag = null;
			flag = carDao.queryCar(c_user);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.queryCar");
		}
	}

	/**
	 * 通过车牌号码 获取该用户的车辆信息
	 * 
	 * @param c_cno
	 *            车牌号码
	 * @return
	 * @throws AppException
	 */
	public Car addStopUser(String c_cno) throws AppException {
		try {
			Car flag = null;
			flag = carDao.addStopUser(c_cno);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.addStopUser");
		}
	}
}
