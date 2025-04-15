package signup_user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignupComplete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 300;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupComplete frame = new SignupComplete();
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
	public SignupComplete() {
		setTitle("회원가입완료");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_txt = new JLabel("회원 가입 되었습니다.");
		lbl_txt.setBackground(new Color(255, 255, 128));
		lbl_txt.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_txt.setBounds(140, 48, 209, 76);
		contentPane.add(lbl_txt);
		
		JButton btn_confirm = new JButton("확인");
		btn_confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// "확인" 버튼 누르면 창이 닫힘
				dispose(); // 개발자가 직접 메모리 해제 (frame 닫기)
				setVisible(false); // "회원가입완료"창 닫기
			}
		});
		btn_confirm.setFont(new Font("굴림", Font.BOLD, 14));
		btn_confirm.setBounds(188, 152, 97, 35);
		contentPane.add(btn_confirm);
	}
}
