package b102_like;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Like2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("이름의 일부를 입력(첫글자 대문자로)");
		String irum = sc1.next();
		
//employee_id, first_name, hire_date
//		Q) 이름이 S로 시작하는 사원 정보를 출력하시오. ; 사원아이디, 이름, 입사일 출력
		String sql2 = "select *" 
					+ " from employees" 
					+ " where first_name like ?"; // << S%

		PreparedStatement ps2 = con1.prepareStatement(sql2);
		ps2.setString(1, irum + "%");
		
		ResultSet rs2 = ps2.executeQuery();
		
		while(rs2.next()) {
			int id = rs2.getInt("employee_id");
			String fname =  rs2.getString("first_name");
			String hdate = rs2.getString("hire_date");
			System.out.println(rs2.getRow() + "\t" + id + "\t" + fname + "\t" + hdate);
		}
		
		con1.close();
		sc1.close();
	}

}
