package a103_kiosk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Kiosk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String msg = "";
	private String msg2 = "";
	private int sum = 0;
	private int sale = 0;
	private boolean jongroFlag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kiosk frame = new Kiosk();
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
	public Kiosk() {
		setTitle("햄버거라는");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
//		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		// 위는 마우스로 디자인탭에서 GridLayout을 창에 적용했을 때
		// (1, 0, 0, 0) > 4행 2열로 수정해야 함
		contentPane.setLayout(new GridLayout(0, 2, 30, 30));

		JLabel lblNewLabel = new JLabel("**굿버거 햄버거입니다**");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("드실 메뉴를 선택해주세요.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);

		// 디자인탭에서 버튼을 6개를 계속 넣어준다. 넣을 때 순서에 주의
		JButton btnBr1 = new JButton("매콤소스햄버거 : 4000");
		btnBr1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg += "매콤소스햄버거(4000)" + "\n";
				sum += 4000;
			}
		});
		btnBr1.setIcon(new ImageIcon(Kiosk.class.getResource("/img/burger-spicy.png")));
		btnBr1.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr1);

		JButton btnBr2 = new JButton("더블비프햄버거 : 5000");
		btnBr2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg += "더블비프햄버거(5000)" + "\n";
				sum += 5000;
			}
		});
		btnBr2.setIcon(new ImageIcon(Kiosk.class.getResource("/img/burger.png")));
		btnBr2.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr2);

		JButton btnBr3 = new JButton("야채새우햄버거 : 4500");
		btnBr3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg += "야채새우햄버거(4500)" + "\n";
				sum += 4500;
			}
		});
		btnBr3.setIcon(new ImageIcon(Kiosk.class.getResource("/img/burger-vege.png")));
		btnBr3.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr3);

		JButton btnBr4 = new JButton("토마토햄버거:5500");
		btnBr4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg += "토마토햄버거(5500)" + "\n";
				sum += 5500;
			}
		});
		btnBr4.setIcon(new ImageIcon(Kiosk.class.getResource("/img/tt.png")));
		btnBr4.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr4);

		JButton btnBr5 = new JButton("주문합니다");
		btnBr5.setForeground(Color.BLUE);
		btnBr5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				msg2 = msg + "합계금액: " + String.valueOf(sum+sale) + " 원";
				JOptionPane.showConfirmDialog
				(btnBr5, msg2, "확인하세요", JOptionPane.YES_NO_OPTION);
				// clear
				msg = "";
				msg2 = "";
				sum = 0;
			}
		});
		btnBr5.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr5);
		
		JButton btnBr6 = new JButton("취소합니다");
		btnBr6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(btnBr6, "취소했습니다.");
				// clear
				msg = "";
				msg2 = "";
				sum = 0;
			}
		});
		btnBr6.setFont(new Font("굴림", Font.BOLD, 12));
		contentPane.add(btnBr6);

		JTextArea textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setFont(new Font("굴림", Font.BOLD, 12));
		textArea.setText("종로 거주하시면 종로\r\n아니면 종로 외를 선택해주세요.");
		contentPane.add(textArea);
//		줄바꿈	(엔터); 커서이동
//		LF		cr
//		10		13
//		\n		\r
//		visual basic	: chr(10) + chr(13)
//		win				: 13
//		linux			: 10

		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 종로거주면 1000원 할인
				// 마우스 클릭의 중복 이벤트 방지 // 눌럿다 때고나면 2번 카운트가 되는 현상
				if(list.getValueIsAdjusting()) {
	//				if(e.getSource() == list) {
						int index1 = list.getSelectedIndex();
	//					jongroFlag = false;
						String indexElement1 = (String) list.getModel().getElementAt(index1);
						if(indexElement1.equals("종로") && !jongroFlag) { // if(index1 == 0)
							sale = -1000;
	//						jongroFlag = true;
							System.out.println(sum);
						} else if(indexElement1.equals("종로 외") && jongroFlag) { // if(index1 == 1)
							sale = 0;
	//						jongroFlag = false;
							System.out.println(sum);
						}
				//	}
				}
				
				/*
				 * int index1 = list.getSelectedIndex(); if(index1 == 0 && !jongroFlag) { sum -=
				 * 1000; jongroFlag = true; System.out.println(sum); } else if(index1 == 1 &&
				 * jongroFlag) { sum += 0; jongroFlag = false; System.out.println(sum); }
				 */
				
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "종로", "종로 외" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("굴림", Font.BOLD, 12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);

//		그리고 추가로 라벨을 넣어서 제목을 만들어야 하므로 라벨 2개를 맨 위에 넣는다
//		이 때 라벨때문에 열이 흐트러지면 행을 0으로 변경하여 조정시킨다.
	}

}
