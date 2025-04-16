package telinfoDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import telinfoDBConn.TelInfoDBConn;
import telinfoVO.TelInfoVO;

public class TelInfoDAO {
	// DAO -DB와 만나는 java파일

	// CRUD
	private Connection con; // new ..DAO로 객체 생성시마다 접속객체 가져옴(생성x import o)
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public TelInfoDAO() throws ClassNotFoundException, SQLException { // DAO 생성자
		con = new TelInfoDBConn().getConnection(); // 객체.메소드()

	}

	// case 1:
	// kaga(값) 값을 받아서 처리
	// insert_nametel() 비서
	// getter, setter
	public boolean insert_nametel(int id, String name, String tel, String sDate) {
		String sql = "INSERT INTO teltable5 VALUES(?,?,?,to_date(?))";
		// sql의 to_date(x)메소드 사용하여 문자열 > 날짜형으로 자동형변환
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			// 문자"20200908" ==> 날짜Date 형으로
			pstmt.setString(4, sDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insertion Error");
			return false;
		}

		return true;
	}
	
	// case 2:
	public boolean update_nametel(int id, String tel) {
		String sql = "UPDATE teltable5 SET tel = ? WHERE id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Exception");
			return false;
		}

		return true;
	}

	// case 3:
	public boolean delete_nametel(int id) {
		String sql = "DELETE FROM teltable5 WHERE id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Deletement Fail");
			return false;
		}
		return true;
	}

	// case 4:
	// getter 개념
	public ArrayList<TelInfoVO> getAllInfo() throws SQLException {
		ArrayList<TelInfoVO> tiArray = new ArrayList<>();
		String sql = "SELECT * FROM teltable5 ORDER BY id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery(); // (1) 종이박스에 전체사원넣고

		while (rs.next()) { // (2) 종이박스에 한명씩 꺼내
			// id: 자바의 변수명 // id: db의 컬럼명
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d");

			TelInfoVO tv = new TelInfoVO(id, name, tel, d); // (3) 객체생성 ; 매 insert시마다 새 행이 담겨 add됨
			tiArray.add(tv);
		}
		return tiArray;
	}

}
