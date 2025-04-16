package test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.Timestamp;


public class ReserveForm1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JSpinner spinner;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveForm1 frame = new ReserveForm1();
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
	public ReserveForm1() {
		setTitle("예약자 정보 확인창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("예약자 정보 확인");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 66, 205, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("예약자명 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(-34, 167, 205, 65);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("연락처 :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(-34, 261, 205, 65);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(122, 179, 269, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 264, 269, 44);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("인원수 :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(-34, 358, 205, 65);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("확인");
//		btnNewButton.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        String name = textField.getText();
//		        String contact = textField_1.getText();
//		        int people = (int) spinner.getValue();
//		        // 예약 정보 처리 로직 추가
//		        JOptionPane.showMessageDialog(null, "예약 정보 확인 완료!");
//		    }
//		});
		
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(159, 482, 168, 65);
		contentPane.add(btnNewButton);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1)); // 최소 1명, 최대 20명
		spinner.setFont(new Font("굴림", Font.PLAIN, 18));
		spinner.setBounds(122, 358, 56, 65);
		contentPane.add(spinner);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int userCount = (int) spinner.getValue();
                String userId = "ondal";
                int restId = 1;
                Timestamp revTime = new Timestamp(System.currentTimeMillis());

                DatabaseHelper.insertUserReservation(userId, restId, userCount, revTime);
                JOptionPane.showMessageDialog(null, "예약 완료되었습니다!");
            }
        });
	}
}
