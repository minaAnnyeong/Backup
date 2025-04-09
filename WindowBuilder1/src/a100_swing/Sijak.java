package a100_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Sijak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel = new JLabel(); // *
	private JButton btnClick_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sijak frame = new Sijak();
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
	public Sijak() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnClick = new JButton("눌러봐");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// getText(); 글자 가져오기 setText(); 글자 넣기
				lblNewLabel.setText("안녕~ 자바");
				// 아래 lblNewLabel 객체의 선언줄만 전역으로 옮긴다.
			}
		});
		btnClick.setFont(new Font("굴림", Font.BOLD, 20));
		btnClick.setBounds(201, 121, 121, 48);
		contentPane.add(btnClick);

//		JLabel lblNewLabel = new JLabel("버튼 누르면 글씨가 나온다"); // *전역객체로 변경
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBackground(new Color(255, 255, 128));
		lblNewLabel.setBounds(228, 10, 221, 36);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\r\n");
		textField.setFont(new Font("굴림", Font.BOLD, 12));
		textField.setBounds(254, 56, 173, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnClick_1 = new JButton("또 눌러봐");
		btnClick_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("나도 안녕"); // 이미 전역으로 선언 돼있어서 오류 없다.
			}
		});
		btnClick_1.setFont(new Font("굴림", Font.BOLD, 18));
		btnClick_1.setBounds(349, 121, 121, 48);
		contentPane.add(btnClick_1);
		
		btnNewButton = new JButton("ice cream");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\ice-cream-22.jpg"));
		btnNewButton.setBounds(12, 10, 121, 111);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon(Sijak.class.getResource("/img/ice-cream-22.jpg")));
		btnNewButton_1.setBounds(12, 179, 118, 93);
		contentPane.add(btnNewButton_1);
	}
}
