package a720_tcpmultichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerClass {

	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>();

	Socket socket;// 클라이언트 받아 저장할곳
	DataOutputStream outputStream;// 출력스트림

	// 생성자는 초기치 를 주면 가장 빨리 만나는 메소드 형태임
	public ServerClass(int portno) throws IOException {
		// TODO Auto-generated constructor stub

		Socket s1 = null;

		// myip, port
		ServerSocket ss1 = new ServerSocket(portno);
		System.out.println("서버 준비중~~~");

		while (true) {
			s1 = ss1.accept();
			System.out.println("접속주소: " + s1.getInetAddress());
			System.out.println("접속포트: " + s1.getPort());

			ThreadServerClass tServer1 = new ThreadServerClass(s1);
			tServer1.start();

			threadList.add(tServer1);

			System.out.println("접속자수:" + threadList.size() + " 명 ");

		} // while-true
	}// 생성자-end

	// class in class (ThreadServerClass in ServerClass)
	class ThreadServerClass extends Thread {
		Socket socket1;// 필드, 속성
		DataInputStream inputStream;
		DataOutputStream outputStream;

		public ThreadServerClass(Socket s1) throws IOException {// 생성자
			socket1 = s1;
			inputStream = new DataInputStream(s1.getInputStream());
			outputStream = new DataOutputStream(s1.getOutputStream());
			// 입출력스트림 //network stream
		}// ThreadServerClass-생성자-end

		@Override
		public void run() { // java 패키지명..... 9887 은빛공주 (by 클라이언트)
			String nickname = "";
			try {//// 이부분이 진행되고 있다는 것은 안정적으로 채팅 중 ~~~~~//////
				if (inputStream != null) {
					nickname = inputStream.readUTF();// 초록왕자 은빛공주
					// sendChat()은 개발자가 만든 함수
					sendChat(nickname + " 님 입장~~~~~ (^^) (^^) (^^) ");
					// 결과적으로 다수의 chatting 회원에게 보내기위한 메소드
					// 메소드2형식 호출문 //클라이언트 처음 보내는 것이 별명 #######
				} // 전체회원에게 지금들어온 별명을보내기위한 작업

				while (inputStream != null) {
					// System.out.println(inputStream.readUTF());
					sendChat(inputStream.readUTF()); // 방가방가 나는 hong
					// 클라이언트 1명이 writeUTF("방가방가") 사용하여 보낸것
					// 이번에는 별명이 아니라 클라이언트가 보낸 채팅 내용을 접속한 모두에게 보냄
				}
			} catch (IOException e) {//////////////
				// e.printStackTrace();//에러내용 출력을 안하려면 주석단다
			} finally {// 어쨋든 간에 채팅으로 부터 나왔단 얘기 ///////////
						// 나간 쓰레드의 인덱스 찾기

				for (int i = 0; i < threadList.size(); i++) {
					// 지금 퇴장한 사람의소켓을 모든 사람의 소켓과 비교
					if (socket1.equals(threadList.get(i).socket1)) {
						threadList.remove(i);/////// 퇴장시 remove
						try {
							sendChat(nickname + " 님 퇴장~~~~~  (ㅠ.ㅠ) (ㅠ.ㅠ) (ㅠ.ㅠ) ");
							// 서버는 모든 클라이언트에게 누구누구님 퇴장이라고 보냄
						} catch (IOException e) {
							// e.printStackTrace();
						}
					} // if-end
				} // for-end
				System.out.println("접속자 수 : " + threadList.size() + " 명");
			} // finally-end
		}// run-end

		// 이것은 sendChat() 으로 호출한 메소드2형식 정의문
		public void sendChat(String chat) throws IOException {
			// TODO Auto-generated method stub
			for (int i = 0; i < threadList.size(); i++)
				threadList.get(i).outputStream.writeUTF(chat);// 처음 chat에는 초록왕자
			// 각각의 회원을 찾아가서 별명 or 채팅내용을 보냄
		}// sendChat-end

	}// ThreadServerClass-end

} // ServerClass-end
