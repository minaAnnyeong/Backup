package a415;



import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class aa2 extends JFrame {
    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JLabel resultLabel;
    private JTextField textField;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                aa2 frame = new aa2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public aa2() {
        setTitle("음식점 검색");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("식당 검색");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
        lblNewLabel.setBounds(261, 45, 99, 27);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("찾아보기");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(83, 121, 104, 42);
        contentPane.add(lblNewLabel_1);

        // 콤보박스
        comboBox = new JComboBox<>();
        comboBox.setBounds(177, 184, 275, 55);
        contentPane.add(comboBox);

        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            if (selected != null && !selected.equals("식당을 선택하세요")) {
                btnNewButton.setEnabled(true);
                btnNewButton.setOpaque(true);
                btnNewButton.setBackground(new Color(0, 120, 215));
                resultLabel.setText("검색 결과: " + selected);
            } else {
                btnNewButton.setEnabled(false);
                btnNewButton.setOpaque(false);
                btnNewButton.setBackground(new Color(169, 169, 169));
                resultLabel.setText("검색 결과:");
            }
        });

        // 텍스트 필드 (검색어 입력)
        textField = new JTextField();
        textField.setBounds(177, 121, 275, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        // 검색 결과 라벨
        resultLabel = new JLabel("검색 결과:");
        resultLabel.setFont(new Font("굴림", Font.PLAIN, 14));
        resultLabel.setBounds(60, 255, 300, 30);
        contentPane.add(resultLabel);

        // 버튼 (선택)
        btnNewButton = new JButton("선택");
        btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
        btnNewButton.setBounds(263, 295, 104, 42);
        contentPane.add(btnNewButton);
        btnNewButton.setEnabled(false);

        btnNewButton.addActionListener(e -> {
            if (!btnNewButton.isEnabled()) return;
            if (resultLabel.getText().equals("검색 결과: 없음")) {
                JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                return;
            }
            dispose();
            new MenuForm().setVisible(true);
        });

     // 기존 keyPressed → keyReleased 로 변경
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = textField.getText().trim();

                // 엔터 키 눌렀을 때만 검색 실행
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchRestaurant(keyword);
                } else {
                    // 다른 키 입력 시 실시간으로 콤보박스 업데이트
                    if (!keyword.isEmpty()) {
                        updateComboBoxBasedOnKeyword(keyword);
                    } else {
                        loadRestaurantsFromDB(); // 비어있으면 전체 목록 다시 로드
                        resultLabel.setText("검색 결과:");
                        btnNewButton.setEnabled(false);
                        btnNewButton.setOpaque(false);
                        btnNewButton.setBackground(new Color(169, 169, 169));
                    }
                }
            }
        });


        loadRestaurantsFromDB(); // 시작 시 전체 목록 로딩
    }

    // 전체 DB 목록 로딩
    private void loadRestaurantsFromDB() {
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT rest_name FROM resta_se")) {

            comboBox.removeAllItems();
            comboBox.addItem("식당을 선택하세요");

            while (rs.next()) {
                comboBox.addItem(rs.getString("rest_name"));
            }

            comboBox.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 키워드로 필터링된 식당 목록 콤보박스에 출력
    private void updateComboBoxBasedOnKeyword(String keyword) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT rest_name FROM resta_se WHERE rest_name LIKE ?")) {

            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("식당을 선택하세요");

            boolean found = false;
            while (rs.next()) {
                found = true;
                comboBox.addItem(rs.getString("rest_name"));
            }

            comboBox.setSelectedIndex(0);

            if (!found) {
                resultLabel.setText("검색 결과: 없음");
                btnNewButton.setEnabled(false);
                btnNewButton.setOpaque(false);
                btnNewButton.setBackground(new Color(169, 169, 169));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 검색 실행 (엔터 시 단일 결과 표시)
    private void searchRestaurant(String keyword) {
        if (keyword.isEmpty()) {
            resultLabel.setText("검색 결과:");
            btnNewButton.setEnabled(false);
            btnNewButton.setOpaque(false);
            btnNewButton.setBackground(new Color(169, 169, 169));
            return;
        }

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT rest_name FROM resta_se WHERE rest_name LIKE ?")) {

            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String result = rs.getString("rest_name");
                resultLabel.setText("검색 결과: " + result);

                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    if (comboBox.getItemAt(i).equalsIgnoreCase(result)) {
                        comboBox.setSelectedIndex(i);
                        break;
                    }
                }

                btnNewButton.setEnabled(true);
                btnNewButton.setOpaque(true);
                btnNewButton.setBackground(new Color(0, 120, 215));

            } else {
                resultLabel.setText("검색 결과: 없음");
                btnNewButton.setEnabled(false);
                btnNewButton.setOpaque(false);
                btnNewButton.setBackground(new Color(169, 169, 169));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}