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
 * 用户数据访问层实现类
 * 
 * @author ASUS
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 实现该功能方法--查询是否有相同的用户名存在
	 */
	@Override
	public boolean isExist(String u_user) throws AppException {
		// 操作标志
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名查询用户编号，"?"为占位符。
			String sql = "select u_id from t_user where u_user =?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, u_user);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 查询到记录，则用户名已存在。flag为true
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
			// 关闭数据库连接
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--保存用户信息
	 */
	@Override
	public boolean save(User user) throws AppException {
		// 标记；操作成功为true,失败为false
		boolean flag = false;
		// 判断用户对象若为空，则不进行保存操作
		if (user == null) {
			return flag;
		}
		// 声明数据库连接对象，预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：将用户信息保存到数据库中，"?"为占位符。
			String sql = "insert into t_user(u_user, u_phone, u_pwd,u_sex,u_del)" + "values(?,?,?,?,?)";
			System.out.println("新增用户：" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, user.getU_user());
			psmt.setString(2, user.getU_phone());
			psmt.setString(3, user.getU_pwd());
			psmt.setString(4, user.getU_sex());
			psmt.setInt(5, (int) user.getU_del());
			// 执行更新操作，返回受影响行数
			int count = psmt.executeUpdate();
			// 如果受影响行数大于零，则操作成功
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
			// 关闭数据库连接
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);

		}
		return flag;
	}

	/**
	 * 根据用户名，用户密码，查询用户编号
	 */
	@Override
	public int login(String u_user, String u_pwd) throws AppException {
		// 用户编号
		int u_id = 0;
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名查询用户编号，？为占位符
			String sql = "select u_id from t_user where u_user=? and u_pwd=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, u_user);
			psmt.setString(2, u_pwd);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 查询到记录，提取用户编号
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return u_id;
	}

	/**
	 * 根据用户ID, 实现获取用户信息方法 ----对象类型
	 * 
	 */
	@Override
	public User getUser(int u_id) throws AppException {
		// 声明用户对象
		User user = null;
		// 声明数据库连接对象，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据用户名，密码查询匹配到用户信息，？为占位符
			String sql = "select * from t_user where u_id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setInt(1, u_id);
			// 查询结果集
			rs = psmt.executeQuery();
			// 当查询到结果集时使用User实体对象保存用户信息
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return user;
	}

	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public List<User> selectUser(String u_user) throws AppException {
		System.out.println("运行了selectUser");
		// 初始化用户集合
		List<User> userList = new ArrayList<User>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询用户的所有信息
			String sql = "select * from t_user where u_user=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setString(1, u_user);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到user实体中，并使用userLiser保存
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * 删除用户
	 */
	@Override
	public boolean deleteUser(int u_id) throws AppException {
		// 操作标志
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		System.out.println(u_id);
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户编号删除用户，"?"为占位符。
			String sql = "delete from t_user where u_id = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, u_id);
			// 是当成功插入数据到数据库时候，这个会返回一个大于1的数字
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
			// 关闭数据库连接
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
			DBUtil.closeResultSet(null);
		}
		return flag;
	}

	/**
	 * 根据用户ID查询用户信息，并返回用户信息-----------集合类型
	 */
	@Override
	public List<User> selectUserId(int u_id) throws AppException {
		// 初始化用户集合
		List<User> userList = new ArrayList<User>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询用户的所有信息
			String sql = "select * from t_user where u_id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setInt(1, u_id);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到user实体中，并使用userLiser保存
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * 对用户信息进行更新
	 */
	@Override
	public boolean updateUser(User user) throws AppException {
		boolean flag = false;
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：更新用户的所有信息
			String sql = "UPDATE `t_user` SET `u_user`=?, `u_pwd`=?, `u_phone`=?, `u_sex`=?, `u_del`=? WHERE `u_id`=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			// System.out.println(rs + " 1");
			psmt.setString(1, user.getU_user());
			psmt.setString(2, user.getU_pwd());
			psmt.setString(3, user.getU_phone());
			psmt.setString(4, user.getU_sex());
			psmt.setInt(5, user.getU_del());
			psmt.setInt(6, user.getU_id());
			// System.out.println(rs + " 2");
			// 是当成功插入数据到数据库时候，这个会返回一个大于1的数字
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.updateUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.UserDaoLmpl.updateUser");
		} finally {
			// 关闭数据库操作对象，释放资源
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
	 * 对用户进行分页查询
	 */
	@SuppressWarnings("resource") // 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默。psmt = conn.prepareStatement(sqlt);
	@Override
	public Page<User> querPage(int pageSize, int pageNow) throws AppException {
		// 初始化并声明对象
		Page<User> page = new Page<User>();
		List<User> pageRow = new ArrayList<User>();
		// 获取参数
		page.setPageSize(pageSize);
		page.setPageNow(pageNow);
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSet res = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// String sql = "select count(*) from t_user where u_del = 1 ";
			String sql = "select count(*) from t_user  ";
			System.out.println(sql);
			// 预编译SQL语句
			psmt = conn.prepareStatement(sql);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 表示返回的结果集 rs.next()
			rs.next();
			// 从这个结果集的第一行第一列里拿值 rs.getInt(1)
			Integer rowCount = rs.getInt(1);
			// 拿到的值存到page中
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeResultSet(res);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return page;
	}

	/**
	 * 对用户进行分页查询
	 */
	@Override
	public List<User> showAllUser() throws AppException {
		// 初始化并声明对象
		List<User> u_user = new ArrayList<User>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 查询数据表中的所以数据
			String sql = "select u_user from t_user";
			System.out.println(sql);
			// 预编译SQL语句
			psmt = conn.prepareStatement(sql);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 表示返回的结果集 rs.next()
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return u_user;
	}

	/**
	 * 实现功能—— 查询所有用户的信息 返回用户名集合
	 */
	@Override
	public List<User> chargeUser() throws AppException {
		List<User> userList = new ArrayList<User>();
		// 声明数据库连接对象，预编译对象和结果集
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}

	/**
	 * 实现功能 -删除选中用户
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
				// 删除语句
				String sql = "delete from t_user where u_id = ?";
				// 执行语句
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
}
