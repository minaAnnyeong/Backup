package a415;

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
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MenuForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField_13;
	private JTextArea textarea;
	private JTextField textField;
	private JTextField textA;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private Map<String, Integer> clickCountMap = new HashMap<>();

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

	// msg2 = msg + "합계금액: " + String.valueOf(sum) + " 원";
	/**
	 * Create the frame.
	 */
	public MenuForm() {
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
				new ReserveForm().setVisible(true);
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
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 498, 464, 46);
		contentPane.add(scrollPane);
		
		textA = new JTextField();
		scrollPane.setViewportView(textA);
		textA.setColumns(10);
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food1.jpg")));
		btnNewButton_1.setBounds(0, 0, 116, 130);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food2.jpg")));
		btnNewButton_2.setBounds(116, 0, 116, 130);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food3.jpg")));
		btnNewButton_3.setBounds(232, 0, 116, 130);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food4.jpg")));
		btnNewButton_4.setBounds(348, 0, 116, 130);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food8.jpg")));
		btnNewButton_5.setBounds(348, 157, 116, 130);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food7.jpg")));
		btnNewButton_6.setBounds(232, 157, 116, 130);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food6.jpg")));
		btnNewButton_7.setBounds(116, 157, 116, 130);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food5.jpg")));
		btnNewButton_8.setBounds(0, 157, 116, 130);
		contentPane.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food9.jpg")));
		btnNewButton_9.setBounds(0, 313, 116, 130);
		contentPane.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food10.jpg")));
		btnNewButton_10.setBounds(116, 313, 116, 130);
		contentPane.add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("New button");
		btnNewButton_11.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food11.jpg")));
		btnNewButton_11.setBounds(232, 313, 116, 130);
		contentPane.add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("New button");
		btnNewButton_12.setIcon(new ImageIcon(MenuForm.class.getResource("/food/food12.jpg")));
		btnNewButton_12.setBounds(348, 313, 116, 130);
		contentPane.add(btnNewButton_12);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_1.setText("팔절판");
		textField_1.setBounds(0, 128, 116, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_2.setText("불고기");
		textField_2.setColumns(10);
		textField_2.setBounds(116, 128, 116, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("비빔밥");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(232, 128, 116, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("김치찌개");
		textField_4.setColumns(10);
		textField_4.setBounds(348, 128, 116, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("삼계탕");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(0, 284, 116, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("삼겹살");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(116, 284, 116, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("김치볶음밥");
		textField_7.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(232, 284, 116, 30);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("수육");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(348, 284, 116, 30);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("잡채");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBounds(348, 444, 116, 30);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("곱창");
		textField_10.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(232, 444, 116, 30);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("김밥");
		textField_11.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(0, 444, 116, 30);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("떡볶이");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("굴림", Font.PLAIN, 16));
		textField_12.setColumns(10);
		textField_12.setBounds(116, 444, 119, 30);
		contentPane.add(textField_12);
	
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "팔절판";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "불고기";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "비빔밥";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "김치찌개";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "수육";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "김치볶음밥";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "삼겹살";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "삼계탕";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "김밥";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "떡볶이";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "곱창";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String food = "잡채";

				int count = clickCountMap.getOrDefault(food, 0) + 1;
				clickCountMap.put(food, count);

				String displayText = food;
				if (count > 1) {
					displayText += " (" + count + ")";
				}

				String currentText = textA.getText().trim();
				boolean updated = false;

				// 이전 값에 이미 해당 음식이 있는 경우 → 교체
				String[] items = currentText.isEmpty() ? new String[0] : currentText.split(", ");
				for (int i = 0; i < items.length; i++) {
					if (items[i].startsWith(food)) {
						items[i] = displayText;
						updated = true;
					}
				}

				String result;
				if (updated) {
					result = String.join(", ", items);
				} else if (currentText.isEmpty()) {
					result = displayText;
				} else {
					result = currentText + ", " + displayText;
				}

				textA.setText(result);
			}
		});
	
	
	}
}
