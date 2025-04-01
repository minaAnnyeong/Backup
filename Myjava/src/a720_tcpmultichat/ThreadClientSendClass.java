package a720_tcpmultichat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClientSendClass implements Runnable {

	 
	
	private DataOutputStream outputStream;
	private Socket socket;
	private String nickname;

	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {//생성자 
		// TODO Auto-generated constructor stub
	this.socket=socket;
	outputStream = new DataOutputStream(socket.getOutputStream());
	this.nickname=nickname;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//만약 홍길동이 chat에 참여한 경우 
		//(1) nickname을 hohokildong 일경우 제일먼자 nickname이 들어와서 전체 전송 
		// (2) chat 이 들어옴 
		Scanner in1 = new Scanner(System.in);
		
		  
		try {
			if (outputStream != null)
				outputStream.writeUTF(nickname); //닉네임 은빛공주 send
			while (outputStream != null) {
				// io스트림을 통해 상대방에게 chat 보냄
			outputStream.writeUTF("(**"+nickname+"**)"+in1.nextLine());
			}                                           //(**은빛공주**) 방가방가 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	 }//run-end
  }//ThreadClientSendClass-end
	