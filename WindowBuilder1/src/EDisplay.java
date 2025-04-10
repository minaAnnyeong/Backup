
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class EDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField txtDisplay;

	// ----------------
	static int sw = 0;///////////////
	static String s1 = "              I LOVE YOU";///////////////

	Timer t1 = new Timer();

	// LOVE
	// OVEL
	// ----------------------------------------------------
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EDisplay frame = new EDisplay();
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
	public EDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDisplay = new JTextField();//////////
		txtDisplay.setFont(new Font("굴림", Font.BOLD, 23));
		txtDisplay.setBounds(75, 15, 294, 33);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);

		JButton btnStart = new JButton("\uC2DC~\uC791");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 시작 버튼 누를 때 발생하라 이벤트
				// t1.scheduleAtFixedRate(new TimerTask(){ }, 0, 250);
				// ----------------------------------------------
				if (e.getSource() == btnStart && sw == 0) { //
					btnStart.setEnabled(false);
					// b1.setVisible(false);
					t1.scheduleAtFixedRate(new TimerTask() {
						public void run() { //
							s1 = s1.substring(1, s1.length()) + s1.substring(0, 1);
							txtDisplay.setText(s1);//
							// LOVE --> OVEL --> VELO ......
						} // run-end
					}, 0, 250);// 250밀리초 마다 문장 변화/////////// schedule-end ////////////////
				} // if-end
				sw = 1; // 두 번 시작 못함
			}// actionPerformed-end
		});
		// -------------------------------------------------------

		btnStart.setBackground(Color.PINK);
		btnStart.setBounds(135, 100, 125, 29);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("\uB044~\uC755");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStop) {
					t1.cancel();///////
				}

			}
		});
		btnStop.setBackground(Color.ORANGE);
		btnStop.setBounds(135, 174, 125, 29);
		contentPane.add(btnStop);
	}

}
