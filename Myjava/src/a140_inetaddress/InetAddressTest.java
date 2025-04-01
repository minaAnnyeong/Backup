package a140_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
//		ip주소표현시 사용되는 내장클래스
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1.getHostName());

//		네이버 레알주소
		InetAddress inet2 = InetAddress.getByName("www.naver.com");
		System.out.println(inet2);

		InetAddress[] inet3 = InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < inet3.length; i++) {
			System.out.println(inet3[i]);
		}

	}

}
