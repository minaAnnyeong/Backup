package login_admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginAdminDBConn { // 접속객체 생성하는 클래스
	// 그래서 이 접속객체를 공통으로 사용할 예정
	private Connection con;

	public Connection getConnection() { // 접속객체 con을 꺼내는 메소드
		return con;
	}

	// 생성자
	public LoginAdminDBConn() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("접속 확인됨");
	}

}
