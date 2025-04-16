package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class DatabaseHelper {

    // **1. 메뉴 정보 저장 (INSERT 또는 UPDATE)**
    public static void saveToDatabase(String foodName, int count, int price, int restId, int menuId) {
        try {
            DBUtil db = new DBUtil();
            Connection conn = db.getConnection();

            String sql = "MERGE INTO menu m " +
                         "USING (SELECT ? AS menu_id FROM dual) temp " +
                         "ON (m.menu_id = temp.menu_id) " +
                         "WHEN MATCHED THEN " +
                         "    UPDATE SET m.menu_count = ? " +
                         "WHEN NOT MATCHED THEN " +
                         "    INSERT (menu_id, rest_id, menu_name, menu_price, menu_count) " +
                         "    VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, menuId);   
            pstmt.setInt(2, count);    
            pstmt.setInt(3, menuId);   
            pstmt.setInt(4, restId);
            pstmt.setString(5, foodName);
            pstmt.setInt(6, price);
            pstmt.setInt(7, count);

            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertUserReservation(String userId, int restId, int userCount, Timestamp revTime) {
        try {
            DBUtil db = new DBUtil();
            Connection conn = db.getConnection();

            String sql = "INSERT INTO user_rsv (user_rsv_id, user_id, rest_id, user_count, rev_time) " +
                         "VALUES (user_rsv_seq.NEXTVAL, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setInt(2, restId);
            pstmt.setInt(3, userCount);
            pstmt.setTimestamp(4, revTime);

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}