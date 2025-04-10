package a105_login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class Main2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldId;
	private JTextField textFieldPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
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
	public Main2() {
		
	}
	
	// 디폴트 생성자의 내용을 인자 있는 생성자로 옮기기
	public Main2(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(0, 0, 160));
		textField.setBackground(new Color(255, 128, 192));
		textField.setFont(new Font("굴림", Font.BOLD, 20));
		textField.setText("나는 메인화면이야");
		textField.setBounds(36, 118, 353, 110);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		textFieldId = new JTextField();
		textFieldId.setBounds(71, 10, 150, 21);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldPw = new JTextField();
		textFieldPw.setColumns(10);
		textFieldPw.setBounds(71, 52, 150, 21);
		contentPane.add(textFieldPw);
		
		textFieldId.setText(id);
		textFieldPw.setText(pw);
	}
	
}
