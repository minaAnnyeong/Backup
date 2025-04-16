package login_admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import signup_user.SignupUserDBConn;

public class LoginAdminDAO {
	// DB와 연결 준비
	private Connection con; // new ..DAO로 객체 생성시마다 접속객체 가져옴
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public LoginAdminDAO() throws ClassNotFoundException, SQLException { // DAO 생성자
		con = new SignupUserDBConn().getConnection(); // 객체.메소드()
	}

	// ** 함수 작성 **//
	// 실제 네트워크 세션 같은거 사용xx
	// 로그인 정보가 admin_acc의 정보와 맞는지 확인하고 문자열 admin_id를 "예약 정보 확인"창 소스쪽으로 넘김

	// 0) 성공적으로 로그인 한 후 운영자 아이디 id_admin를 반환하는 함수
	// ** **//

	// 1) 운영자id가 DB에 존재하는지 확인하는 함수
	public boolean isExist(String id) {
		try {
			pstmt = con.prepareStatement("SELECT * FROM admin_acc WHERE admin_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true; // admin_acc에 id있으면 true반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false; // 없으면 false
	}

	// 2) 운영자 id와 비번이 일치하는지 확인하는 함수 ** 1)d 와 sql문이 유사한데 두 함수를 취합할 수 있는지?
	public boolean isIdPwCorrect(LoginAdminVO login_info) throws SQLException {
		pstmt = con.prepareStatement("SELECT admin_pw FROM admin_acc WHERE admin_id = ?");
		pstmt.setString(1, login_info.getId());
		rs = pstmt.executeQuery();
		return false;
	}

}
