package b103_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Insert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con1 = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "1234");
		System.out.println("접속 확인됨");
		
		String sql2 = "insert into teltable values (?,?,?,?)";
		
		PreparedStatement pst1 = con1.prepareStatement(sql2);
		// 입력: 사번 이름 전화번호 입사일 
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("사원번호는?"));
		String name = JOptionPane.showInputDialog("이름은?");
		String tel = JOptionPane.showInputDialog("전화번호는?");
		String hire_date = JOptionPane.showInputDialog("날짜는?");
		
		pst1.setInt(1, id);
		pst1.setString(2, name);
		pst1.setString(3, tel);
		pst1.setString(4, hire_date);
		
		int rowcnt2 = pst1.executeUpdate();	// < db에 insert하라
		// rowcnt2; 처리행수 위 코드에서 한 행 insert가 성공하면 처리행수는 1 나와야 한다.
		System.out.println("처리 행수: " + rowcnt2); // 0 나오면 insert실패
		
		con1.close();
	}

}
