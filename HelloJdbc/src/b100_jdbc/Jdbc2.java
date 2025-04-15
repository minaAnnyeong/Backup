package b100_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		* jdbc는 java와 db사이를 연동. 연동에 드라이버 프로그램이 필요하다.
		* 드라이버; 오라클, Mssql, mysql에 따라 상이
		* 드라이버 >> sqlDeveloper와 Oracle에 기본 탑재되어잇음
		* 경로: sql설치경로 sqldeveloper\jdbc\lib 안의 "ojdbc8" Jar파일
		* 
		* 
		*/
		
  		// 접속 객체 선언
		Connection con1 = null;
		// 오라클의 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 맨 뒤의 두 파라미터는 sqldeveloper할 때 접속 id와 비번.
		con1 = DriverManager.getConnection
				("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		System.out.println("접속 확인됨");
		
//		Q) employees 테이블에서 사원의 전체 명단을 검색하여 java로 출력하시오.
//		(단, 출력은 사번, 사원 명 과 입사일을 출력한다.)
		Scanner sc1 = new Scanner(System.in);
		String irum = sc1.next();
		String sql2 = "select * from employees"
					+ " where upper(first_name) = '" + irum + "'";
		//
		Statement st2 = con1.createStatement();
		ResultSet rs2 = st2.executeQuery(sql2);
		
		while(rs2.next()) {
			int id = rs2.getInt("employee_id");
			String fname = rs2.getString("first_name");
			String hdate = rs2.getString("hire_date");
			String hire_date = hdate.substring(0, 10);
			System.out.println(rs2.getRow() + "\t" + id + "\t" + fname
								+ "\t" + hire_date);
		}
		sc1.close();
		con1.close();
	}

}
