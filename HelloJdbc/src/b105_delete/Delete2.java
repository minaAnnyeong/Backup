package b105_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
//		Q) 키보드로 퇴사한 사원아이디(id)를 입력받아 DB에서 삭제하시오. (단, 동명이인없다고 가정한다.)
		
		String sql2 = "delete from teltable where id = ?";
		
		PreparedStatement pst1 = con1.prepareStatement(sql2);
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("퇴사한 사원 아이디? ");
		int id2 = sc1.nextInt();
		
		pst1.setInt(1, id2);
		
		int rowcnt2 = pst1.executeUpdate();
		System.out.println("처리 행수: " + rowcnt2);
		con1.close();
		sc1.close();
		System.out.println("접속 끝");
	}

}
