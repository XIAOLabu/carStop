package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.UserDao;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.User;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * �û����ݷ��ʲ�ʵ����
 * 
 * @author ASUS
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * ʵ�ָù��ܷ���--��ѯ�Ƿ�����ͬ���û�������
	 */
	@Override
	public boolean isExist(String u_user) throws AppException {
		// ������־
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺�����û�����ѯ�û���ţ�"?"Ϊռλ����
			String sql = "select u_id from t_user where u_user =?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setString(1, u_user);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ��ѯ����¼�����û����Ѵ��ڡ�flagΪtrue
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.isExist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.isExist");
		} finally {
			// �ر����ݿ�����
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ʵ�ָù��ܷ���--�����û���Ϣ
	 */
	@Override
	public boolean save(User user) throws AppException {
		// ��ǣ������ɹ�Ϊtrue,ʧ��Ϊfalse
		boolean flag = false;
		// �ж��û�������Ϊ�գ��򲻽��б������
		if (user == null) {
			return flag;
		}
		// �������ݿ����Ӷ���Ԥ�������
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺���û���Ϣ���浽���ݿ��У�"?"Ϊռλ����
			String sql = "insert into t_user(u_user, u_phone, u_pwd,u_sex,u_del)" + "values(?,?,?,?,?)";
			System.out.println("�����û���" + sql);
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setString(1, user.getU_user());
			psmt.setString(2, user.getU_phone());
			psmt.setString(3, user.getU_pwd());
			psmt.setString(4, user.getU_sex());
			psmt.setInt(5, (int) user.getU_del());
			// ִ�и��²�����������Ӱ������
			int count = psmt.executeUpdate();
			// �����Ӱ�����������㣬������ɹ�
			if (count > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.save");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.save");
		} finally {
			// �ر����ݿ�����
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);

		}
		return flag;
	}

	/**
	 * �����û������û����룬��ѯ�û����
	 */
	@Override
	public int login(String u_user, String u_pwd) throws AppException {
		// �û����
		int u_id = 0;
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺�����û�����ѯ�û���ţ���Ϊռλ��
			String sql = "select u_id from t_user where u_user=? and u_pwd=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setString(1, u_user);
			psmt.setString(2, u_pwd);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ��ѯ����¼����ȡ�û����
			if (rs.next()) {
				u_id = rs.getInt("u_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.login");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.login");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return u_id;
	}

	/**
	 * �����û�ID, ʵ�ֻ�ȡ�û���Ϣ���� ----��������
	 * 
	 */
	@Override
	public User getUser(int u_id) throws AppException {
		// �����û�����
		User user = null;
		// �������ݿ����Ӷ���Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬�����û����������ѯƥ�䵽�û���Ϣ����Ϊռλ��
			String sql = "select * from t_user where u_id=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setInt(1, u_id);
			// ��ѯ�����
			rs = psmt.executeQuery();
			// ����ѯ�������ʱʹ��Userʵ����󱣴��û���Ϣ
			if (rs.next()) {
				user = new User();
				user.setU_id(rs.getInt("u_id"));
				user.setU_del(rs.getInt("u_del"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_pwd(rs.getString("u_pwd"));
				user.setU_sex(rs.getString("u_sex"));
				user.setU_user(rs.getString("u_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.getUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.getUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return user;
	}

	/**
	 * �����û�����ȡ�û���Ϣ
	 */
	@Override
	public List<User> selectUser(String u_user) throws AppException {
		System.out.println("������selectUser");
		// ��ʼ���û�����
		List<User> userList = new ArrayList<User>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯ�û���������Ϣ
			String sql = "select * from t_user where u_user=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setString(1, u_user);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��userʵ���У���ʹ��userLiser����
			while (rs.next()) {
				User user = new User();
				user.setU_id(rs.getInt("u_id"));
				user.setU_del(rs.getInt("u_del"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_pwd(rs.getString("u_pwd"));
				user.setU_sex(rs.getString("u_sex"));
				user.setU_user(rs.getString("u_user"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.findByUserId");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.findByUserId");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public boolean deleteUser(int u_id) throws AppException {
		// ������־
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		System.out.println(u_id);
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺�����û����ɾ���û���"?"Ϊռλ����
			String sql = "delete from t_user where u_id = ?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setInt(1, u_id);
			// �ǵ��ɹ��������ݵ����ݿ�ʱ������᷵��һ������1������
			rs = psmt.executeUpdate();

			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.isExist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.isExist");
		} finally {
			// �ر����ݿ�����
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
			DBUtil.closeResultSet(null);
		}
		return flag;
	}

	/**
	 * �����û�ID��ѯ�û���Ϣ���������û���Ϣ-----------��������
	 */
	@Override
	public List<User> selectUserId(int u_id) throws AppException {
		// ��ʼ���û�����
		List<User> userList = new ArrayList<User>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯ�û���������Ϣ
			String sql = "select * from t_user where u_id=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setInt(1, u_id);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��userʵ���У���ʹ��userLiser����
			while (rs.next()) {
				User user = new User();
				user.setU_id(rs.getInt("u_id"));
				user.setU_del(rs.getInt("u_del"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_pwd(rs.getString("u_pwd"));
				user.setU_sex(rs.getString("u_sex"));
				user.setU_user(rs.getString("u_user"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.selectUserId");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.selectUserId");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * ���û���Ϣ���и���
	 */
	@Override
	public boolean updateUser(User user) throws AppException {
		boolean flag = false;
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺�����û���������Ϣ
			String sql = "UPDATE `t_user` SET `u_user`=?, `u_pwd`=?, `u_phone`=?, `u_sex`=?, `u_del`=? WHERE `u_id`=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			// System.out.println(rs + " 1");
			psmt.setString(1, user.getU_user());
			psmt.setString(2, user.getU_pwd());
			psmt.setString(3, user.getU_phone());
			psmt.setString(4, user.getU_sex());
			psmt.setInt(5, user.getU_del());
			psmt.setInt(6, user.getU_id());
			// System.out.println(rs + " 2");
			// �ǵ��ɹ��������ݵ����ݿ�ʱ������᷵��һ������1������
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.updateUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.updateUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(null);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		if (rs > 0) {
			// System.out.println(rs + " 3");
			flag = true;
		}
		return flag;
	}

	/**
	 * ���û����з�ҳ��ѯ
	 */
	@SuppressWarnings("resource") // ����ע�������Ǹ�������һ��ָ��������Ա���ע�Ĵ���Ԫ���ڲ���ĳЩ���汣�־�Ĭ��psmt = conn.prepareStatement(sqlt);
	@Override
	public Page<User> querPage(int pageSize, int pageNow) throws AppException {
		// ��ʼ������������
		Page<User> page = new Page<User>();
		List<User> pageRow = new ArrayList<User>();
		// ��ȡ����
		page.setPageSize(pageSize);
		page.setPageNow(pageNow);
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSet res = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// String sql = "select count(*) from t_user where u_del = 1 ";
			String sql = "select count(*) from t_user  ";
			System.out.println(sql);
			// Ԥ����SQL���
			psmt = conn.prepareStatement(sql);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ��ʾ���صĽ���� rs.next()
			rs.next();
			// �����������ĵ�һ�е�һ������ֵ rs.getInt(1)
			Integer rowCount = rs.getInt(1);
			// �õ���ֵ�浽page��
			page.setRowCount(rowCount);
			// String sqlt = "select * from (select * from t_user where u_del = 1) as del0
			// limit ?,? ";
			String sqlt = "select * from t_user limit ?,? ";
			psmt = conn.prepareStatement(sqlt);
			psmt.setInt(1, page.getPageSize() * (page.getPageNow() - 1));
			psmt.setInt(2, page.getPageSize());
			res = psmt.executeQuery();
			while (res.next()) {
				User user = new User(res.getString("u_user"), res.getString("u_phone"), res.getString("u_pwd"),
						res.getString("u_sex"), res.getInt("u_id"), res.getInt("u_del"));
				pageRow.add(user);
			}
			System.out.println(pageRow.size());
			page.setPageRow(pageRow);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.querPage");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.querPage");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeResultSet(res);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return page;
	}

	/**
	 * ���û����з�ҳ��ѯ
	 */
	@Override
	public List<User> showAllUser() throws AppException {
		// ��ʼ������������
		List<User> u_user = new ArrayList<User>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ��ѯ���ݱ��е���������
			String sql = "select u_user from t_user";
			System.out.println(sql);
			// Ԥ����SQL���
			psmt = conn.prepareStatement(sql);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ��ʾ���صĽ���� rs.next()
			while (rs.next()) {
				User user = new User();
				user.setU_user(rs.getString("u_user"));
				u_user.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.querPage");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.querPage");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return u_user;
	}

	/**
	 * ʵ�ֹ��ܡ��� ��ѯ�����û�����Ϣ �����û�������
	 */
	@Override
	public List<User> chargeUser() throws AppException {
		List<User> userList = new ArrayList<User>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		// int rs1 = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select u_user from t_user";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				User flag = new User();
				flag.setU_user(rs.getString("u_user"));
				userList.add(flag);
			}
			// }
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.chargeUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.chargeUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * ʵ�ֹ��� -ɾ��ѡ���û�
	 */
	@Override
	public boolean deleteAllUser(String[] uidList) throws AppException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			for (String id : uidList) {
				// ɾ�����
				String sql = "delete from t_user where u_id = ?";
				// ִ�����
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeUpdate();
				System.out.println(psmt);
			}
			/*
			 * for (int i = 0; i < uidList.length; i++) {
			 * 
			 * }
			 */
			System.out.println(rs);
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.deleteAllUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.deleteAllUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
}
