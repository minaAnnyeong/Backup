package a103_gridlayout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutMainClass extends Frame {
	
	public GridLayoutMainClass() {
		this.setLayout(new GridLayout(2, 3, 10, 10)); // null x , 격자 모양 배치 o
		// 2행 3열 및 좌우간격: 10px, 상하간격: 10px
//		this.setLayout(new FlowLayout());	// 가로 중앙정렬, 상하좌우 5px씩 간격
//		this.setLayout(new OrderLayout());	// 동서남북 중앙기준 배치 (가장 기본 배치)
//		this.setLayout(new BorderLayout.EAST, new Button("눌러봐"));	// 채팅 화면 구현할 때
		this.add(new Button("눌러봐1"));
		this.add(new Button("눌러봐2"));
		this.add(new Button("눌러봐3"));
		this.add(new Button("눌러봐4"));
		this.add(new Button("눌러봐5"));
		this.add(new Button("눌러봐6"));
		this.setSize(300, 300);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});
	}

}
