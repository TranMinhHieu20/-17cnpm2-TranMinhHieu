package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static final String DB_URL = "jdbc:sqlserver://LAPTOP\\SQLEXPRESS:1433;databaseName=QLSanPham;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
	private static final String USER_NAME = "sa";
	private static final String PASSWORD = "123456789";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver không tìm thấy: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Kết nối thất bại: " + e.getMessage());
		}
		return conn;
	}

//	public static void main(String[] args) {
//		Connection conn = getConnection();
//		if (conn == null) {
//			System.out.println("no");
//		} else {
//			System.out.println("yes");
//		}
//	}
}
