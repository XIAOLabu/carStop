package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.MomCostDao;
import cn.gx.czz.model.MomCost;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * 月报表数据访问层实现类
 * 
 * @author ASUS
 *
 */
public class MomCostDaoImpl implements MomCostDao {

	@Override
	public boolean saveData(MomCost momcost) throws AppException {
		boolean flag = false;
		// 类型转换
		java.sql.Date sql_time = new java.sql.Date(momcost.getMc_time().getTime());
		// 声明数据库连接对象，，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			if (momcost.getMc_icost() != null) {
				String sql = "INSERT INTO `t_momcost` (`mc_time`, `mc_icost`) VALUES (?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setDate(1, sql_time);
				psmt.setBigDecimal(2, momcost.getMc_icost());
			} else if (momcost.getMc_zcost() != null) {
				String sql = "INSERT INTO `t_momcost` (`mc_time`, `mc_zcost`) VALUES (?,?)";
				psmt = conn.prepareStatement(sql);
				// psmt.setDate(1, momcost.getMc_time());
				psmt.setDate(1, sql_time);
				psmt.setBigDecimal(2, momcost.getMc_zcost());
			}
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MomCostDaoImpl.saveData");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MomCostDaoImpl.saveData");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 
	 */
	@Override
	public List<MomCost> selectDate(Date sql_date, Date sql_date1) throws AppException {
		List<MomCost> momcostList = new ArrayList<MomCost>();
		// 声明数据库连接对象，，预编译对象和结果集对象
		System.out.println(sql_date);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select CONCAT(sum_icost+  sum_zcost ) as sum ,sum_icost ,sum_zcost , date  from (select Sum(mc_icost) as sum_icost,Sum(mc_zcost) as sum_zcost, mc_time as date from t_momcost where DATEDIFF(?, ?) <= 30 group by mc_time) as t1 where date_format(date,'%Y-%m')=date_format(?,'%Y-%m')  ";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, sql_date1);
			psmt.setDate(2, sql_date);
			psmt.setDate(3, sql_date);
			System.out.println(psmt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MomCost flag = new MomCost();
				flag.setMc_icost(rs.getBigDecimal("sum_icost"));
				flag.setMc_zcost(rs.getBigDecimal("sum_zcost"));
				flag.setMc_sumcost(rs.getBigDecimal("sum"));
				flag.setMc_time(rs.getDate("date"));
				flag.setMc_week(MomCostDaoImpl.getWeek(rs.getDate("date")));
				momcostList.add(flag);
			}
			System.out.println(momcostList + "             96");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MomCostDaoImpl.selectDate");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.MomCostDaoImpl.selectDate");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return momcostList;
	}

	// 使用Calendar类
	// 根据日期取得星期几
	public static String getWeek(Date date) {
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}
}
