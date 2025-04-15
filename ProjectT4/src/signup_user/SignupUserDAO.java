package signup_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// 같은 패키지에 넣으면 import 불필요 ?
//import SignupUserDBConn;
//import SignupUserVO;

public class SignupUserDAO {
	// DAO -DB와 만나는 java파일

	// DB와 연결 준비
	private Connection con; // new ..DAO로 객체 생성시마다 접속객체 가져옴
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public SignupUserDAO() throws ClassNotFoundException, SQLException { // DAO 생성자
		con = new SignupUserDBConn().getConnection(); // 객체.메소드()
	}
	
	// user_acc테이블에 (id, pw, 연락처, 이름) 삽입Insert하는 함수
	public boolean insert_useracc(String id, String pw, String pw_re, String name, String tel) {
			try {
				pstmt = con.prepareStatement("INSERT INTO user_acc VALUES(?,?,?,?)");
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, tel);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Insertion Error");
				return false;
			}
			return true;
	}
	
	// 예외 처리
	// 1) 유저id가 DB에 이미 존재하는 유저id인지 확인하는 함수
	public boolean isExist(String id) {
		try {
		    pstmt = con.prepareStatement("select * from user_acc where user_id = ?");
		    pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    
		    // id가 중복이면 true반환
		    if(rs.next()) {
		    	return true;
		    }
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		return false;
	}
	
	// 2) pw와 pw재입력 값이 서로 다른지 확인하는 함수
	public boolean isPwIncorrect(String pw, String pw_re) {
		if(!pw_re.equals(pw)) {
			return true;
		}
		return false;
	}
	
	// 3) id, pw, 이름, 연락처 입력값이 규정에 맞는지 확인하는 함수
//	id : 
//	pw : "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$" // 영문,특문,숫자 8~20자
//	public boolean isInputIncorrect(String id, String)
	
}
