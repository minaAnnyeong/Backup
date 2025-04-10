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
	public ArrayList<TelInfoVO> getAllInfo() throws SQLException{
		ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO>();
		String sql = "SELECT * FROM TelTable5 ORDER BY id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery(); // (1) 종이박스에 전체사원넣고
		
		while(rs.next()) { // (2) 종이박스에 한명씩 꺼내
			int id = rs.getInt("id");
			// id: 자바의 변수명 // id: db의 컬럼명
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d");
			
			TelInfoVO tv = new TelInfoVO(id, name, tel, d); // (3) 객체생성 
		}
		return tiarray;
	}
	
}
