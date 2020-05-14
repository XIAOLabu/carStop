package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.CarDao;
import cn.gx.czz.dao.impl.CarDaoImpl;
import cn.gx.czz.model.Car;
import cn.gx.czz.util.AppException;

/**
 * ������ҵ���߼���
 * 
 * @author ASUS
 *
 */
public class CarService {
	// ��ʼ���������ݿ����ʵ�ֲ�
	private CarDao carDao = new CarDaoImpl();

	/**
	 * �жϳ����Ƿ���ͬ or �жϸó����Ƿ�����С���̶�����
	 * 
	 * @param c_cno
	 *            ���ƺ���
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
	 * ���г������ӣ����ӳɹ�����true,ʧ�ܷ���false. ����������Ϊ���ڳ�����ͬ�������Ӳ���ʧ�ܣ�ͳһΪ����ʧ��
	 * 
	 * @param car
	 *            ��������
	 * @throws AppException
	 */
	public boolean addsave(Car car) throws AppException {
		boolean flag = false;
		try {
			// ��֤������ͬ���û�
			if (!carDao.isExist(car.getC_cno())) {
				// ������ͬ���û�ִ�б������
				flag = carDao.addsave(car);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.CarService.addsave");
		}
		return flag;

	}

	/**
	 * �����û����� ���س������ݼ���
	 * 
	 * @param c_user
	 *            �û�����
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
	 * �����û�����ID��ѯ������Ϣ�������س�������
	 * 
	 * @param c_cid
	 *            ����ID
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
	 * �����û�����ID��ѯ������Ϣ�������س������󼯺�
	 * 
	 * @param c_cid
	 *            ����ID
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
	 * ��ԭ������Ϣ���и��� �����س�����Ϣ����
	 * 
	 * @param car
	 *            ��������
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
	 * ��ԭ������Ϣ����ɾ��
	 * 
	 * @param c_cid
	 *            ����ID
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
	 * �����û����� ���س������ݶ���
	 * 
	 * @param c_user
	 *            ��������
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
	 * ͨ�����ƺ��� ��ȡ���û��ĳ�����Ϣ
	 * 
	 * @param c_cno
	 *            ���ƺ���
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
