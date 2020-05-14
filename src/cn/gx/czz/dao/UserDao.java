package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.util.AppException;

/**
 * 用户数据访问层接口
 * 
 * @author ASUS
 *
 */
public interface UserDao {

	/**
	 * 查询是否有相同的用户名存在
	 * 
	 * @param u_user
	 *            用户名
	 * @return 有相同的用户名返回true,s否则返回false
	 * @throws AppException
	 */
	public boolean isExist(String u_user) throws AppException;

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 *            用户对象
	 * @return 保存成功返回true,否则返回false
	 * @throws AppException
	 */
	public boolean save(User user) throws AppException;

	/**
	 * 根据用户名，密码查询用户编号
	 * 
	 * @param u_user
	 *            用户名
	 * @param u_pwd
	 *            用户密码
	 * @return 用户编号
	 * @throws AppException
	 */
	public int login(String u_user, String u_pwd) throws AppException;

	/**
	 * 根据用户编号匹配用户
	 * 
	 * @param u_id
	 *            用户编号
	 * @return 查询到匹配用户返回用户对象；否者返回空值
	 * @throws AppException
	 */
	public User getUser(int u_id) throws AppException;

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param u_user
	 *            用户名
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUser(String u_user) throws AppException;

	/**
	 * 根据用户编号删除用户信息
	 * 
	 * @param u_id
	 *            用户ID
	 * @return
	 */
	public boolean deleteUser(int u_id) throws AppException;

	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param u_id
	 *            用户ID
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUserId(int u_id) throws AppException;

	/**
	 * 进行用户信息的更新
	 * 
	 * @param user
	 *            用户名
	 * @return
	 * @throws AppException
	 */
	public boolean updateUser(User user) throws AppException;

	/**
	 * 分页查询
	 * 
	 * @param pageSize
	 *            每一页行数
	 * @param pageNow
	 *            当前页数
	 * @return
	 * @throws AppException
	 */
	public Page<User> querPage(int pageSize, int pageNow) throws AppException;

	public List<User> showAllUser() throws AppException;

	/**
	 * 查询用户表里满足条件的用户名
	 * 
	 * @return
	 * @throws AppException
	 */
	public List<User> chargeUser() throws AppException;

	/**
	 * 删除批量数据
	 * 
	 * @param uidList
	 *            要删除的ID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteAllUser(String[] uidList) throws AppException;

}
