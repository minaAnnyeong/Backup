package jtables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import testDAO.InfoDAO;
import testinfoVO.InfoVO;

import javax.swing.JTable;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Jtables() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InfoDAO R_dao = new InfoDAO();
		
		
		
		ArrayList<InfoVO> rev_Array = R_dao.getAllInfo();
		
		String[][] R_Array = new String[rev_Array.size()][4];
		
		// 행마다 객체, 필드 값을 보관하는 방식
		
		SimpleDateFormat dnt = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
		
		for(int i = 0; i < rev_Array.size(); i++) {
			InfoVO vo = rev_Array.get(i);
			R_Array[i][0]=vo.getAlpha();
			R_Array[i][1]=dnt.format(vo.getBeta());
			R_Array[i][2]=vo.getGamma();
			R_Array[i][3]=vo.getDelta();
		}
		
		String[] coulumNames = {"예약자명","예약시간","메뉴","전화번호"};
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(R_Array,coulumNames
		));
		table.setBounds(10, 80, 448, 515);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("예약자 명단");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 128, 62);
		contentPane.add(lblNewLabel);
		
		
	}
}
