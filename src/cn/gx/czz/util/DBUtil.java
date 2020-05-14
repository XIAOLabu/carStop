package cn.gx.czz.util;

/**
 * 数据库工具类
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
	private static String user = "root"; // 数据库账户
	private static String password = "123456"; // 数据库密码

	static { // 类加载时，执行该静态代码段
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败....");
		}
	}

	/**
	 * 创建数据库连接
	 * 
	 * @return 创建连接成功，返回数据库连接对象；否者返回null
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password); // 创建数据库连接
			System.out.println("创建连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库查询指令
	 * 
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		try {
			if ((st != null) && (!st.isClosed())) {
				System.out.println("关闭数据库查询指令");
				st.close();
				st = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库查询结果集
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if ((rs != null) && (!rs.isClosed())) {
				System.out.println("关闭数据库查询结果集");
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param Connection数据库连接对象
	 */
	public static void closeConnection(Connection conn) {
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
				conn = null;
				System.out.println("关闭数据库");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
