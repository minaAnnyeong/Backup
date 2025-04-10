package telinfoPrintMain;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import telinfoDAO.TelInfoDAO;
import telinfoVO.TelInfoVO;

public class TelInfoMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int sel = 0;

		TelInfoDAO tidao = new TelInfoDAO();
		do {
			System.out.println("비상연락망관리!!");
			System.out.println("------------------------");
			System.out.println("1: 한명입력"); // C
			System.out.println("2: 수정"); 	// U
			System.out.println("3: 삭제"); 	// D
			System.out.println("4: 전체출력"); // R
			System.out.println("5: 종료");
			System.out.println("------------------------");
			System.out.println("이용할 메뉴를 선택해주세요.");
			// scanner 대신 반 graphic모드
			sel = Integer.parseInt(JOptionPane.showInputDialog("메뉴선택"));

			switch (sel) {
			case 1: // 한명 입력 Insert
				int id = Integer.parseInt(JOptionPane.showInputDialog("아이디는?"));
				String name = JOptionPane.showInputDialog("이름은?");
				String tel = JOptionPane.showInputDialog("전화번호는?");
				String sDate = JOptionPane.showInputDialog("날짜는?");
				boolean b1 = tidao.insert_nametel(id, name, tel, sDate);
				
				if(b1) {
					System.out.println("insert OK");
				}
				else {
					System.out.println("insert error");
				}
				
				break;
			case 2:
				break;
			case 3: // 삭제 D
				int id2 = Integer.parseInt(JOptionPane.showInputDialog("삭제할 행의 아이디는?"));
				boolean b2 = tidao.delete_nametel(id2);
				
				if(b2) {
					System.out.println("delete OK");
				}
				else {
					System.out.println("delete error");
				}
				break;
			case 4: // 전체출력 Read
				ArrayList<TelInfoVO> tiArray = tidao.getAllInfo(); // 메소드 호출
				// 컬렉션 객체를 가지고 오므로 지정메소드 필요
				for (TelInfoVO imsi : tiArray) {
					System.out.println(imsi.getId() + "\t");
					System.out.println(imsi.getName() + "\t");
					System.out.println(imsi.getTel() + "\t");
					System.out.println(imsi.getD());
				}
				break;
			case 5:
				break;
			default:
				break;
			}

		} while (sel != 5);
	}

}
