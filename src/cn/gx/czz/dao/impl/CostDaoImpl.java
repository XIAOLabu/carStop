package cn.gx.czz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import cn.gx.czz.dao.CostDao;
import cn.gx.czz.model.Cost;
import cn.gx.czz.util.AppException;
import cn.gx.czz.util.DBUtil;

/**
 * ͣ���������ݷ��ʲ�ʵ����
 * 
 * @author ASUS
 *
 */
public class CostDaoImpl implements CostDao {

	/**
	 * ʵ�֡����������ͣ����������
	 */
	@Override
	public boolean addCost(Cost cost) throws AppException {
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(flag);
			String sql = "INSERT INTO `m_cost` (`m_cno`, `m_time`, `m_charge`,`m_cost`)" + "VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cost.getM_cno());
			psmt.setInt(2, cost.getM_time());
			psmt.setDouble(3, cost.getM_charge());
			psmt.setBigDecimal(4, cost.getM_cost());
			rs = psmt.executeUpdate();
			if (rs > 0) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CostDaoImpl.addCost");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.CostDaoImpl.addCost");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement((Statement) psmt);
		}
		return flag;
	}

}
