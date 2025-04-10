/* 
 * windowbuilder + Jdbc
 * 직접 입력 방식 + JFrameX, 보통Frame o
 * */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;///////////////////
import java.util.*;

class Search2 extends Frame implements ActionListener {/////////////
	private Label la1 = new Label("search name :");
	private TextField tf1 = new TextField();
	private Button b1 = new Button("go search");
	private TextArea ta1 = new TextArea();///////////////
	private TextField tf2 = new TextField();

	// jdk/jre/lib/ext에 ojdbc8.jar
	// 접속여부 확인
	// Steven입력
	public Search2() {

		this.setLayout(null);

		la1.setSize(100, 30);// 크기
		la1.setForeground(new Color(0, 0, 255));
		la1.setBackground(new Color(255, 180, 100));
		la1.setFont(new Font("돋움", Font.BOLD, 15));
		la1.setLocation(30, 40); // 내부위치
		this.add(la1);

		tf1.setSize(200, 30);
		tf1.setForeground(new Color(0, 0, 255));
		tf1.setBackground(new Color(255, 255, 0));
		tf1.setFont(new Font("굴림", Font.BOLD, 15));
		tf1.setLocation(130, 40);// 내부위치
		this.add(tf1);

		b1.setSize(100, 30);// 버튼 크기
		b1.setForeground(new Color(0, 0, 255));
		b1.setBackground(new Color(130, 255, 100));
		b1.setFont(new Font("돋움", Font.BOLD, 15));
		b1.setLocation(400, 40); // 내부위치
		this.add(b1);// 버튼 등록
		b1.addActionListener(this); /////////////////

		ta1.setSize(500, 400);
		ta1.setForeground(new Color(0, 0, 255));
		ta1.setBackground(new Color(200, 255, 0));
		ta1.setFont(new Font("굴림", Font.BOLD, 15));
		ta1.setEditable(false);////////////////////////
		ta1.setLocation(30, 100);// 내부위치
		this.add(ta1);

		tf2.setSize(500, 30);
		tf2.setForeground(new Color(0, 0, 255));
		tf2.setBackground(new Color(255, 255, 0));
		tf2.setFont(new Font("굴림", Font.BOLD, 15));
		tf2.setLocation(30, 580);// 내부위치
		this.add(tf2);

		this.setBackground(new Color(0, 200, 0));
		this.setTitle("[사원명단]  자바는 FUN FUN FUN !!!!!!");
		this.setSize(560, 650); // 프레임 크기
		this.setVisible(true);

		addWindowListener(new WindowAdapter() { //////////////////
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e1) {//
		if (e1.getSource() == b1) { // 버튼이 눌러졌으면(이벤트)
			ta1.setText("");
			tf2.setText("");
			Connection con = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234"); // 내 이름, 비번으로 변경
																										// 후 실행
				tf2.setText("db에 접속되었습니다");
				String sql = "select first_name, last_name,phone_number from employees" + " where first_name = ?";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, tf1.getText());///////////
				ResultSet rs = st.executeQuery();
				// String str1="";

				String str1 = String.format("%20s\t%25s\n\n", "[이   름]", "[전 화 번 호]");
				if (rs.next()) {/////////////////
					do {
						String fname = rs.getString(1);// firstname
						String lname = rs.getString(2);// lastname
						String phone = rs.getString(3);// phone
						str1 += String.format("%-20s%-20s%-20s\n", fname, lname, phone);
					} while (rs.next()); // str1 += fname+ " " + lname + "\t" +phone+"\n";
					ta1.setText(str1);
				} else
					ta1.setText("그런 이름은 없습니다");
				con.close(); // tf2.setText("db접속해제");
			} catch (ClassNotFoundException e) {
				tf2.setText("클래스경로 또는 드라이버 error");
			} catch (SQLException e) {
				tf2.setText("연결 error");
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}

public class Search {
	public static void main(String[] args) {
		Search2 s2 = new Search2();
	}

}
