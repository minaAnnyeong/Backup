package a415;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import db.DatabaseHelper;
import db.UserRsvMenuVO;
import db.UserRsvVO;

public class A05_ReservationTime extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 640;
	private String timeSelected = "";

	private String[] timeList = { "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
			"16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30" };

	public static DatabaseHelper rsvDao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A05_ReservationTime frame_revtime = new A05_ReservationTime();
					frame_revtime.setVisible(true);
					frame_revtime.setResizable(false); // 화면 크기 조정 가능 여부
					frame_revtime.setSize(WIDTH, HEIGHT); // 창 크기 설정
					frame_revtime.setLocationRelativeTo(null); // 화면의 가운데에 창 띄우기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public A05_ReservationTime() {
		setTitle("예약 시간 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// "예약 시간 선택" 리스트
		JList list = new JList(timeList);
		list.setFont(new Font("굴림", Font.BOLD, 18));
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellHeight(50);

		// 리스트에 스트롤바 추가
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 62, 366, 231);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(list);

		// 리스트 헤더 라벨
		JLabel lblListHeader = new JLabel("예약 시간");
		lblListHeader.setBackground(Color.WHITE);
		lblListHeader.setFont(new Font("굴림", Font.BOLD, 18));
		lblListHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		lblListHeader.setHorizontalAlignment(JLabel.CENTER);
		scrollPane.setColumnHeaderView(lblListHeader);

		// 리스트 선택 action
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 리스트 중 시간 하나를 선택하여 임변수에 저장
				timeSelected = (String) list.getSelectedValue();
			}
		});

		// "예약하기" 버튼
		JButton btnRsv = new JButton("예약하기");
		btnRsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 누르면 timeSelected가 rev_time에 저장
				// ** **//
				// 선택하지 않았으면 -> 경고 팝업창
				if (timeSelected.equals("")) {
					JOptionPane.showMessageDialog(null, "시간을 선택해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				} else { // 선택한 시간이 있으면 예약하시겠습니까? 창으로 넘어감
					int result = JOptionPane.showConfirmDialog(null, "예약하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) { // 유저가 YES를 누른경우
						rsvDao.userRsvVO.setRsvTime(timeSelected);
						System.out.println("<ReservationForm PrintOut>");
		    			System.out.println("UserId: " + rsvDao.userRsvVO.getUserId());
		    			System.out.println("RestId: " + rsvDao.userRsvVO.getRestId());
		    			for(UserRsvMenuVO VOItem : rsvDao.urmVOList) {
		    				System.out.println("menuId: " + VOItem.getMenuId() + " / "
		    			 			+ "menuCount: " + VOItem.getMenuCount());
		    			}
		    			System.out.println("UserCount: " + rsvDao.userRsvVO.getUserCount());
		                System.out.println("RsvTime: " + rsvDao.userRsvVO.getRsvTime());
		                
		                try {
		                	if(DatabaseHelper.insertUserReservation(rsvDao.userRsvVO)) {
		                		// 헬퍼의 메소드로 rest_name, user_name, rsv_time 가져오기
		                		String[] rsvInfo = DatabaseHelper.getRsvInfo(rsvDao.userRsvVO);
		                		JOptionPane.showMessageDialog(null,
										"<html>예약이 확정되었습니다.<br>"
										+ "식당명: " + rsvInfo[0] + "<br>"
										+ "예약자명: " + rsvInfo[1] + "<br>"
										+ "예약시간: " + rsvDao.userRsvVO.getRsvTime() + "</html>",
										"", JOptionPane.CLOSED_OPTION);
		                	}
		                	
		                	for(UserRsvMenuVO VOItem : rsvDao.urmVOList) {
		                		DatabaseHelper.insertUserRsvMenu(rsvDao.userRsvVO, VOItem);
		                	}
		                	
		                } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                
//////////////////////////////////////////////////////////						
						// VO객체에 선택한 예약시간 timeSelected를 저장한다.
//						rsv_info.setRsvTime(timeSelected);
//						try {
//							// 최종적으로 예약 정보를 user_rsv테이블에 insert
//							if (DatabaseHelper.insertUserReservation()
//									&& DatabaseHelper.insertUserRsvMenu()) {
//								// 그리고 예약이 확정되었습니다 팝업을 예약 정보와 같이 띄움
//								JOptionPane.showMessageDialog(null,
//										"<html>예약이 확정되었습니다.<br>~임시~<br>{식당명: 식당1<br>예약자명: ondal<br>예약시간: 13:00}</hrml>",
//										"", JOptionPane.CLOSED_OPTION);
////								^ VO객체로부터 예약정보(식당명, 예약자명, 예약시간) 가져와서 String으로 출력
//							}
//						} catch (ClassNotFoundException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
						// 또는 VO객체 거치지 않고 바로 DB에 insert
//////////////////////////////////////////////////////////
					} else if (result == JOptionPane.NO_OPTION) { // 유저가 NO를 누른경우
						// 그냥 팝업창 닫음

					} else { // 유저가 그냥 닫기를 한 경우
								// 그냥 팝업창 닫음

					}
				}
			}
		});
		btnRsv.setFont(new Font("굴림", Font.BOLD, 18));
		btnRsv.setBounds(163, 420, 156, 65);
		contentPane.add(btnRsv);

	}
}
