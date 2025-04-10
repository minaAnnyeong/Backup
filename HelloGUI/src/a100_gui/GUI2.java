package a100_gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent; // 이벤트 객체
import java.awt.event.ActionListener; // 이벤트를 인풋으로 받아들여옴
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ButtonClass extends Frame implements ActionListener {
//	한글이 있는 프로그램 실행은 이클립스 상단바 Run > Run configrations
//	> vm argument에 -Dfile.encoding=MS949 작성 후 적용
	
	// 컴포넌트들 components; 버튼b1, 라벨la1 등
	private Button b1 = new Button("눌러봐");
	private Label la1 = new Label("어! 여기에 글자가 나오네");

	// 디폴트 생성자
	// 보통의 경우 없어도 되지만 매 필수 초기작업이 필요한 경우 여기에 작성한다.
	public ButtonClass() {
		this.setLayout(null); // 창 레이아웃 위치 미정 > 지정해주어야 함
//		Font kFont = new Font("나눔고딕", Font.??);

		b1.setSize(100, 70); // 버튼 b1의 크기(w,h) 지정 // 단위 pixel
		b1.setLocation(200, 300); // 버튼 b1의 위치(w,h) 지정
//		b1.setFont(kFont);
		this.add(b1); // 버튼 b1 추가
		b1.addActionListener(this); // 이벤트 등록
		// ^버튼에 이벤트 발생 시 이벤트 핸들러와 연결시키는 메소드

		la1.setSize(200, 70);
		la1.setLocation(200, 150); // 라벨 la1 내부 위치
//		la1.setFont(kFont);
		this.add(la1); // 라벨 la1 추가

		this.setSize(500, 500); // 프레임 크기
		this.setVisible(true);

		// 창을 창닫기 버튼으로 닫기
		// w리스너: 적용되는? 메소드의 패키지 등 일일이 import해야 함 /  w어댑터: 메소드만 적어도 동작o
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) { 
				dispose(); // dispose(): 종료하기 전에 메모리에 올려진 프로세스 지우기(보통 시스템(가비지컬렉터)이 하는 일을 개발자가 하는 중)
				System.exit(0); // 강종. c# : Enviroment.Exit(0) 
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e1) {
//		이벤트 처리 필수 요소: 1) 이벤트 객체ActionEvent 2) 이벤트 등록기ActionListener 3) 이벤트 핸들러(actionPerformed)
		// 버튼이 눌렸을 경우 실행
		if (e1.getSource() == b1) {
			la1.setText("안녕~~ 자바"); // 객체.메소드()
		}
	}
}

public class GUI2 {

	public static void main(String[] args) {
		ButtonClass bc1 = new ButtonClass();
	}

}
