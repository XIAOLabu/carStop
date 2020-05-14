package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Mrate;
import cn.gx.czz.util.AppException;

/**
 * �շ����ݷ��ʲ�ӿ�
 * 
 * @author ASUS
 *
 */
public interface MrateDao {

	/**
	 * ���ض���ļ���
	 * 
	 * @return
	 * @throws AppException
	 */
	public List<Mrate> showMrate() throws AppException;

	/**
	 * �����շѱ�׼
	 * 
	 * @param mrate
	 *            �շ�ʵ����
	 * @return
	 * @throws AppException
	 */
	public boolean up1Mrate(Mrate mrate) throws AppException;

	/**
	 * ���ض���
	 * 
	 * @return
	 * @throws AppException
	 */
	public Mrate showMrateObj() throws AppException;
}
