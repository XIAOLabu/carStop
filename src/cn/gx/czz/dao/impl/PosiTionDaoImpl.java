package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.PosiTionDao;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * 车位数据访问层实现类
 * 
 * @author ASUS
 *
 */
public class PosiTionDaoImpl implements PosiTionDao {

	/**
	 * 实现该功能方法--查询是否有相同的车位号存在
	 */
	@Override
	public boolean isPosi(String cw_no) throws AppException {
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
			String sql = "select cw_no from t_position where cw_no =?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, cw_no);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 查询到记录，则车位号已存在。flag为true
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.isPosi");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.isPosi");
		} finally {
			// 关闭数据库连接
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--保存车位信息
	 */
	@Override
	public boolean addPosi(PosiTion position) throws AppException {
		// 操作标志
		boolean flag = false;
		// 判断对象若为空，则不进行保存操作
		if (position == null) {
			return flag;
		}
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO `t_position` (`cw_no`, `cw_wc`, `cw_user`, `cw_state`, `cw_type`)"
					+ "values(?,?,?,?,?)";
			System.out.println("新增用户：" + sql);
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			System.out.println(position.getCw_wz());
			psmt.setString(1, position.getCw_no());
			psmt.setString(2, position.getCw_wz());
			psmt.setString(3, position.getCw_user());
			psmt.setString(4, position.getCw_state());
			psmt.setInt(5, (int) position.getCw_type());
			// 执行更新操作，返回受影响行数
			int count = psmt.executeUpdate();
			// 如果受影响行数大于零，则操作成功
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.addPosi");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.addPosi");
		} finally {
			// 关闭数据库连接
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--分页显示车位信息
	 */
	@SuppressWarnings("resource") // 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默。psmt = conn.prepareStatement(sqlt);
	@Override
	public Page<PosiTion> querPage(int pageSize, int pageNow) throws AppException {
		// 初始化并声明对象
		Page<PosiTion> page = new Page<PosiTion>();
		List<PosiTion> pageRow = new ArrayList<PosiTion>();
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
			String sql = "select count(*) from t_position";
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
			String sqlt = "select * from t_position limit ?,?";
			psmt = conn.prepareStatement(sqlt);
			psmt.setInt(1, page.getPageSize() * (page.getPageNow() - 1));
			psmt.setInt(2, page.getPageSize());
			// 执行查询操作
			res = psmt.executeQuery();
			while (res.next()) {
				// 存值回去
				PosiTion position = new PosiTion(res.getString("cw_no"), res.getString("cw_wc"),
						res.getString("cw_user"), res.getString("cw_state"), res.getInt("cw_id"),
						res.getInt("cw_type"));
				pageRow.add(position);
			}
			page.setPageRow(pageRow);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.querPage");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.querPage");
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
	 * 实现该功能方法--删除数据库里的对应的ID的对象信息
	 */
	@Override
	public boolean deleteUser(int cw_id) throws AppException {
		// 操作标志
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		System.out.println(cw_id);
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据车位编号删除该车位，"?"为占位符。
			String sql = "delete from t_position where cw_id = ?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setInt(1, cw_id);
			// 是当成功插入数据到数据库时候，这个会返回一个大于1的数字
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.deleteUser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.deleteUser");
		} finally {
			// 关闭数据库连接
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--查询数据库里的对应的ID实体，返回实体对象集合
	 */
	@Override
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException {
		// 初始化车位对象集合
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询目标车位的所有信息
			String sql = "select * from t_position where cw_id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setInt(1, cw_id);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到position实体中，并使用positionList集合保存
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// 状态
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// 类型
				positionList.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_id");
		} finally {
			// 关闭数据库连接
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * 实现该功能方法--通过车位用户查询车位
	 */
	@Override
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException {
		// 初始化车位对象集合
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询目标车位的所有信息
			String sql = "select * from t_position where cw_user=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setString(1, cw_user);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到position实体中，并使用positionList集合保存
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// 状态
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// 类型
				positionList.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_user");
		} finally {
			// 关闭数据库连接
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * 实现该功能方法--通过车位类型查询车位
	 */
	@Override
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException {
		// 初始化车位对象集合
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询目标车位的所有信息
			String sql = "select * from t_position where cw_type=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setInt(1, cw_type);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到position实体中，并使用positionList集合保存
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// 状态
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// 类型
				positionList.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_type");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_type");
		} finally {
			// 关闭数据库连接
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * 实现该功能方法--通过车位状态查询车位
	 */
	@Override
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException {
		// 初始化车位对象集合
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询目标车位的所有信息
			String sql = "select * from t_position where cw_state=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setString(1, cw_state);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到position实体中，并使用positionList集合保存
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// 状态
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// 类型
				positionList.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_state");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_state");
		} finally {
			// 关闭数据库连接
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * 实现该功能方法--通过车位位置查询车位
	 */
	@Override
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException {
		// 初始化车位对象集合
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：查询目标车位的所有信息
			String sql = "select * from t_position where `cw_wc`=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setString(1, cw_wz);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 循环提取结果集中的信息，封装到position实体中，并使用positionList集合保存
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// 状态
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// 类型
				positionList.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_wz");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.selectPostcw_wz");
		} finally {
			// 关闭数据库连接
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * 实现该功能方法--更新实体对象的信息
	 */
	@Override
	public boolean updatePosi(PosiTion position) throws AppException {
		boolean flag = false;
		System.out.println(position.getCw_type() + "           updatePosi  ");
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：更新车位的所有信息
			String sql = "UPDATE `t_position` SET `cw_no`=?, `cw_wc`=?, `cw_user`=?,`cw_state`=?, `cw_type`=? WHERE `cw_id`=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符？处的值
			psmt.setString(1, position.getCw_no());
			psmt.setString(2, position.getCw_wz());
			psmt.setString(3, position.getCw_user());
			psmt.setString(4, position.getCw_state());
			psmt.setInt(5, position.getCw_type());
			psmt.setInt(6, position.getCw_id());
			// 是当成功插入数据到数据库时候，这个会返回一个大于1的数字
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.updataPosi");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.updataPosi");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(null);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		if (rs > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 实现该功能方法--查询车位号对应的车位状态，如果查询的状态和要改变的状态相同就返回false，否者就进行更改
	 */
	@Override
	public boolean upcw_state(String cw_no, String cw_state) throws AppException {
		boolean flag = false;
		System.out.println(flag + "1");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int rsl = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			String sql0 = "select cw_state from t_position where cw_no =?";
			System.out.println(sql0);
			psmt = conn.prepareStatement(sql0);
			psmt.setString(1, cw_no);
			// 执行查询操作
			rs = psmt.executeQuery();
			// System.out.println(cw_state);
			while (rs.next()) {
				// System.out.println(rs.getString("cw_state"));
				if (!rs.getString("cw_state").equals(cw_state)) {
					/*
					 * System.out.println(rs.getString("cw_state") + "gfggggggg");
					 * System.out.println(flag + "2");
					 */
					String sql = "UPDATE `t_position` SET `cw_state`=? WHERE cw_no = ?";
					System.out.println(sql);
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, cw_state);
					psmt.setString(2, cw_no);
					rsl = psmt.executeUpdate();
					if (rsl > 0) {
						flag = true;
					}
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.upcw_state");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.upcw_state");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(null);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		// System.out.println(flag + "3");
		return flag;
	}
}
