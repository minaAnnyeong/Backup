package login_admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import signup_user.SignupComplete;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginAdminMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 640;
	private JTextField id;
	private JPasswordField password;

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
		setTitle("운영자 로그인");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(92, 95, 280, 35);
		contentPane.add(id);
		
		password = new JPasswordField();
		password.setBounds(92, 171, 280, 35);
		contentPane.add(password);
		
		JLabel lbl_id = new JLabel("ID :");
		lbl_id.setLabelFor(id);
		lbl_id.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_id.setBounds(23, 105, 57, 25);
		contentPane.add(lbl_id);
		
		JLabel lbl_password = new JLabel("PW :");
		lbl_password.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_password.setBounds(23, 181, 57, 25);
		contentPane.add(lbl_password);
		
		JLabel lbl_title = new JLabel("운영자 로그인");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_title.setBounds(146, 40, 176, 25);
		contentPane.add(lbl_title);
		
		JButton btn_login = new JButton("로그인");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// "로그인" 버튼을 클릭하면 이 창이 닫히고 "예약목록"창으로 넘어간다
				dispose(); // 개발자가 직접 메모리 해제 (frame 닫기)
				setVisible(false); // "로그인"창 닫기
				Jtables frame_rsvlist= new Jtables();
				frame_rsvlist.setVisible(true); // ""창의 *객체를 생성* 후 보이게
				frame_rsvlist.setLocationRelativeTo(null); // 창이 화면 가운데에 표시
			}
		});
		btn_login.setFont(new Font("굴림", Font.BOLD, 14));
		btn_login.setBounds(156, 258, 140, 35);
		contentPane.add(btn_login);
	}
}
