package a720_tcpmultichat;

import java.io.IOException;

public class TcpMulServer {

	public static void main(String[] args) throws NumberFormatException, IOException    {
		// TODO Auto-generated method stub
		//socketing program
	   if(args.length != 1) {
	     System.out.println("사용법은 \' java 패키지명.파일명 포트번호 \' 형식으로 입력한다는  ");
	     System.exit(1);
	   }
		new ServerClass(Integer.parseInt(args[0]));//포트번호 
		
		//multi chat   1: 다  톡 
		// server의 역할 은 오직 전달 역할 , chat x 
		
   }//main-end
	
}//class-end
//=====================   실행방법 ===========================
//  1) 먼저 이클립스에서 run-configuration으로 서버, 클라이언트 에러 유무 확인
//  2) 이상없으면  파워쉘로 멋있게 진행 


