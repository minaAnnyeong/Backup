package a141_tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ThreadSend extends Thread { // 단순 클래스 메인x
	Socket s1; // 속성, 필드
	DataOutputStream dos1;
	String what1;

	public ThreadSend(Socket s1) throws IOException {
		this.s1 = s1;
		// 네트워크 스트림 작성; 내보내는 스트림
		dos1 = new DataOutputStream(s1.getOutputStream());
		what1 = "미팅중==>";
	}

	public void run() {
		// 화면에 chat을 입력받아서 상대방에게 send
		Scanner sc1 = new Scanner(System.in);
		while (dos1 != null) { // chat이 있으면
			try {
				// 미팅중==> I Love You 엔터입력시 input
				dos1.writeUTF(what1 + sc1.nextLine());
			} catch (IOException e) {
				// e.printStackTrace
			}
		}
	}
}
