package a01_windowss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import a03_signup_user.SignupUserMain;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class A00_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A00_main frame = new A00_main();
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
	public A00_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("운영자 로그인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
                new B01_AdminLogin().setVisible(true);
			}
		});
		btnNewButton.setBounds(294, 10, 164, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("환영합니다!!!");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 88, 448, 92);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("손님 로그인");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
                new A01_CustomerLogin().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 75));
		btnNewButton_1.setBounds(10, 190, 448, 159);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("손님 가입");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
                new SignupUserMain().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 80));
		btnNewButton_1_1.setBounds(10, 359, 448, 159);
		contentPane.add(btnNewButton_1_1);
	}
}
