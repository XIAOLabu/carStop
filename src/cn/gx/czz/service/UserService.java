package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.UserDao;
import cn.gx.czz.dao.impl.UserDaoImpl;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.util.AppException;

/**
 * �û�ҵ���߼���
 * 
 * @author ASUS
 *
 */
public class UserService {
	// ��ʼ���û����ݿ����ʵ�ֲ�
	private UserDao userDao = new UserDaoImpl();

	/**
	 * �ж��Ƿ�����
	 * 
	 * @param u_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public boolean isExist(String u_user) throws AppException {
		boolean flag = false;
		try {
			flag = userDao.isExist(u_user);
			System.out.println(flag + "   isExist");
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.isExist");
		}
		return flag;
	}

	/**
	 * �����û����ӣ����ӳɹ�����true,ʧ�ܷ���false. ����������Ϊ����ͬ���û��������Ӳ���ʧ�ܣ�ͳһΪע��ʧ�ܡ�
	 * 
	 * @param user
	 *            �û�����
	 * @return ���ӳɹ�����true ���߷���false
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException {
		boolean flag = false;
		try {
			// ��֤������ͬ���û�
			if (!userDao.isExist(user.getU_user())) {
				// ������ͬ���û�ִ�б������
				flag = userDao.save(user);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.register");
		}
		// ���ӳɹ�������true ,���߷���false
		return flag;
	}

	/**
	 * �����û�ID ��ѯ�û����󣬲�����
	 * 
	 * @param u_id
	 *            �û�ID
	 * @return
	 * @throws AppException
	 */
	public User showid(int u_id) throws AppException {
		User flag = null;
		try {
			User user = userDao.getUser(u_id);
			flag = user;

		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.showid");
		}
		return flag;

	}

	/**
	 * �û���¼
	 * 
	 * @param u_user
	 *            �û���
	 * @param u_pwd
	 *            �û�����
	 * @return
	 * @throws AppException
	 */
	public User login(String u_user, String u_pwd) throws AppException {
		User flag = null;
		try {
			int u_id = userDao.login(u_user, u_pwd);
			if (u_id > 0) {
				// ������ͬid�û�ִ�з����û�����
				User user = userDao.getUser(u_id);
				flag = user;
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.login");
		}
		return flag;
	}

	/**
	 * �����û�������Ϣ����
	 * 
	 * @param u_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUser(String u_user) throws AppException {
		List<User> flag = null;
		// ��ѯ�û���Ϣ
		try {
			flag = userDao.selectUser(u_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.selectUserList");
		}
		return flag;
	}

	/**
	 * ɾ���û���Ϣ
	 * 
	 * @param u_id
	 *            �û�ID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteUser(int u_id) throws AppException {
		try {
			return userDao.deleteUser(u_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.deleteUser");
		}
	}

	/**
	 * �����û�ID��ѯ�û�
	 * 
	 * @param u_id
	 *            �û�ID
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUserId(int u_id) throws AppException {
		List<User> flag = null;
		// ��ѯ�û���Ϣ
		try {
			flag = userDao.selectUserId(u_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.selectUserId");
		}
		return flag;
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return
	 * @throws AppException
	 */
	public boolean updateUser(User user) throws AppException {
		boolean flag = true;
		try {
			flag = userDao.updateUser(user);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.updateUser");
		}
	}

	/**
	 * ��ҳ��ѯ�û���¼
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<User> querPage(Integer pageSize, Integer pageNow) throws AppException {
		try {
			return userDao.querPage(pageSize, pageNow);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.querPage");
		}

	}

	/**
	 * ��ѯȫ���û���Ϣ
	 * 
	 * @return �û���Ϣ����
	 * @throws AppException
	 */
	public List<User> showAllUser() throws AppException {
		try {
			List<User> flag = null;
			flag = userDao.showAllUser();
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.showAllUser");
		}
	}

	/**
	 * ��ѯ�û����������������û���
	 * 
	 * @return
	 * @throws AppException
	 */
	public List<User> chargeUser() throws AppException {
		try {
			return userDao.chargeUser();
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.chargeUser");
		}
	}

	/**
	 * ɾ����������
	 * 
	 * @param uidList
	 *            ��������û�ID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteAllUser(String[] uidList) throws AppException {
		try {
			boolean flag = false;
			flag = userDao.deleteAllUser(uidList);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.deleteAllUser");
		}

	}

}
