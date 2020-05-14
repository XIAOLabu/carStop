package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.StopDao;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.Stop;
import cn.gx.czz.model.SumCostUser;
import cn.gx.czz.model.SumUserCost;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

public class StopDaoImpl implements StopDao {

	/**
	 * 实现 --- 保存入场车辆的 车牌号，停车位置，用户类型 ，入场时间
	 */
	@Override
	public boolean addStop(Stop stop) throws AppException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO `t_stop` (`s_tcn`, `s_tcw`, `s_tcu`, `s_cit`, `s_user`)" + "VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stop.getS_tcn());
			psmt.setString(2, stop.getS_tcw());
			psmt.setInt(3, stop.getS_tcu());
			psmt.setTimestamp(4, stop.getS_cit());
			psmt.setString(5, stop.getS_user());
			// 执行更新操作，返回受影响行数
			int count = psmt.executeUpdate();
			// 如果受影响行数大于零，则操作成功
			if (count > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.addStop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.addStop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 实现 --- 停车信息分页查询显示
	 */
	@SuppressWarnings("resource") // 取消这行psmt = conn.prepareStatement(sqlt);警告
	@Override
	public Page<Stop> querPage(Integer pageSize, Integer pageNow) throws AppException {
		// 初始化并声明对象
		Page<Stop> page = new Page<Stop>();
		List<Stop> pageRow = new ArrayList<Stop>();
		// 填入参数
		page.setPageSize(pageSize);
		page.setPageNow(pageNow);
		// 声明数据库连接对象，预编译对象和结果集
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSet res = null;
		try {
			// 连接数据库
			conn = DBUtil.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			// 声明MySQL语句
			String sql = "select count(*) from t_stop";
			System.out.println(sql);
			// 预编译MySQL语句
			psmt = conn.prepareStatement(sql);
			// 执行查询操作
			rs = psmt.executeQuery();
			// 表示返回的结果集 rs.next()
			rs.next();
			// 从这个结果集的第一行第一列里拿值 rs.getInt(1)
			Integer rowCount = rs.getInt(1);
			// 拿到的值存到page中
			page.setRowCount(rowCount);
			String sqlt = "select * from t_stop order by s_time limit ?,?";
			psmt = conn.prepareStatement(sqlt);
			// 从某条数据开始
			psmt.setInt(1, page.getPageSize() * (page.getPageNow() - 1));
			// 一页该显示的数据行数
			psmt.setInt(2, page.getPageSize());
			// 执行查询操作
			res = psmt.executeQuery();
			while (res.next()) {
				// 存值回去
				Stop stop = new Stop(res.getString("s_tcn"), res.getString("s_tcw"), res.getString("s_user"),
						res.getInt("s_id"), res.getInt("s_tcu"), res.getInt("s_time"), res.getTimestamp("s_cit"),
						res.getTimestamp("s_cot"), res.getBigDecimal("s_cost"));
				pageRow.add(stop);
			}
			page.setPageRow(pageRow);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.querPage");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.querPage");
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
	 * 实现 --- 对停车信息的删除
	 */
	public boolean delStop(int s_id) throws AppException {
		System.out.println(s_id + "delStop");
		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			String sql = "delete from t_stop where s_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s_id);
			rs = psmt.executeUpdate();
			System.out.println(psmt);
			System.out.println(rs);
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.delStop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.delStop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--查询数据库里的对应的ID实体，返回实体对象集合
	 */
	@Override
	public List<Stop> up1Stop(int s_id) throws AppException {
		List<Stop> stopList = new ArrayList<Stop>();
		Stop stop = new Stop();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from t_stop where s_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				stop.setS_cit(rs.getTimestamp("s_cit"));
				stop.setS_cot(rs.getTimestamp("s_cot"));
				stop.setS_id(rs.getInt("s_id"));
				stop.setS_tcn(rs.getString("s_tcn"));
				stop.setS_tcu(rs.getInt("s_tcu"));
				stop.setS_tcw(rs.getString("s_tcw"));
				stop.setS_time(rs.getInt("s_time"));
				stopList.add(stop);
				System.out.println("             180            " + stopList);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.up1Stop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.up1Stop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return stopList;
	}

	/**
	 * 实现该功能方法--修改对应的ID实体
	 */
	@Override
	public Boolean up2Stop(Stop stop) throws AppException {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			String sql = "UPDATE `t_stop` SET `s_tcn`=?, `s_tcw`=?, `s_tcu`=?, `s_time`=?, `s_cit`=?, `s_cot`=?, `s_cost`=? WHERE `s_id`=?";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stop.getS_tcn());
			psmt.setString(2, stop.getS_tcw());
			psmt.setInt(3, stop.getS_tcu());
			psmt.setInt(4, stop.getS_time());
			psmt.setTimestamp(5, stop.getS_cit());
			psmt.setTimestamp(6, stop.getS_cot());
			psmt.setBigDecimal(7, stop.getS_cost());
			psmt.setInt(8, stop.getS_id());
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.up2Stop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.up2Stop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

	/**
	 * 实现该功能方法--查询数据库里的对应的ID实体，返回实体对象
	 */
	@Override
	public Stop selectStop(int s_id) throws AppException {
		Stop stop = new Stop();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from t_stop where s_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				stop.setS_cit(rs.getTimestamp("s_cit"));
				stop.setS_cot(rs.getTimestamp("s_cot"));
				stop.setS_id(rs.getInt("s_id"));
				stop.setS_tcn(rs.getString("s_tcn"));
				stop.setS_tcu(rs.getInt("s_tcu"));
				stop.setS_tcw(rs.getString("s_tcw"));
				stop.setS_time(rs.getInt("s_time"));
				System.out.println("             180            " + stop);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.selectStop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.selectStop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return stop;
	}

	/**
	 * 实现该功能方法 ——根据输入条件进行查询，并按s_time 大小进行升序排列
	 */
	@SuppressWarnings("resource")
	@Override
	public List<Stop> queryStop(Stop stop, Timestamp s_citt) throws AppException {
		List<Stop> stopList = new ArrayList<Stop>();
		Date date = new Date();
		System.out.println(stop.getS_tcn() + "queryStop                 290 ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			/*
			 * if (stop.getS_user() != null) { String sql0 =
			 * "select * from t_stop where 1=1"; }
			 */
			String sql = "select * from t_stop where 1=1";
			// System.out.println(stop.getS_tcn() != null && stop.getS_cit() != null &&
			// s_citt != null);
			if (!"".equals(stop.getS_tcn()) && stop.getS_cit() != null && s_citt != null) {
				sql = sql + " and  `s_tcn` = ?  and ( `s_cit` between  ?  and ? ) ";
				psmt = conn.prepareStatement(sql);
				System.out.println(sql + "  车牌号，开始日期和结束时间不为空  ");
				psmt.setString(1, stop.getS_tcn());
				psmt.setTimestamp(2, stop.getS_cit());
				psmt.setTimestamp(3, s_citt);
			} else if (stop.getS_cit() != null && s_citt != null) {
				sql = sql + " and `s_cit` between ? and ?";
				System.out.println(sql + "          开始日期和结束时间不为空                          ");
				psmt = conn.prepareStatement(sql);
				psmt.setTimestamp(1, stop.getS_cit());
				psmt.setTimestamp(2, s_citt);
			} else if (!"".equals(stop.getS_tcn()) && stop.getS_cit() != null) {
				sql = sql + " and `s_tcn`= ?  and ( `s_cit` between ? and ? )";
				System.out.println(sql + " 车牌和开始日期不为空 ");
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, stop.getS_tcn());
				psmt.setTimestamp(2, stop.getS_cit());
				psmt.setTimestamp(3, new Timestamp(date.getTime()));
			} else if (stop.getS_cit() != null) {
				sql = sql + " and `s_cit` between ? and ?";
				System.out.println(sql + "开始日期不为空 ");
				psmt = conn.prepareStatement(sql);
				psmt.setTimestamp(1, stop.getS_cit());
				psmt.setTimestamp(2, new Timestamp(date.getTime()));
				/*
				 * String sqlt = "select * from t_stop where `s_cit` = ?  order by s_time ";
				 * psmt = conn.prepareStatement(sqlt); psmt.setTimestamp(1, stop.getS_cit());
				 */
			} else if (!"".equals(stop.getS_tcn())) {
				sql = sql + " and `s_tcn` = ? ";
				System.out.println(sql + "车牌不为空");
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, stop.getS_tcn());
				String sqlt = "select * from t_stop where `s_tcn` = ?  order by s_time ";
				psmt = conn.prepareStatement(sqlt);
				psmt.setString(1, stop.getS_tcn());
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Stop flag = new Stop();
				flag.setS_cit(rs.getTimestamp("s_cit"));
				flag.setS_cot(rs.getTimestamp("s_cot"));
				flag.setS_id(rs.getInt("s_id"));
				flag.setS_tcn(rs.getString("s_tcn"));
				flag.setS_tcu(rs.getInt("s_tcu"));
				flag.setS_tcw(rs.getString("s_tcw"));
				flag.setS_time(rs.getInt("s_time"));
				flag.setS_cost(rs.getBigDecimal("s_cost"));
				flag.setS_user(rs.getString("s_user"));
				stopList.add(flag);
			}
			// System.out.println(" 315 " + stopList);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.queryStop");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.queryStop");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return stopList;
	}

	/**
	 * 实现该功能方法 ——根据用户名对费用的查询
	 */
	@Override
	public List<SumCostUser> chargeCost(String s_user) throws AppException {
		List<SumCostUser> sumCostUserList = new ArrayList<SumCostUser>();
		SumCostUser flag = new SumCostUser();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select sum(s_cost) as sum , s_user from t_stop where s_user = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s_user);
			rs = psmt.executeQuery();
			while (rs.next()) {
				flag.setCu_sum(rs.getBigDecimal("sum"));
				flag.setCu_user(rs.getString("s_user"));
				sumCostUserList.add(flag);
			}
			System.out.println(sumCostUserList);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.chargeCost");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.chargeCost");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return sumCostUserList;
	}

	@Override
	public List<SumUserCost> showCnoCostAll(String c_user) throws AppException {
		List<SumUserCost> userCostList = new ArrayList<SumUserCost>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select s_user,s_tcn, sum(s_time) as sum_time, sum(s_cost) as sum_cost from t_stop where s_tcn in((select c_cno from c_car where c_user = ?)) group by s_tcn";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_user);
			rs = psmt.executeQuery();
			while (rs.next()) {
				SumUserCost flag = new SumUserCost();
				flag.setSum_cost(rs.getBigDecimal("sum_cost"));
				flag.setSum_time(rs.getInt("sum_time"));
				flag.setS_tcn(rs.getString("s_tcn"));
				flag.setS_user(rs.getString("s_user"));
				userCostList.add(flag);
			}
			System.out.println(userCostList + "                436");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.showCnoCostAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.showCnoCostAll");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return userCostList;
	}

	/**
	 * 实现根据车牌号查询车辆停放记录
	 */
	@Override
	public List<Stop> selectc_tcn(String c_tcn) throws AppException {
		List<Stop> stopList = new ArrayList<Stop>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from t_stop where s_tcn =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_tcn);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Stop flag = new Stop();
				flag.setS_cit(rs.getTimestamp("s_cit"));
				flag.setS_cot(rs.getTimestamp("s_cot"));
				flag.setS_id(rs.getInt("s_id"));
				flag.setS_tcn(rs.getString("s_tcn"));
				flag.setS_tcu(rs.getInt("s_tcu"));
				flag.setS_tcw(rs.getString("s_tcw"));
				flag.setS_time(rs.getInt("s_time"));
				flag.setS_cost(rs.getBigDecimal("s_cost"));
				flag.setS_user(rs.getString("s_user"));
				stopList.add(flag);
				System.out.println(stopList);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.StopDaoImol.showCnoCostAll");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeResultSet(rs);
		}
		return stopList;
	}

}
