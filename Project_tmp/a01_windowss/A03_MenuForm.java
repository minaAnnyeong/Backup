package a01_windowss;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import a02_toNforDB.DBConn;
import a02_toNforDB.DatabaseHelper;

public class A03_MenuForm extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textA;
	private Map<String, Integer> clickCountMap = new HashMap<>();
	private String userId;
    private String name;
    private String phone;
	private int restId;

	private final String[] foodNames = { "팔정판", "불고기", "비빔밥", "김치찌개", "삼계탕", "삼겹살", "김치볶음밥", "수육", "김밥", "떡볶이", "곱창",
			"잡채" };
	private final int[] foodPrices = { 15000, 12000, 9000, 8000, 13000, 12000, 8000, 15000, 3000, 5000, 13000, 8000 };
	private final String[] foodImages = { "/food/food1.jpg", "/food/food2.jpg", "/food/food3.jpg", "/food/food4.jpg",
			"/food/food5.jpg", "/food/food6.jpg", "/food/food7.jpg", "/food/food8.jpg", "/food/food9.jpg",
			"/food/food10.jpg", "/food/food11.jpg", "/food/food12.jpg" };

	public A03_MenuForm(String userId, String name, String phone, int restId) { // A02에서 나온 두 값을 받고
		this.userId = userId;
    	this.name = name;
    	this.phone = phone;
		this.restId = restId;
		initializeUI();
	}

	private void initializeUI() {
		setTitle("메뉴 선택창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton selectButton = new JButton("선택");
		selectButton.setFont(new Font("굴림", Font.PLAIN, 18));
		selectButton.setBounds(140, 554, 159, 37);
		selectButton.addActionListener(e -> {
			dispose();
			new A04_ReserveForm().setVisible(true);
		});
		contentPane.add(selectButton);

		textField = new JTextField("선택한 메뉴 확인 창");
		textField.setBounds(0, 471, 464, 30);
		contentPane.add(textField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 498, 464, 46);
		contentPane.add(scrollPane);

		textA = new JTextField();
		scrollPane.setViewportView(textA);

		createFoodButtons();
	}

	private void createFoodButtons() {
		JButton[] buttons = new JButton[foodNames.length];
		int index = 0;

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 4; col++) {
				if (index >= foodNames.length)
					break;

				int x = col * 116;
				int y = row * 157;

				// 이미지 버튼
				buttons[index] = new JButton();
				buttons[index].setIcon(new ImageIcon(A03_MenuForm.class.getResource(foodImages[index])));
				buttons[index].setBounds(x, y, 116, 130);
				final String food = foodNames[index];
				final int price = foodPrices[index];
				buttons[index].addActionListener(createFoodButtonListener(food, price));
				contentPane.add(buttons[index]);

				// 메뉴 이름 텍스트 필드
				JTextField foodLabel = new JTextField(food);
				foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
				foodLabel.setBounds(x, y + 130, 116, 30);
				foodLabel.setEditable(false);
				contentPane.add(foodLabel);

				index++;
			}
		}
	}

	private ActionListener createFoodButtonListener(String food, int price) {
		return e -> handleFoodClick(food, price);
	}

	private void handleFoodClick(String food, int price) {
		// 클릭된 메뉴의 수량 업데이트
		int count = clickCountMap.getOrDefault(food, 0) + 1;
		clickCountMap.put(food, count);

		// 화면에 표시할 텍스트 업데이트
		String displayText = (count > 1) ? food + " (" + count + ") - " + price + "원" : food + " - " + price + "원";
		String currentText = textA.getText().trim();
		StringBuilder updatedText = new StringBuilder();

		boolean updated = false;
		for (String item : currentText.split(",\\s*")) {
			if (!item.isBlank()) {
				String name = item.split(" \\(")[0].split(" - ")[0].trim();
				if (name.equals(food)) {
					updatedText.append(displayText);
					updated = true;
				} else {
					updatedText.append(item);
				}
				updatedText.append(", ");
			}
		}

		if (!updated) {
			if (updatedText.length() > 0)
				updatedText.append(" ");
			updatedText.append(displayText);
		}

		textA.setText(updatedText.toString().replaceAll(",\\s*$", ""));

		// 유저 예약 ID 얻기 및 DB에 저장
		int userRsvId = insertUserReservation(userId, restId, count, new Timestamp(System.currentTimeMillis()));
		int menuId = DatabaseHelper.getMenuIdFromFood(food);

		new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() {
				DatabaseHelper.insertUserRsvMenu(userRsvId, menuId, count);
				return null;
			}

			@Override
			protected void done() {
				System.out.println("DB 저장 완료!");
			}
		}.execute();
	}

	private int insertUserReservation(String userId, int restId, int userCount, Timestamp revTime) {
		String sql = "INSERT INTO user_rsv (user_rsv_id, user_id, rest_id, user_count, rev_time) VALUES (user_rsv_seq.NEXTVAL, ?, ?, ?, ?)";
		int userRsvId = -1;

		try (Connection conn = new DBConn().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "user_rsv_id" })) {

			pstmt.setString(1, userId);
			pstmt.setInt(2, restId);
			pstmt.setInt(3, userCount);
			pstmt.setTimestamp(4, revTime);

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				userRsvId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userRsvId;
	}
}
