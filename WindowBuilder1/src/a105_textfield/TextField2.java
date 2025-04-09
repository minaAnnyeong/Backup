package a105_textfield;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextField2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String s1 = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextField2 frame = new TextField2();
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
	public TextField2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(112, 46, 196, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnStart = new JButton("New button");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sw;
				if(e.getSource() == btnStart && sw == 0) {
					btnStart.setEnabled(false);
						// b1.setVisible(false);
					textField.scheduleAtFixedRate(new TimerTask(){
						public void run() {
							s1 = s1.substring(1, s1.length()) + s1.substring(0,1);
							txtDisplay.setText(s1);
						}
					}, 0, 255); // schedule - end
				}// if-end
				sw = 1;
			}
		});
		btnStart.setBounds(162, 111, 97, 23);
		contentPane.add(btnStart);
		
		JButton btnStart_1 = new JButton("New button");
		btnStart_1.setBounds(162, 163, 97, 23);
		contentPane.add(btnStart_1);
	}

}
