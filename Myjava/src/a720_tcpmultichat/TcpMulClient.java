package a720_tcpmultichat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpMulClient {

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException     {
		// TODO Auto-generated method stub
		//socketing program
	   if(args.length != 3) {
	     System.out.println
	       ("사용법은 \' java 패키지명.파일명 ip address 포트번호 nickname\' 형식으로 입력한다는  ");
	     System.exit(1);
	   }
	   
		Socket s1=new Socket(args[0],Integer.parseInt(args[1]));//ip address, 포트번호 
		System.out.println("서버에 연결이다 ");
		                                                   //hong, lee
		ThreadClientSendClass tcs1=new ThreadClientSendClass(s1, args[2]); 
		ThreadClientRcvClass tcr1=new ThreadClientRcvClass(s1);   //닉네임
		  
		//1형식 : extends Thread   , 2형식 : implements Runnable
		Thread tsend1=new Thread(tcs1);
		Thread trcv1=new Thread(tcr1);
		tsend1.start();
		trcv1.start();
		
   }//main-end
	
}//class-end


