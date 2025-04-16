package login_admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import signup_user.SignupUserDAO;
import signup_user.SignupUserVO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class LoginAdminMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 640;
	private JTextField textField_id;
	private JPasswordField passwordField_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdminMain frame = new LoginAdminMain();
					frame.setVisible(true); // 화면 보이게 하기
//					frame.setResizable(false); // 화면 크기 조정 가능 여부
					frame.setSize(WIDTH, HEIGHT); // 창 크기 설정
					frame.setLocationRelativeTo(null); // 화면의 가운데에 창 띄우기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAdminMain() {
		setTitle("일반손님 로그인");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// "id" 입력칸과 라벨
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(92, 95, 280, 35);
		contentPane.add(textField_id);
		
		JLabel lbl_id = new JLabel("ID :");
		lbl_id.setLabelFor(textField_id);
		lbl_id.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_id.setBounds(23, 100, 57, 25);
		contentPane.add(lbl_id);
		
		// "password" 입력칸과 라벨
		passwordField_pw = new JPasswordField();
		passwordField_pw.setBounds(92, 171, 280, 35);
		contentPane.add(passwordField_pw);
		
		JLabel lbl_password = new JLabel("PW :");
		lbl_password.setLabelFor(passwordField_pw);
		lbl_password.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_password.setBounds(23, 176, 57, 25);
		contentPane.add(lbl_password);
		
		// 창 제목 "운영자 로그인"
		JLabel lbl_title = new JLabel("운영자 로그인");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_title.setBounds(146, 40, 176, 25);
		lbl_title.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lbl_title);
		
		// "로그인" 버튼
//		정상적으로 로그인을 하면 해당 rest_id에 관한 "예약 목록"창으로 넘어감
		JButton btn_login = new JButton("로그인");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// **버튼 누르면 action
				String id_admin = textField_id.getText(); // "id" 상자에서 꺼내오기
				String pw_admin = new String(passwordField_pw.getPassword()); // pw 상자에서 꺼내오기
				
				// LoginAdminVO 객체 생성
				LoginAdminVO login_admin_info = new LoginAdminVO(id_admin, pw_admin);
				// SignupUserDAO 
				LoginAdminDAO login_admin_dao;
			
				try {
					login_admin_dao = new LoginAdminDAO();
					//** DAO의 함수 사용하는 부분 **//
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_login.setFont(new Font("굴림", Font.BOLD, 14));
		btn_login.setBounds(156, 258, 140, 35);
		contentPane.add(btn_login);
	}
}

