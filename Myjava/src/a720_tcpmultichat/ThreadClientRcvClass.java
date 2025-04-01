package a720_tcpmultichat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadClientRcvClass implements Runnable  {

	Socket socket; //rcv  클래스 필드들 
	DataInputStream inputStream;
	
	public ThreadClientRcvClass(Socket socket) throws IOException {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		inputStream = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		 //(**초록왕자**) 방가방가  를 콘솔에 출력 
	 while(inputStream !=null)	{
		try {
			System.out.println(inputStream.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	 }//while-end
	}//run -end

}//ThreadClientRcvClass-end
