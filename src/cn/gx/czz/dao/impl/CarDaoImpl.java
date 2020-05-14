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
 * �������ݷ��ʲ�ʵ����
 * 
 * @author ASUS
 *
 */
public class CarDaoImpl implements CarDao {

	/**
	 * ʵ�ָù��ܷ���--��ѯ�Ƿ�����ͬ�ĳ��ƺŴ��� OR ��ѯ�ó����Ƿ�����С���û�
	 */
	@Override
	public boolean isExist(String c_cno) throws AppException {
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺�����û�����ѯ�û���ţ�"?"Ϊռλ����
			String sql = "select c_cno from c_car where c_cno =?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��
			psmt.setString(1, c_cno);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ���rs.next ��Ϊ�շ���true�����򷵻�false
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
			// �ر����ݿ�����
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ʵ�ָù��ܷ���--������������
	 */
	@Override
	public boolean addsave(Car car) throws AppException {
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			// �������ݿ�
			conn = DBUtil.getConnection();
			// �༭MySQL���
			String sql = "INSERT INTO `c_car` (`c_cno`, `c_csb`, `c_ccr`,`c_user`)" + "VALUES (?,?,?,?)";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setString(1, car.getC_cno());
			psmt.setString(2, car.getC_csd());
			psmt.setString(3, car.getC_ccr());
			psmt.setString(4, car.getC_user());
			// ִ�и��²�����������Ӱ������
			count = psmt.executeUpdate();
			// �����Ӱ�����������㣬������ɹ�
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
	 * ʵ�ָù��ܷ���--�����û����� ���س������� ��
	 */
	@Override
	public List<Car> showCar(String c_user) throws AppException {
		// ��ʼ����λ���󼯺�
		List<Car> carList = new ArrayList<Car>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from c_car where c_user = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_user);
			// ִ�в�ѯ����
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
	 * ʵ�ָù��ܷ���-- ���ݳ���ID ���س�������-����
	 */
	@Override
	public List<Car> upCar(int c_cid) throws AppException {
		List<Car> carList = new ArrayList<Car>();
		Car car = new Car();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from c_car where c_cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, c_cid);
			// ִ�в�ѯ����
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
	 * ʵ�ָù��ܷ���-- ���ݳ���ID ���س�������
	 */
	@Override
	public Car showCarid(int c_cid) throws AppException {
		Car car = new Car();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from c_car where c_cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, c_cid);
			// ִ�в�ѯ����
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
	 * ʵ�ָù��ܷ���--��ԭ������Ϣ���и��� �����س�����Ϣ����
	 */
	@Override
	public Boolean up2Car(Car car) throws AppException {
		System.out.println(car + "          up2Car");
		boolean flag = false;
		// �������ݿ����Ӷ���Ԥ�������ͽ����
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
			// �ǵ��ɹ��������ݵ����ݿ�ʱ������᷵��һ������1������
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
	 * ʵ�ָù��ܷ���--�Գ�����Ϣ����ɾ��
	 */
	@Override
	public boolean delCar(int c_cid) throws AppException {
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
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
	 * ʵ�ָù��ܷ�������ͨ�������û��� ��ȡ���û��ĳ�����Ϣ
	 */
	@Override
	public Car queryCar(String c_user) throws AppException {
		Car flag = new Car();

		return flag;
	}

	/**
	 * ʵ�ָù��ܷ�������ͨ�����ƺ��� ��ȡ���û��ĳ�����Ϣ
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
