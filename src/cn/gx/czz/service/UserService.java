package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.UserDao;
import cn.gx.czz.dao.impl.UserDaoImpl;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.util.AppException;

/**
 * 用户业务逻辑类
 * 
 * @author ASUS
 *
 */
public class UserService {
	// 初始化用户数据库访问实现层
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 判断是否重名
	 * 
	 * @param u_user
	 *            用户名
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
	 * 进行用户增加，增加成功返回true,失败返回false. 不区分是因为存在同名用户还是增加操作失败，统一为注册失败。
	 * 
	 * @param user
	 *            用户对象
	 * @return 增加成功返回true 否者返回false
	 * @throws AppException
	 */
	public boolean register(User user) throws AppException {
		boolean flag = false;
		try {
			// 验证不存在同名用户
			if (!userDao.isExist(user.getU_user())) {
				// 不存在同名用户执行保存操作
				flag = userDao.save(user);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.register");
		}
		// 增加成功，返回true ,否者返回false
		return flag;
	}

	/**
	 * 根据用户ID 查询用户对象，并返回
	 * 
	 * @param u_id
	 *            用户ID
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
	 * 用户登录
	 * 
	 * @param u_user
	 *            用户名
	 * @param u_pwd
	 *            用户密码
	 * @return
	 * @throws AppException
	 */
	public User login(String u_user, String u_pwd) throws AppException {
		User flag = null;
		try {
			int u_id = userDao.login(u_user, u_pwd);
			if (u_id > 0) {
				// 不存在同id用户执行返回用户对象
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
	 * 单个用户对象信息处理
	 * 
	 * @param u_user
	 *            用户名
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUser(String u_user) throws AppException {
		List<User> flag = null;
		// 查询用户信息
		try {
			flag = userDao.selectUser(u_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.selectUserList");
		}
		return flag;
	}

	/**
	 * 删除用户信息
	 * 
	 * @param u_id
	 *            用户ID
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
	 * 根据用户ID查询用户
	 * 
	 * @param u_id
	 *            用户ID
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUserId(int u_id) throws AppException {
		List<User> flag = null;
		// 查询用户信息
		try {
			flag = userDao.selectUserId(u_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.UserService.selectUserId");
		}
		return flag;
	}

	/**
	 * 更新用户信息
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
	 * 分页查询用户记录
	 * 
	 * @param pageSize
	 *            每一页行数
	 * @param pageNow
	 *            当前页数
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
	 * 查询全部用户信息
	 * 
	 * @return 用户信息集合
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
	 * 查询用户表里满足条件的用户名
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
	 * 删除批量数据
	 * 
	 * @param uidList
	 *            存回来的用户ID
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
