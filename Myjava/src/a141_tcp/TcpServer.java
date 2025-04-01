package a141_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws IOException {
		// 채팅  > java a170_TCPServer .. > 명령인자 > commandline argument
		
		// socketing program
		// 포트번호 입력 필요. 처음에 아무것도 안 칠 경우 사용법 알려 줌
		if(args.length != 1) {
			System.out.println("사용법은 java 패키지명.파일명 포트번호");
			System.exit(1);
		}
		
		// String[] args
		// java a170_chat.TCPServer 8976
		// String[] args = new String[2];		
		ServerSocket ss1 = new ServerSocket(Integer.parseInt(args[0]));
		System.out.println("서버 잘 준비됨..");

		while (true) {
			System.out.println("미팅 대화 기다리는 중");
			Socket s1 = ss1.accept();	// connect 를 허락
//			thread 클래스이름이 ThreadSend, ThreadRcv 라고 가정하고 객체를 작성. 액박뜨면 자동 새 클래스 작성 ㄱ
			
			ThreadSend ts1 = new ThreadSend(s1);
			ThreadRcv tr1 = new ThreadRcv(s1);
			
//			class가 별도 자바로 만들어져 있더라조 같은 패키지 안에 있으면 하나의 자바로 처리된다.
//			즉, 나누어진 클래스나 하나의 .java안에 있는 여러개의 클래스나 같은 것 임
			
			ts1.start();
			tr1.start();
		}
	}

}
