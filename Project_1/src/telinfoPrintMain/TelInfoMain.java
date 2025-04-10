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
			System.out.println("1: 한명입력");
			System.out.println("2: 수정");
			System.out.println("3: 삭제");
			System.out.println("4: 전체출력");
			System.out.println("5: 종료");
			System.out.println("------------------------");
			System.out.println("이용할 메뉴를 선택해주세요.");
			// scanner 대신 반 graphic모드
			sel = Integer.parseInt(JOptionPane.showInputDialog("메뉴선택"));
			
			switch(sel) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: // 전체출력
				ArrayList<TelInfoVO> tiArray = tidao.getAllInfo(); // 메소드 호출
												// 컬렉션 객체를 가지고 오므로 지정메소드 필요
				for(TelInfoVO imsi : tiArray) {
					System.out.println(imsi.getId() + "\t");
					System.out.println(imsi.getName() + "\t");
					System.out.println(imsi.getTel() + "\t");
					System.out.println(imsi.getD());
				}
				break;
			default:
				break;
			}
		
		
		}while();
	}

}
