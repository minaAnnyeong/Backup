package signup_user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// 같은 패키지라서 import불필요 ? 
//import SignupUserVO;
//import SignupUserDAO;

public class SignupUserMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 640;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_id;
	private JPasswordField PasswordField_pw;
	private JPasswordField PasswordField_pw_re;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	// main 쪽에 회원가입 정보와 DB를 연결하는 DAO클래스 객체 생성 < ?
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		SignupUserDAO sudao = new SignupUserDAO();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupUserMain frame_signupuser = new SignupUserMain();
					frame_signupuser.setVisible(true); // 창 보이게 하기
//					frame_signupuser.setResizable(false); // 화면 크기 조정 가능 여부
					frame_signupuser.setSize(WIDTH, HEIGHT); // 창 크기 설정
					frame_signupuser.setLocationRelativeTo(null); // 화면의 가운데에 창 띄우기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// "회원 가입" 창 설계
	public SignupUserMain() {
		setTitle("회원가입");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// "이름" 입력칸, 라벨
		textField_name = new JTextField();
		textField_name.setBounds(100, 100, 280, 35);
		contentPane.add(textField_name);
		textField_name.setColumns(10);

		JLabel lbl_name = new JLabel("이름 :");
		lbl_name.setLabelFor(textField_name);
		lbl_name.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_name.setBounds(31, 105, 57, 25);
		contentPane.add(lbl_name);

		// "연락처" 입력칸, 라벨
		textField_tel = new JTextField();
		textField_tel.setColumns(10);
		textField_tel.setBounds(100, 170, 280, 35);
		contentPane.add(textField_tel);

		JLabel lbl_tel = new JLabel("연락처 :");
		lbl_tel.setLabelFor(textField_tel);
		lbl_tel.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_tel.setBounds(22, 177, 57, 25);
		contentPane.add(lbl_tel);

		// "ID" 입력칸, 라벨
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(100, 240, 280, 35);
		contentPane.add(textField_id);

		JLabel lbl_id = new JLabel("ID :");
		lbl_id.setLabelFor(textField_id);
		lbl_id.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_id.setBounds(49, 245, 57, 25);
		contentPane.add(lbl_id);

		// "PW" 입력칸, 라벨
		PasswordField_pw = new JPasswordField();
		PasswordField_pw.setBounds(100, 310, 280, 35);
		contentPane.add(PasswordField_pw);

		JLabel lbl_password = new JLabel("PW :");
		lbl_password.setLabelFor(PasswordField_pw);
		lbl_password.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_password.setBounds(49, 315, 57, 25);
		contentPane.add(lbl_password);

		// "PW재입력" 입력칸, 라벨
		PasswordField_pw_re = new JPasswordField();
		PasswordField_pw_re.setBounds(100, 380, 280, 35);
		contentPane.add(PasswordField_pw_re);

		JLabel lbl_password_re = new JLabel("PW 재입력 :");
		lbl_password_re.setLabelFor(PasswordField_pw_re);
		lbl_password_re.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_password_re.setBounds(12, 385, 94, 25);
		contentPane.add(lbl_password_re);

		
		
		// 에러메세지 띄우는 라벨
		JLabel lbl_errmsg = new JLabel("");
		lbl_errmsg.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_errmsg.setForeground(new Color(128, 0, 0)); // 붉은색
		lbl_errmsg.setBounds(110, 425, 232, 33);
		lbl_errmsg.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lbl_errmsg);
		lbl_errmsg.setVisible(false);

		// "가입하기" 버튼
		JButton btn_signup = new JButton("가입하기");
		btn_signup.setFont(new Font("굴림", Font.BOLD, 14));
		btn_signup.setBounds(159, 486, 140, 35);
		contentPane.add(btn_signup);

		// "가입하기" 버튼 action
//		정상적으로 회원 정보 입력 후 "가입하기"버튼을 누르면 DB 의 user_acc테이블에 insert
//		부가기능: 1) 아이디 중복 시 오류메세지 출력 2) 비밀번호 불일치 시 오류메세지출력
		btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String name_user = textField_name.getText(); // "이름" 상자에서 꺼내오기
				String tel_user = textField_tel.getText(); // "연락처" 상자에서 꺼내오기
				String id_user = textField_id.getText(); // "id" 상자에서 꺼내오기
				String pw_user = new String(PasswordField_pw.getPassword()); // pw 상자에서 꺼내오기
				// JPasswordField의 반환값이 char[]이기 때문에 String으로 변환.
				String pw_re_user = new String(PasswordField_pw_re.getPassword()); // "pw재입력" 상자에서 꺼내오기

				// id, pw, 이름, 연락처 등 규정 검사 (((DAO에 작성 중...)))
				
				// *DB 의 user_acc 테이블에 INSERT 하는 함수* -> SignupUserDAO에서 작성한 함수로.
				// return값 = sudao.함수명();
				SignupUserDAO sudao;
				try {
					sudao = new SignupUserDAO();
								
					if (sudao.isExist(id_user)) { // id 중복 확인  
						// **user_id가 이미 테이블의 PK이기 때문에 id중복현상이 일어나면 자동으로 insertion error 뜨긴 한다.
						lbl_errmsg.setVisible(true);
						lbl_errmsg.setText("이미 존재하는 id입니다");
					} else if (sudao.isPwIncorrect(pw_user, pw_re_user)) { // 비밀번호 불일치 확인
						lbl_errmsg.setVisible(true);
						lbl_errmsg.setText("비밀번호 불일치");
					} else { // insert
						if (sudao.insert_useracc(id_user, pw_user, pw_re_user, name_user, tel_user)) {
							System.out.println("insert OK");

							dispose(); // 개발자가 직접 메모리 해제 (frame 닫기)
							setVisible(false); // "회원가입"창 닫기
							SignupComplete frame_signupcpl = new SignupComplete();
							frame_signupcpl.setVisible(true); // "회원가입완료"창의 *객체를 생성* 후 보이게
							frame_signupcpl.setLocationRelativeTo(null); // 창이 화면 가운데에 표시
						}
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// 창 제목
		JLabel lbl_title = new JLabel("일반손님 회원가입");
		lbl_title.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_title.setBounds(146, 40, 176, 25);
		contentPane.add(lbl_title);

	}

	public boolean[] errChk(String id, String pw, String pw_re) {
		boolean[] errs = new boolean[3];

		return errs;
	}
}
