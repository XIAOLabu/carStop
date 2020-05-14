package cn.gx.czz.util;

/**
 * ���ݿ⹤����
 * @author ASUS
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/cardb?useUnicode=true&characterEncoding=utf8";
	private static String user = "root"; // ���ݿ��˻�
	private static String password = "123456"; // ���ݿ�����

	static { // �����ʱ��ִ�иþ�̬�����
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��....");
		}
	}

	/**
	 * �������ݿ�����
	 * 
	 * @return �������ӳɹ����������ݿ����Ӷ��󣻷��߷���null
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password); // �������ݿ�����
			System.out.println("�������ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ݿ��ѯָ��
	 * 
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		try {
			if ((st != null) && (!st.isClosed())) {
				System.out.println("�ر����ݿ��ѯָ��");
				st.close();
				st = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر����ݿ��ѯ�����
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if ((rs != null) && (!rs.isClosed())) {
				System.out.println("�ر����ݿ��ѯ�����");
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param Connection���ݿ����Ӷ���
	 */
	public static void closeConnection(Connection conn) {
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
				conn = null;
				System.out.println("�ر����ݿ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
