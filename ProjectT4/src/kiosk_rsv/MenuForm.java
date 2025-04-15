package kiosk_rsv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_11;
	private JTextField textField_1;
	private JTextField textField_10;
	private JTextField textField_9;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_12;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JTextField textField_13;
	private JTextArea textarea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuForm frame = new MenuForm();
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
	public MenuForm() {
		setTitle("메뉴 선택창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식1");
			}
		});
		textField_1.setBounds(5, 6, 116, 130);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식2");
			}
		});
		textField_2.setBounds(121, 6, 116, 130);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식3");
			}
		});
		textField_3.setBounds(237, 6, 116, 130);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식4");
			}
		});
		textField_4.setBounds(353, 6, 116, 130);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식5");
			}
		});
		textField_5.setBounds(5, 135, 116, 130);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식6");
			}
		});
		textField_6.setBounds(121, 135, 116, 130);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식7");
			}
		});
		textField_7.setBounds(237, 135, 116, 130);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식8");
			}
		});
		textField_8.setBounds(353, 135, 116, 130);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식9");
			}
		});
		textField_9.setBounds(5, 264, 116, 130);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식10");
			}
		});
		textField_10.setBounds(121, 264, 116, 130);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식11");
			}
		});
		textField_11.setBounds(237, 264, 116, 130);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("음식12");
			}
		});
		textField_12.setBounds(353, 264, 116, 130);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		btnNewButton = new JButton("선택");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false); 
				new ReserveForm().setVisible(true); // 이 창이 닫히고 예약폼 창이 나타남
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(124, 508, 187, 72);
		contentPane.add(btnNewButton);
		
		textField_13 = new JTextField();
		textField_13.setText("선택한 메뉴 확인 창");
		textField_13.setBounds(5, 393, 459, 30);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 421, 459, 66);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
	}
}
