package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.util.AppException;

/**
 * �û����ݷ��ʲ�ӿ�
 * 
 * @author ASUS
 *
 */
public interface UserDao {

	/**
	 * ��ѯ�Ƿ�����ͬ���û�������
	 * 
	 * @param u_user
	 *            �û���
	 * @return ����ͬ���û�������true,s���򷵻�false
	 * @throws AppException
	 */
	public boolean isExist(String u_user) throws AppException;

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 *            �û�����
	 * @return ����ɹ�����true,���򷵻�false
	 * @throws AppException
	 */
	public boolean save(User user) throws AppException;

	/**
	 * �����û����������ѯ�û����
	 * 
	 * @param u_user
	 *            �û���
	 * @param u_pwd
	 *            �û�����
	 * @return �û����
	 * @throws AppException
	 */
	public int login(String u_user, String u_pwd) throws AppException;

	/**
	 * �����û����ƥ���û�
	 * 
	 * @param u_id
	 *            �û����
	 * @return ��ѯ��ƥ���û������û����󣻷��߷��ؿ�ֵ
	 * @throws AppException
	 */
	public User getUser(int u_id) throws AppException;

	/**
	 * �����û�����ѯ�û���Ϣ
	 * 
	 * @param u_user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUser(String u_user) throws AppException;

	/**
	 * �����û����ɾ���û���Ϣ
	 * 
	 * @param u_id
	 *            �û�ID
	 * @return
	 */
	public boolean deleteUser(int u_id) throws AppException;

	/**
	 * �����û�ID��ѯ�û���Ϣ
	 * 
	 * @param u_id
	 *            �û�ID
	 * @return
	 * @throws AppException
	 */
	public List<User> selectUserId(int u_id) throws AppException;

	/**
	 * �����û���Ϣ�ĸ���
	 * 
	 * @param user
	 *            �û���
	 * @return
	 * @throws AppException
	 */
	public boolean updateUser(User user) throws AppException;

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageNow
	 *            ��ǰҳ��
	 * @return
	 * @throws AppException
	 */
	public Page<User> querPage(int pageSize, int pageNow) throws AppException;

	public List<User> showAllUser() throws AppException;

	/**
	 * ��ѯ�û����������������û���
	 * 
	 * @return
	 * @throws AppException
	 */
	public List<User> chargeUser() throws AppException;

	/**
	 * ɾ����������
	 * 
	 * @param uidList
	 *            Ҫɾ����ID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteAllUser(String[] uidList) throws AppException;

}
