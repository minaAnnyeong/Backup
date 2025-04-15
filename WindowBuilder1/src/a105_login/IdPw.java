package a105_login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class IdPw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPw;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdPw frame = new IdPw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IdPw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldPw = new JTextField();
		textFieldPw.setBounds(71, 52, 150, 21);
		contentPane.add(textFieldPw);
		textFieldPw.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(71, 10, 150, 21);
		contentPane.add(textFieldId);
		
		JButton btnNewButton = new JButton("눌러봐");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// "눌러봐" 버튼을 클릭하면 이 IdPw 창이 닫히고 Main2창으로 넘어간다
				
				// 단 입력한 id, pw 정보 가지고 가야 함
				dispose(); // 개발자가 직접 메모리 해제 (frame 닫기)
				setVisible(false); // IdPw창 안보이게
				
				String id = textFieldId.getText(); // id 상자에서 id꺼내오기
				String pw = textFieldPw.getText(); // pw 상자에서 pw꺼내오기
				new Main2(id, pw).setVisible(true); // Main2창의 *객체를 생성* 후 보이게
				
				
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBounds(149, 132, 114, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblId = new JLabel("id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.BOLD, 12));
		lblId.setBounds(12, 13, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("pw");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("굴림", Font.BOLD, 12));
		lblPw.setBounds(12, 55, 57, 15);
		contentPane.add(lblPw);
		
		
	}
}
