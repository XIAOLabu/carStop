package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.CarDao;
import cn.gx.czz.model.Car;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * 车辆数据访问层实现类
 * 
 * @author ASUS
 *
 */
public class CarDaoImpl implements CarDao {

	/**
	 * 实现该功能方法--查询是否有相同的车牌号存在 OR 查询该车牌是否属于小区用户
	 */
	@Override
	public boolean isExist(String c_cno) throws AppException {
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句：根据用户名查询用户编号，"?"为占位符。
			String sql = "select c_cno from c_car where c_cno =?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置占位符
			psmt.setString(1, c_cno);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 如果rs.next 不为空返回true；否则返回false
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.isExist");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.isExist");
		} finally {
			// 关闭数据库连接
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--保存新增车辆
	 */
	@Override
	public boolean addsave(Car car) throws AppException {
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			// 连接数据库
			conn = DBUtil.getConnection();
			// 编辑MySQL语句
			String sql = "INSERT INTO `c_car` (`c_cno`, `c_csb`, `c_ccr`,`c_user`)" + "VALUES (?,?,?,?)";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 为占位符设置值
			psmt.setString(1, car.getC_cno());
			psmt.setString(2, car.getC_csd());
			psmt.setString(3, car.getC_ccr());
			psmt.setString(4, car.getC_user());
			// 执行更新操作，返回受影响行数
			count = psmt.executeUpdate();
			// 如果受影响行数大于零，则操作成功
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.isExist");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.isExist");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--根据用户名字 返回车辆数据 ；
	 */
	@Override
	public List<Car> showCar(String c_user) throws AppException {
		// 初始化车位对象集合
		List<Car> carList = new ArrayList<Car>();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from c_car where c_user = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_user);
			// 执行查询操作
			rs = psmt.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setC_cid(rs.getInt("c_cid"));
				car.setC_cno(rs.getString("c_cno"));
				car.setC_csd(rs.getString("c_csb"));
				car.setC_ccr(rs.getString("c_ccr"));
				car.setC_user(rs.getString("c_user"));
				carList.add(car);
				System.out.println(carList + "    133");
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.showCar");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.showCar");
		} finally {
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
			DBUtil.closeConnection(conn);
		}
		return carList;
	}

	/**
	 * 实现该功能方法-- 根据车辆ID 返回车辆数据-集合
	 */
	@Override
	public List<Car> upCar(int c_cid) throws AppException {
		List<Car> carList = new ArrayList<Car>();
		Car car = new Car();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from c_car where c_cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, c_cid);
			// 执行查询操作
			rs = psmt.executeQuery();
			while (rs.next()) {
				car.setC_cid(rs.getInt("c_cid"));
				car.setC_cno(rs.getString("c_cno"));
				car.setC_csd(rs.getString("c_csb"));
				car.setC_ccr(rs.getString("c_ccr"));
				car.setC_user(rs.getString("c_user"));
				carList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.upCar");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.upCar");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
		}
		return carList;
	}

	/**
	 * 实现该功能方法-- 根据车辆ID 返回车辆数据
	 */
	@Override
	public Car showCarid(int c_cid) throws AppException {
		Car car = new Car();
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from c_car where c_cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, c_cid);
			// 执行查询操作
			rs = psmt.executeQuery();
			while (rs.next()) {
				car.setC_cid(rs.getInt("c_cid"));
				car.setC_cno(rs.getString("c_cno"));
				car.setC_csd(rs.getString("c_csb"));
				car.setC_ccr(rs.getString("c_ccr"));
				car.setC_user(rs.getString("c_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.showCarid");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.showCarid");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
		}
		return car;
	}

	/**
	 * 实现该功能方法--对原车辆信息进行更新 并返回车辆信息集合
	 */
	@Override
	public Boolean up2Car(Car car) throws AppException {
		System.out.println(car + "          up2Car");
		boolean flag = false;
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE `c_car` SET `c_cno`=?, `c_csb`=?, `c_ccr`=? WHERE (`c_cid`=?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, car.getC_cno());
			psmt.setString(2, car.getC_csd());
			psmt.setString(3, car.getC_ccr());
			psmt.setInt(4, car.getC_cid());
			// 是当成功插入数据到数据库时候，这个会返回一个大于1的数字
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.up2Car");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.up2Car");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		if (rs > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 实现该功能方法--对车辆信息进行删除
	 */
	@Override
	public boolean delCar(int c_cid) throws AppException {
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from c_car where c_cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, c_cid);
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.delCar");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.delCar");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 实现该功能方法——通过车主用户名 获取该用户的车辆信息
	 */
	@Override
	public Car queryCar(String c_user) throws AppException {
		Car flag = new Car();

		return flag;
	}

	/**
	 * 实现该功能方法——通过车牌号码 获取该用户的车辆信息
	 */
	@Override
	public Car addStopUser(String c_cno) throws AppException {
		Car flag = new Car();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = " select * from c_car where c_cno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_cno);
			rs = psmt.executeQuery();
			while (rs.next()) {
				flag.setC_cid(rs.getInt("c_cid"));
				flag.setC_cno(rs.getString("c_cno"));
				flag.setC_csd(rs.getString("c_csb"));
				flag.setC_ccr(rs.getString("c_ccr"));
				flag.setC_user(rs.getString("c_user"));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.addStopUser");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CarDaoImpl.addStopUser");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

}
