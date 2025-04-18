package a01_windowss;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import a01_windowss.MultiLineCellRenderer;
import a02_toNforDB.InfoDAO;
import a02_toNforDB.InfoVO;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

public class B02_Rev_List extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					B02_Rev_List frame = new B02_Rev_List();
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
	public B02_Rev_List() throws ClassNotFoundException, SQLException {
		setTitle("예약자 명단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 448, 515);
		contentPane.add(scrollPane);
		
		InfoDAO R_dao = new InfoDAO();
		ArrayList<InfoVO> rev_Array = R_dao.getAllInfo();
		
		String[][] R_Array = new String[rev_Array.size()][4];
		
		// 행마다 객체, 필드 값을 보관하는 방식
		
		
		for(int i = 0; i < rev_Array.size(); i++) {
			InfoVO vo = rev_Array.get(i);
			R_Array[i][0]=vo.getName();
			R_Array[i][1]=vo.getRsv_time();
			R_Array[i][2]=vo.getMenu_list();
			R_Array[i][3]=vo.getUser_phone();
		}
		
		String[] coulumNames = {"예약자명","예약시간","주문메뉴","전화번호"};
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		DefaultTableModel model = new DefaultTableModel(R_Array,coulumNames) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;  // 모든 셀 편집 불가능
		    }
		};
		table.setModel(model);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setCellRenderer(new MultiLineCellRenderer());
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		
		table.setBounds(10, 80, 448, 515);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("예약자 명단");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 128, 62);
		contentPane.add(lblNewLabel);
	}
}

class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(new Font("맑은 고딕", Font.PLAIN,15));
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value == null ? "" : value.toString());

        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }

        // 행 높이 자동 조절
        setSize(table.getColumnModel().getColumn(column).getWidth(), Short.MAX_VALUE);
        int preferredHeight = getPreferredSize().height;
        if (table.getRowHeight(row) != preferredHeight) {
            table.setRowHeight(row, preferredHeight);
        }

        return this;
    }
}
