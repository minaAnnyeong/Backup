//package test;
package login_admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;

public class Jtables extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtables frame = new Jtables();
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
	public Jtables() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"A_num", "B_date", "G_String", "D_String"
			}
		));
		table.setBounds(10, 80, 448, 515);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("예약자 명단");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(169, 10, 128, 62);
		contentPane.add(lblNewLabel);
		
		
	}
}
