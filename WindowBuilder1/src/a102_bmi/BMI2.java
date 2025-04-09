package a102_bmi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BMI2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtKi;
	private JTextField txtMom;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI2 frame = new BMI2();
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
	public BMI2() {
		setTitle("BMI Calculrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKi = new JLabel("당신의 키는(m)");
		lblKi.setFont(new Font("굴림", Font.BOLD, 12));
		lblKi.setBounds(12, 10, 101, 23);
		contentPane.add(lblKi);

		txtKi = new JTextField();
		txtKi.setFont(new Font("굴림", Font.BOLD, 12));
		txtKi.setBounds(144, 12, 116, 21);
		contentPane.add(txtKi);
		txtKi.setColumns(10);

		JLabel lblMom = new JLabel("당신의 몸무게는(kg)");
		lblMom.setFont(new Font("굴림", Font.BOLD, 12));
		lblMom.setBounds(12, 43, 120, 23);
		contentPane.add(lblMom);

		txtMom = new JTextField();
		txtMom.setFont(new Font("굴림", Font.BOLD, 12));
		txtMom.setColumns(10);
		txtMom.setBounds(144, 45, 116, 21);
		contentPane.add(txtMom);

		JButton btnNewButton = new JButton("bmi지수 구하기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// bmi = 체중 / 키제곱
				double bmi = Double.parseDouble(txtMom.getText()) / Math.pow(Double.parseDouble(txtKi.getText()), 2);
				txtResult.setText("당신의 BMI : " + String.valueOf(Math.round(bmi * 100) / 100.0));
				// 소수점 두 자리 까지 표현
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBounds(66, 90, 131, 38);
		contentPane.add(btnNewButton);

		JLabel lblResult = new JLabel("결과");
		lblResult.setFont(new Font("굴림", Font.BOLD, 12));
		lblResult.setBounds(12, 158, 101, 23);
		contentPane.add(lblResult);

		txtResult = new JTextField();
		txtResult.setFont(new Font("굴림", Font.BOLD, 12));
		txtResult.setBounds(12, 189, 396, 84);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
	}

}
