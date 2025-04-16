package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class MenuForm1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textA;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_8;
	private JButton btnNewButton_7;
	private JButton btnNewButton_6;
	private JButton btnNewButton_5;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private Map<String, Integer> clickCountMap = new HashMap<>();
	int price = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuForm1 frame = new MenuForm1();
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
	public MenuForm1() {
		setTitle("메뉴 선택창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("선택");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new ReserveForm1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(140, 554, 159, 37);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setText("선택한 메뉴 확인 창");
		textField.setBounds(0, 471, 464, 30);
		textField.setEditable(false);
		textField.setFocusable(false);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 498, 464, 46);
		contentPane.add(scrollPane);

		textA = new JTextField();
		scrollPane.setViewportView(textA);
		textA.setColumns(10);
		textA.setEditable(false);
		textA.setFocusable(false);

		btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food1.jpg")));
		btnNewButton_1.setBounds(0, 0, 116, 130);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food2.jpg")));
		btnNewButton_2.setBounds(116, 0, 116, 130);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food3.jpg")));
		btnNewButton_3.setBounds(232, 0, 116, 130);
		contentPane.add(btnNewButton_3);

		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food4.jpg")));
		btnNewButton_4.setBounds(348, 0, 116, 130);
		contentPane.add(btnNewButton_4);

		btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food8.jpg")));
		btnNewButton_8.setBounds(348, 157, 116, 130);
		contentPane.add(btnNewButton_8);

		btnNewButton_7 = new JButton("New button");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food7.jpg")));
		btnNewButton_7.setBounds(232, 157, 116, 130);
		contentPane.add(btnNewButton_7);

		btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food6.jpg")));
		btnNewButton_6.setBounds(116, 157, 116, 130);
		contentPane.add(btnNewButton_6);

		btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food5.jpg")));
		btnNewButton_5.setBounds(0, 157, 116, 130);
		contentPane.add(btnNewButton_5);

		btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food9.jpg")));
		btnNewButton_9.setBounds(0, 313, 116, 130);
		contentPane.add(btnNewButton_9);

		btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food10.jpg")));
		btnNewButton_10.setBounds(116, 313, 116, 130);
		contentPane.add(btnNewButton_10);

		btnNewButton_11 = new JButton("New button");
		btnNewButton_11.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food11.jpg")));
		btnNewButton_11.setBounds(232, 313, 116, 130);
		contentPane.add(btnNewButton_11);

		btnNewButton_12 = new JButton("New button");
		btnNewButton_12.setIcon(new ImageIcon(MenuForm1.class.getResource("/food/food12.jpg")));
		btnNewButton_12.setBounds(348, 313, 116, 130);
		contentPane.add(btnNewButton_12);

		String[] foodNames = { "팔절판", "불고기", "비빔밥", "김치찌개", "삼계탕", "삼겹살",
				"김치볶음밥", "수육", "김밥", "떡볶이", "곱창", "잡채"};
		
		int[] foodPrices = {15000, 12000, 9000, 8000, 13000, 12000, 8000, 15000, 3000, 5000, 13000, 8000};
		JButton[] buttons = {
			    btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4,
			    btnNewButton_5, btnNewButton_6, btnNewButton_7, btnNewButton_8,
			    btnNewButton_9, btnNewButton_10, btnNewButton_11, btnNewButton_12
			};

		int[] xPositions = { 0, 116, 232, 348 };
		int[] yPositions = { 128, 284, 442 };

		int index = 0;

		for (int row = 0; row < yPositions.length; row++) {
			for (int col = 0; col < xPositions.length; col++) {
				if (index >= foodNames.length)
					break;

				JTextField textField = new JTextField();
				textField.setEditable(false);
				textField.setFocusable(false);
				textField.setText(foodNames[index]);
				textField.setFont(new Font("굴림", Font.PLAIN, 16));
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setColumns(10);
				textField.setBounds(xPositions[col], yPositions[row], 116, 30);
				textField.setBackground(Color.WHITE);
				contentPane.add(textField);

				index++;
			}
		}
		
		for (int i = 0; i < buttons.length; i++) {
		    final String food = foodNames[i];
		    final int price = foodPrices[i];
		    buttons[i].addActionListener(createFoodButtonListener(food, price));
		}

//		btnNewButton_1.addActionListener(createFoodButtonListener("팔절판", 15000));
//		btnNewButton_2.addActionListener(createFoodButtonListener("불고기", 12000));
//		btnNewButton_3.addActionListener(createFoodButtonListener("비빔밥", 9000));
//		btnNewButton_4.addActionListener(createFoodButtonListener("김치찌개", 8000));
//		btnNewButton_5.addActionListener(createFoodButtonListener("삼계탕", 13000));
//		btnNewButton_6.addActionListener(createFoodButtonListener("삼겹살", 12000));
//		btnNewButton_7.addActionListener(createFoodButtonListener("김치볶음밥", 8000));
//		btnNewButton_8.addActionListener(createFoodButtonListener("수육", 15000));
//		btnNewButton_9.addActionListener(createFoodButtonListener("김밥", 3000));
//		btnNewButton_10.addActionListener(createFoodButtonListener("떡볶이", 5000));
//		btnNewButton_11.addActionListener(createFoodButtonListener("곱창", 13000));
//		btnNewButton_12.addActionListener(createFoodButtonListener("잡채", 8000));

	}

	private void handleFoodClick(String food, int price) {

		int count = clickCountMap.getOrDefault(food, 0) + 1;
		clickCountMap.put(food, count);
		
		

//		String displayText = (count > 1) ? food + " (" + count + ")" : food;
//		String displayText = (count > 1)
//			    ? food + " (" + count + ") - " +  price 
//			    : food + " - " + price + "원";
		
		String displayText = (count > 1)
			    ? food + " (" + count + ") - " + price + "원"
			    : food + " - " + price + "원";



		String currentText = textA.getText().trim();
		boolean updated = false;

		String[] items = currentText.isEmpty() ? new String[0] : currentText.split(",\\s*");
		StringBuilder resultBuilder = new StringBuilder();

		for (String item : items) {
			if (!item.trim().isEmpty()) {
				String itemName = item.split(" \\(")[0].split(" - ")[0].trim();
				if (itemName.equals(food)) {
					resultBuilder.append(displayText);
					updated = true;
				} else {
					resultBuilder.append(item);
				}
				resultBuilder.append(", ");
			}
		}

		if (!updated) {
			if (resultBuilder.length() > 0) {
				resultBuilder.append(" ");
			}
			resultBuilder.append(displayText);
		}
 
		String resultText = resultBuilder.toString().trim();
		if (resultText.endsWith(",")) {
			resultText = resultText.substring(0, resultText.length() - 1);
		}

	
		textA.setText(resultText);

		int restId = 1; // 실제 값으로 변경
		int menuId = 1; // 실제 값으로 변경

		new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception { 

				DatabaseHelper.saveToDatabase(food, count, price, restId, menuId);
				return null;
			}

			@Override
			protected void done() {

				System.out.println("DB 저장 완료!");
			}
		}.execute();
	}
	

//	private ActionListener createFoodButtonListener(final String food, int price) {
//		return new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				handleFoodClick(food, price);
//			}
//		};
//	}
	private ActionListener createFoodButtonListener(String food, int price) {
	    return e -> handleFoodClick(food, price);
	}

}

