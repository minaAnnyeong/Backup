package b103_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Insert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
		String sql2 = "insert into teltable values (?,?,?,?)";
		
		PreparedStatement ps2 = con1.prepareStatement(sql2);
		// 입력: 사번 이름 전화번호 입사일 
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("사원번호는?"));
		String name = JOptionPane.showInputDialog("이름은?");
		String tel = JOptionPane.showInputDialog("전화번호는?");
		String ipsail = JOptionPane.showInputDialog("날짜는?");
		
		
		ResultSet rs2 = ps2.executeQuery(sql2);

	}

}
