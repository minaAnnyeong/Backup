package a415;

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

import db.DatabaseHelper;
import db.UserRsvMenuVO;

import java.sql.Timestamp;

public class A04_ReserveForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JSpinner spinner;
    
    public static DatabaseHelper rsvDao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    A04_ReserveForm frame = new A04_ReserveForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public A04_ReserveForm() {
        setTitle("예약 폼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("예약 폼");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(122, 66, 205, 65);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("이름 :");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(-34, 167, 205, 65);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("전화번호 :");
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

        JLabel lblNewLabel_2_1 = new JLabel("예약 인원 :");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 16));
        lblNewLabel_2_1.setBounds(-34, 358, 205, 65);
        contentPane.add(lblNewLabel_2_1);

        JButton btnNewButton = new JButton("예약하기");
        btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
        btnNewButton.setBounds(159, 482, 168, 65);
        contentPane.add(btnNewButton);

        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
        spinner.setFont(new Font("굴림", Font.PLAIN, 18));
        spinner.setBounds(122, 358, 56, 65);
        contentPane.add(spinner);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// 스피너로부터 입력된 인원수 정보 가져옴
                int userCount = (int) spinner.getValue();
                String userId = textField.getText(); // 사용자의 이름을 입력받음
                int restId = 1; // 가정한 식당 ID
                Timestamp revTime = new Timestamp(System.currentTimeMillis());
////////////////////////////////////////////////////
//                boolean isInserted = false;
//				try {
//					isInserted = DatabaseHelper.insertUserReservation(userId, restId, userCount, revTime);
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//                if (isInserted) {
//                    JOptionPane.showMessageDialog(null, "예약이 완료되었습니다!");
//                } else {
//                    JOptionPane.showMessageDialog(null, "예약 실패!");
//                }
//////////////////////////////////////////////////////                
                rsvDao.userRsvVO.setUserCount(userCount);
                System.out.println("<ReservationForm PrintOut>");
    			System.out.println("UserId: " + rsvDao.userRsvVO.getUserId());
    			System.out.println("RestId: " + rsvDao.userRsvVO.getRestId());
    			for(UserRsvMenuVO VOItem : rsvDao.urmVOList) {
    				System.out.println("menuId: " + VOItem.getMenuId() + " / "
    			 			+ "menuCount: " + VOItem.getMenuCount());
    			}
    			System.out.println("UserCount: " + rsvDao.userRsvVO.getUserCount());
                dispose();
                setVisible(false);
                new A05_ReservationTime().setVisible(true); // 예약 시간이 선택되는 화면으로 전환
            }
        });
    }
}