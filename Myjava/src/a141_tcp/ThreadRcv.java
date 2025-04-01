package a141_tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadRcv extends Thread{
    Socket s1;
    DataInputStream dis1;
    //String what1; x  =======> send쪽에서 이미 접두어를 붙이므로 
                            // 여기서는 안 만든다 
	public ThreadRcv(Socket s1) throws IOException {
		// TODO Auto-generated constructor stub
		
		 this.s1=s1;
		 dis1=new DataInputStream(s1.getInputStream());
	}//생성자-end
	
	public void run() {//chat 받는 부분을 처리
		 //dos1.writeUTF(what1+sc1.nextLine()); 를 받으면됨 
		 //  ㄴ  미팅중==> I love you.
		while(dis1 != null) {
		  try {
			System.out.println(dis1.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		  
		}//while-end
		
	}//run-end

}//ThreadRcv class-end
