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
 * ��λ���ݷ��ʲ�ʵ����
 * 
 * @author ASUS
 *
 */
public class PosiTionDaoImpl implements PosiTionDao {

	/**
	 * ʵ�ָù��ܷ���--��ѯ�Ƿ�����ͬ�ĳ�λ�Ŵ���
	 */
	@Override
	public boolean isPosi(String cw_no) throws AppException {
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
			String sql = "select cw_no from t_position where cw_no =?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setString(1, cw_no);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ��ѯ����¼����λ���Ѵ��ڡ�flagΪtrue
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
			// �ر����ݿ�����
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ʵ�ָù��ܷ���--���泵λ��Ϣ
	 */
	@Override
	public boolean addPosi(PosiTion position) throws AppException {
		// ������־
		boolean flag = false;
		// �ж϶�����Ϊ�գ��򲻽��б������
		if (position == null) {
			return flag;
		}
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO `t_position` (`cw_no`, `cw_wc`, `cw_user`, `cw_state`, `cw_type`)"
					+ "values(?,?,?,?,?)";
			System.out.println("�����û���" + sql);
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			System.out.println(position.getCw_wz());
			psmt.setString(1, position.getCw_no());
			psmt.setString(2, position.getCw_wz());
			psmt.setString(3, position.getCw_user());
			psmt.setString(4, position.getCw_state());
			psmt.setInt(5, (int) position.getCw_type());
			// ִ�и��²�����������Ӱ������
			int count = psmt.executeUpdate();
			// �����Ӱ�����������㣬������ɹ�
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
			// �ر����ݿ�����
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ʵ�ָù��ܷ���--��ҳ��ʾ��λ��Ϣ
	 */
	@SuppressWarnings("resource") // ����ע�������Ǹ�������һ��ָ��������Ա���ע�Ĵ���Ԫ���ڲ���ĳЩ���汣�־�Ĭ��psmt = conn.prepareStatement(sqlt);
	@Override
	public Page<PosiTion> querPage(int pageSize, int pageNow) throws AppException {
		// ��ʼ������������
		Page<PosiTion> page = new Page<PosiTion>();
		List<PosiTion> pageRow = new ArrayList<PosiTion>();
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
			String sql = "select count(*) from t_position";
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
			String sqlt = "select * from t_position limit ?,?";
			psmt = conn.prepareStatement(sqlt);
			psmt.setInt(1, page.getPageSize() * (page.getPageNow() - 1));
			psmt.setInt(2, page.getPageSize());
			// ִ�в�ѯ����
			res = psmt.executeQuery();
			while (res.next()) {
				// ��ֵ��ȥ
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
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeResultSet(res);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return page;
	}

	/**
	 * ʵ�ָù��ܷ���--ɾ�����ݿ���Ķ�Ӧ��ID�Ķ�����Ϣ
	 */
	@Override
	public boolean deleteUser(int cw_id) throws AppException {
		// ������־
		boolean flag = false;
		// �������ݿ����Ӷ��󣬣�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		System.out.println(cw_id);
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺���ݳ�λ���ɾ���ó�λ��"?"Ϊռλ����
			String sql = "delete from t_position where cw_id = ?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// Ϊռλ������ֵ
			psmt.setInt(1, cw_id);
			// �ǵ��ɹ��������ݵ����ݿ�ʱ������᷵��һ������1������
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
			// �ر����ݿ�����
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ʵ�ָù��ܷ���--��ѯ���ݿ���Ķ�Ӧ��IDʵ�壬����ʵ����󼯺�
	 */
	@Override
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException {
		// ��ʼ����λ���󼯺�
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯĿ�공λ��������Ϣ
			String sql = "select * from t_position where cw_id=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setInt(1, cw_id);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��positionʵ���У���ʹ��positionList���ϱ���
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// ״̬
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// ����
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
			// �ر����ݿ�����
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * ʵ�ָù��ܷ���--ͨ����λ�û���ѯ��λ
	 */
	@Override
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException {
		// ��ʼ����λ���󼯺�
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯĿ�공λ��������Ϣ
			String sql = "select * from t_position where cw_user=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setString(1, cw_user);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��positionʵ���У���ʹ��positionList���ϱ���
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// ״̬
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// ����
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
			// �ر����ݿ�����
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * ʵ�ָù��ܷ���--ͨ����λ���Ͳ�ѯ��λ
	 */
	@Override
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException {
		// ��ʼ����λ���󼯺�
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯĿ�공λ��������Ϣ
			String sql = "select * from t_position where cw_type=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setInt(1, cw_type);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��positionʵ���У���ʹ��positionList���ϱ���
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// ״̬
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// ����
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
			// �ر����ݿ�����
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * ʵ�ָù��ܷ���--ͨ����λ״̬��ѯ��λ
	 */
	@Override
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException {
		// ��ʼ����λ���󼯺�
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯĿ�공λ��������Ϣ
			String sql = "select * from t_position where cw_state=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setString(1, cw_state);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��positionʵ���У���ʹ��positionList���ϱ���
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// ״̬
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// ����
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
			// �ر����ݿ�����
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * ʵ�ָù��ܷ���--ͨ����λλ�ò�ѯ��λ
	 */
	@Override
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException {
		// ��ʼ����λ���󼯺�
		List<PosiTion> positionList = new ArrayList<PosiTion>();
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺��ѯĿ�공λ��������Ϣ
			String sql = "select * from t_position where `cw_wc`=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setString(1, cw_wz);
			// ִ�в�ѯ����
			rs = psmt.executeQuery();
			// ѭ����ȡ������е���Ϣ����װ��positionʵ���У���ʹ��positionList���ϱ���
			while (rs.next()) {
				PosiTion position = new PosiTion();
				position.setCw_no(rs.getString("cw_no"));
				position.setCw_wz(rs.getString("cw_wc"));
				position.setCw_user(rs.getString("cw_user"));
				position.setCw_state(rs.getString("cw_state"));// ״̬
				position.setCw_id(rs.getInt("cw_id"));
				position.setCw_type(rs.getInt("cw_type"));// ����
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
			// �ر����ݿ�����
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		return positionList;
	}

	/**
	 * ʵ�ָù��ܷ���--����ʵ��������Ϣ
	 */
	@Override
	public boolean updatePosi(PosiTion position) throws AppException {
		boolean flag = false;
		System.out.println(position.getCw_type() + "           updatePosi  ");
		// �������ݿ����Ӷ���Ԥ�������ͽ����
		Connection conn = null;
		PreparedStatement psmt = null;
		int rs = 0;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣺���³�λ��������Ϣ
			String sql = "UPDATE `t_position` SET `cw_no`=?, `cw_wc`=?, `cw_user`=?,`cw_state`=?, `cw_type`=? WHERE `cw_id`=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ����ռλ��������ֵ
			psmt.setString(1, position.getCw_no());
			psmt.setString(2, position.getCw_wz());
			psmt.setString(3, position.getCw_user());
			psmt.setString(4, position.getCw_state());
			psmt.setInt(5, position.getCw_type());
			psmt.setInt(6, position.getCw_id());
			// �ǵ��ɹ��������ݵ����ݿ�ʱ������᷵��һ������1������
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.updataPosi");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.dao.impl.PosiTionDaoImpl.updataPosi");
		} finally {
			// �ر����ݿ���������ͷ���Դ
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
	 * ʵ�ָù��ܷ���--��ѯ��λ�Ŷ�Ӧ�ĳ�λ״̬�������ѯ��״̬��Ҫ�ı��״̬��ͬ�ͷ���false�����߾ͽ��и���
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
			// ִ�в�ѯ����
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
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(null);
			DBUtil.closeStatement((Statement) psmt);
			DBUtil.closeConnection(conn);
		}
		// System.out.println(flag + "3");
		return flag;
	}
}
