package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Car;
import cn.gx.czz.util.AppException;

/**
 * �������ݷ��ʲ�ӿ�
 * 
 * @author ASUS
 *
 */
public interface CarDao {

	/**
	 * ��ѯ�Ƿ�����ͬ�ĳ��ƺ������ or �жϸó����Ƿ�����С���̶�����
	 * 
	 * @param c_cno
	 *            ���ƺ���
	 * @return
	 * @throws AppException
	 */
	public boolean isExist(String c_cno) throws AppException;

	/**
	 * �Գ�����Ϣ���б���
	 * 
	 * @param car
	 *            ������Ϣ
	 * @return
	 * @throws AppException
	 */
	public boolean addsave(Car car) throws AppException;

	/**
	 * �����û����� ���س�������
	 * 
	 * @param c_user
	 *            �û�����
	 * @return
	 * @throws AppException
	 */
	public List<Car> showCar(String c_user) throws AppException;

	/**
	 * ���ݳ���ID ��ѯ������Ϣ�����س�������
	 * 
	 * @param c_cid
	 *            ����ID
	 * @return
	 * @throws AppException
	 */
	public Car showCarid(int c_cid) throws AppException;

	/**
	 * ���ݳ���ID ��ѯ������Ϣ�����س������󼯺�
	 * 
	 * @param c_cid
	 *            ����ID
	 * @return
	 * @throws AppException
	 */
	public List<Car> upCar(int c_cid) throws AppException;

	/**
	 * ��ԭ������Ϣ���и��� �����س�����Ϣ����
	 * 
	 * @param car
	 *            ������Ϣ����
	 * @return
	 * @throws AppException
	 */
	public Boolean up2Car(Car car) throws AppException;

	/**
	 * �Գ�����Ϣ����ɾ��
	 * 
	 * @param c_cid
	 *            ����ID
	 * @return
	 * @throws AppException
	 */
	public boolean delCar(int c_cid) throws AppException;

	public Car queryCar(String c_user) throws AppException;

	/**
	 * ͨ�����ƺ��� ��ȡ���û��ĳ�����Ϣ
	 * 
	 * @param c_cno
	 *            ���ƺ���
	 * @return
	 * @throws AppException
	 */
	public Car addStopUser(String c_cno) throws AppException;

}
