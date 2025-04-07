package b101_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Q)
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection
				("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
		String sql2 = "";
		
		PreparedStatement ps2 = con1.prepareStatement(sql2);
		ResultSet rs2 = ps2.executeQuery(sql2);
		
		Scanner sc1 = new Scanner(System.in);
		int salary_bada = sc1.nextInt();
		ps2.setInt(1, salary_bada);
		
		
		while(rs2.next()) {
			String fname =  rs2.getString("이름");
			int salary = rs2.getInt("봉급");
			System.out.println(rs2.getRow() + "\t" + fname + "\t" + salary);
		}
		
		con1.close();
		
	}

}
