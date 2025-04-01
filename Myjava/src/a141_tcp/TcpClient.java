package a141_tcp;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		Socket s1 = new Socket(args[0], Integer.parseInt(args[1]));
		// Socket s1 = new Socket("127.0.0.1".7878);
		// 서버는 ServerSocket ss1 = ServerSocket(7878);
		// connect
		
//		rcv/ send 시작
//		그로므로 thread가 필요
//		client/server를 연결할 수 있는 network stream이 있으므로
//		이미 만들어 놓은 것 사용하자
//		단, 객체이름은 다르게
//		서버 쪽 thread 4줄 복붙 후 이름만 변경
		ThreadSend tsc1 = new ThreadSend(s1);
		ThreadRcv trc1 = new ThreadRcv(s1);
//		thread의 run()을 찾아감
		tsc1.start();
		trc1.start();
//		현재 같은 패키지 내안에 4개의 .java 파일이 있으므로
//		컴파일되면 4개의 클래스가 생긴다
		
		// socketing program
		// id-address와 포트번호가 안들어오면
		if(args.length != 2) {
			System.out.println("사용법은 java 패키지명.파일명 ip-address 포트번호");
			System.exit(1);	// 강제종료
		}
		
		

	}

}
