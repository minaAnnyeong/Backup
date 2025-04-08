package a100_gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

class ButtonClass extends Frame {
	private Button b1 = new Button("눌러봐");
	private Label la1 = new Label("어! 여기에 글자가 나오네");
	
	// 디폴트 생성자
	// 보통의 경우 없어도 되지만 매 필수 초기작업이 필요한 경우 여기에 작성한다.
	public ButtonClass() {
		this.setLayout(null); // 창 레이아웃 위치 미정 > 지정해주어야 함
		b1.setSize(100, 70); // 버튼 b1의 크기(w,h) 지정 // 단위 pixel
		b1.setLocation(200, 300); // 버튼 b1의 위치(w,h) 지정
		this.add(b1); // 버튼 b1 추가
	}
}

public class GUI2 {

	public static void main(String[] args) {
		ButtonClass bc1 = new ButtonClass();
	}

}
