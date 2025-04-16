package a415;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "hr";       // 오라클 사용자 이름
        String password = "hr";   // 비밀번호

        return DriverManager.getConnection
        		("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
    }
}
