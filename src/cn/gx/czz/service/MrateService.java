package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.MrateDao;
import cn.gx.czz.dao.impl.MrateDaoImpl;
import cn.gx.czz.model.Mrate;
import cn.gx.czz.util.AppException;

public class MrateService {

	// ��ʼ�����ݿ����ʵ�ֲ�
	private MrateDao mrateDao = new MrateDaoImpl();

	/**
	 * 
	 * �����շѱ�׼
	 * 
	 * @param mrate
	 *            �շ�ʵ����
	 * @return
	 * @throws AppException
	 */
	public List<Mrate> showMrate() throws AppException {
		try {
			List<Mrate> flag = null;
			flag = mrateDao.showMrate();
			System.out.println(flag + "          upMrate");
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.MrateService.upMrate");
		}
	}

	public boolean up1Mrate(Mrate mrate) throws AppException {
		try {
			boolean flag = false;
			flag = mrateDao.up1Mrate(mrate);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.MrateService.up1Mrate");
		}

	}

	public Mrate showMrateObj() throws AppException {
		try {
			Mrate flag = null;
			flag = mrateDao.showMrateObj();
			System.out.println(flag + "          upMrate");
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.MrateService.showMrateObj");
		}
	}

}
