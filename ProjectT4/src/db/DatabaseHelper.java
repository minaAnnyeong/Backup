package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseHelper {
	private Connection conn; // new ..DAO로 객체 생성시마다 접속객체 가져옴(생성x import o)
	PreparedStatement pstmt = null;
	private static ResultSet rs = null;

//////////////////////////////////////////////////////////////////////
	// 예약 정보를 데이터베이스에 삽입하는 메소드
	public static boolean insertUserReservation(String userId, int restId, int userCount, java.sql.Timestamp revTime)
			throws ClassNotFoundException {
		String sql = "INSERT INTO user_rsv (user_rsv_id, user_id, rest_id, user_count, rev_time) "
				+ "VALUES (user_rsv_seq.NEXTVAL, ?, ?, ?, ?)";

		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, userId);
			stmt.setInt(2, restId);
			stmt.setInt(3, userCount);
			stmt.setTimestamp(4, revTime);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("예약 정보 삽입 오류: " + e.getMessage());
			return false;
		}
	}
//////////////////////////////////////////////////////////////////  

	// 예약 정보를 데이터베이스에 삽입하는 메소드
	public static boolean insertUserReservation(UserRsvVO userRsvVO) throws ClassNotFoundException {
		String sql = "INSERT INTO user_rsv (user_rsv_id, user_id, rest_id, user_count, rev_time) "
				+ "VALUES (user_rsv_seq.NEXTVAL, ?, ?, ?, ?)";

		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, userRsvVO.getUserId());
			stmt.setInt(2, userRsvVO.getRestId());
			stmt.setInt(3, userRsvVO.getUserCount());
//            stmt.setTimestamp(4, revTime);
			stmt.setString(4, userRsvVO.getRsvTime());

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("예약 정보 삽입 오류: " + e.getMessage());
			return false;
		}
	}

	// 특정 사용자의 예약 목록을 조회하는 메소드
	public static void getUserReservations(String userId) {
		String sql = "SELECT * FROM user_rsv WHERE user_id = ?";

		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, userId); // 사용자의 ID로 예약 정보 조회

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int userRsvId = rs.getInt("user_rsv_id");
					int restId = rs.getInt("rest_id");
					int userCount = rs.getInt("user_count");
					java.sql.Timestamp revTime = rs.getTimestamp("rev_time");

					// 예약 정보 출력
					System.out.println("Reservation ID: " + userRsvId + ", Restaurant ID: " + restId + ", User Count: "
							+ userCount + ", Reservation Time: " + revTime);
				}
			}

		} catch (SQLException e) {
			System.err.println("사용자 예약 정보 조회 오류: " + e.getMessage());
		}
	}

//////////////////////////////////////////////////////////
	// 메뉴와 예약 정보를 `user_rsv_menu` 테이블에 저장하는 메소드
	public static boolean insertUserRsvMenu(int userRsvId, int menuId, int quantity) {
		String sql = "INSERT INTO user_rsv_menu (user_rsv_menu_id, user_rsv_id, menu_id, menu_count) "
				+ "VALUES (user_rsv_menu_seq.NEXTVAL, ?, ?, ?)";

		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, userRsvId);
			stmt.setInt(2, menuId);
			stmt.setInt(3, quantity);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("메뉴 예약 정보 삽입 오류: " + e.getMessage());
			return false;
		}
	}
/////////////////////////////////////////////////////////

	// 메뉴와 예약 정보를 `user_rsv_menu` 테이블에 저장하는 메소드
	public static boolean insertUserRsvMenu(UserRsvVO userRsvVO, UserRsvMenuVO urmVO) {
		String sql = "INSERT INTO user_rsv_menu (user_rsv_menu_id, user_rsv_id, menu_id, menu_count) "
				+ "VALUES (user_rsv_menu_seq.NEXTVAL, ?, ?, ?)";

		String sqlGetSeq = "SELECT user_rsv_id FROM user_rsv WHERE user_id = ?";
		int userRsvId = -1;
		try (Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlGetSeq);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, userRsvVO.getUserId());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				userRsvId = rs.getInt("user_rsv_id");
			}

			//int rowsAffected = pstmt.executeUpdate();
//			return rowsAffected > 0;
			
			stmt.setInt(1, userRsvId);
			stmt.setInt(2, urmVO.getMenuId());
			stmt.setInt(3, urmVO.getMenuCount());

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("메뉴 예약 정보 삽입 오류: " + e.getMessage());
			return false;
		}

	
	}

	// 메뉴 ID를 조회하는 메소드
	public static int getMenuIdFromFood(String food) {
		String sql = "SELECT menu_id FROM menu WHERE menu_name = ?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, food);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("menu_id");
				}
			}

		} catch (SQLException e) {
			System.err.println("메뉴 ID 조회 오류: " + e.getMessage());
		}
		return -1; // 메뉴가 없을 경우 -1 반환
	}
	
	public static String[] getRsvInfo(UserRsvVO userRsvVO) {
		String[] result = new String[2];
		String sqlRestName = "SELECT rest_name FROM resta_se WHERE rest_id = ?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlRestName)) {

			stmt.setInt(1, userRsvVO.getRestId());

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					result[0] = rs.getString("rest_name");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlUserName = "SELECT user_name FROM user_acc WHERE user_id = ?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlUserName)) {

			stmt.setString(1, userRsvVO.getUserId());

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					result[1] = rs.getString("user_name");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static UserRsvVO userRsvVO = new UserRsvVO();

	public static UserRsvMenuVO urmVO = new UserRsvMenuVO();

	public static ArrayList<UserRsvMenuVO> urmVOList = new ArrayList<UserRsvMenuVO>();
}