package b104_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Update2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
//		Q) 키보드로 사원명과 변경될 전화번호를 입력받아 DB를 update하시오. (단, 동명이인이 없다고 가정)
		
		String sql2 = "update teltable set tel = ? where name = ?";
		
		PreparedStatement pst1 = con1.prepareStatement(sql2);
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("수정하기위해 검색할 이름은? ");
		String name2 = sc1.nextLine();
		
		System.out.println("수정 후 전화번호는? ");
		String tel2 = sc1.nextLine();
		
		// ? 위치한 순서대로 작성
		pst1.setString(1, tel2);
		pst1.setString(2, name2);
		
		pst1.executeUpdate();
		
		/*
		String name = JOptionPane.showInputDialog("이름은?");
		String tel = JOptionPane.showInputDialog("변경할 전화번호는?");
		
		pst1.setString(1, tel);
		pst1.setString(2, name);
		
		int rowcnt2 = pst1.executeUpdate();
		System.out.println("처리 행수: " + rowcnt2);
		*/
		
		con1.close();
		sc1.close();
	}

}
