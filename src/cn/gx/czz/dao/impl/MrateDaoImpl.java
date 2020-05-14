package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.MrateDao;
import cn.gx.czz.model.Mrate;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * 收费数据访问层实现类
 * 
 * @author ASUS
 *
 */
public class MrateDaoImpl implements MrateDao {

	/**
	 * 实现功能——更新数据库的数据
	 */
	@Override
	public boolean up1Mrate(Mrate mrate) throws AppException {
		boolean flag = false;
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE `t_charge` SET `r_scu`=?, `r_scutmp`=?";
			psmt = conn.prepareStatement(sql);
			psmt.setDouble(1, mrate.getR_scu());
			psmt.setDouble(2, mrate.getR_scutmp());
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.up1Mrate");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.up1Mrate");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		System.out.println(flag);
		return flag;
	}

	/**
	 * 实现功能——返回数据对象的集合
	 */
	@Override
	public List<Mrate> showMrate() throws AppException {
		List<Mrate> mrateList = new ArrayList<Mrate>();
		Mrate flag = new Mrate();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from t_charge";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				flag.setR_scu(rs.getDouble("r_scu"));
				flag.setR_scutmp(rs.getDouble("r_scutmp"));
				mrateList.add(flag);
				System.out.println(flag + "         MrateDaoImpl. upMrate");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.showMrate");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.showMrate");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}

		return mrateList;
	}

	/**
	 * 实现功能——返回数据对象
	 */
	@Override
	public Mrate showMrateObj() throws AppException {
		Mrate mrate = new Mrate();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from t_charge";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				mrate.setR_scu(rs.getDouble("r_scu"));
				mrate.setR_scutmp(rs.getDouble("r_scutmp"));
				System.out.println(mrate + "         MrateDaoImpl. showMrateObj");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.showMrateObj");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MrateDaoImpl.showMrateObj");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}

		return mrate;
	}

}
