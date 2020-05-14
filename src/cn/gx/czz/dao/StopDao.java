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
	 * �����볡����
	 * 
	 * @param stop
	 *            ͣ��������Ϣ
	 * @return
	 * @throws AppException
	 */
	public boolean addStop(Stop stop) throws AppException;

	/**
	 * ��ͣ�����ݽ��з�ҳ��ѯ
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<Stop> querPage(Integer pageSize, Integer pageNow) throws AppException;

	/**
	 * ��ͣ�����ݸ���ID����ɾ��
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public boolean delStop(int s_id) throws AppException;

	/**
	 * ����ͣ������ID��ѯͣ����Ϣ��������ͣ�����󼯺�
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public List<Stop> up1Stop(int s_id) throws AppException;

	/**
	 * ��ͣ����������Ϣ���и��´���
	 * 
	 * @param stop
	 *            ͣ������
	 * @return
	 * @throws AppException
	 */
	public Boolean up2Stop(Stop stop) throws AppException;

	/**
	 * ���ݴ��ص�ͣ��ID ��ȡ��ID�Ķ�����Ϣ
	 * 
	 * @param s_id
	 *            ͣ��ID
	 * @return
	 * @throws AppException
	 */
	public Stop selectStop(int s_id) throws AppException;

	/**
	 * ����������ѯͣ����Ϣ
	 * 
	 * @param stop
	 *            ͣ������
	 * @return
	 * @throws AppException
	 */
	public List<Stop> queryStop(Stop stop, Timestamp s_citt) throws AppException;

	/**
	 * ͨ���û��� ��ѯ���û����շ����
	 * 
	 * @param s_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<SumCostUser> chargeCost(String s_user) throws AppException;

	/**
	 * ͨ�������û��� ��ȡ�û�ͣ����������Ϣ
	 * 
	 * @param c_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<SumUserCost> showCnoCostAll(String c_user) throws AppException;

	public List<Stop> selectc_tcn(String c_tcn) throws AppException;

}
