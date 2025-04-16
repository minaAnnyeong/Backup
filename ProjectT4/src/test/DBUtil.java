//package test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConn {
//
//	public Connection getConnection() throws ClassNotFoundException, SQLException {
//
//		Connection con1 = null;
//
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		con1 = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/XE", "hr", "hr");
//
//		System.out.println("DB 접속 성공");
//
//		return con1;
//	}
//}

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/XE", "hr", "hr");
		System.out.println("DB 접속 성공");
		return con;
	}
}