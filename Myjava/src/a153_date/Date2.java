package a153_date;

import java.util.Calendar;
import java.util.Date;

public class Date2 {

	public static void main(String[] args) {
//		Q) 오늘날짜를 출력
		Date d1 = new Date();
		System.out.println(d1); // toString()

		// 한글로 // 줄그어짐; old 하단 의미
		System.out.println(d1.toLocaleString());

//		//
//		String aa = "babo";
//		aa = aa + "ya";
//		System.out.println(aa);

		// 한글 문단 "오늘날짜는 2024년 n월 n일 이고 n요일 입니다." 출력하기
		String strd = "오늘날짜는 ";
//		현재 년도의 앞 두자리에 19차감한 값. 현재 년도 = getYear + 1900
		strd += d1.getYear() + 1900 + "년 ";
//		1월: 0부터 시작한다. 현재 월 = getMonth + 1
		strd += d1.getMonth() + 1 + "월 ";
//		
		strd += d1.getDate() + "일 ";
		strd += "이고 ";
//		일요일 - 0 부터 토-6 까지 인덱스로 표현 >> 개발자가 손 봐야 함
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };
		strd += days[d1.getDay()];
		strd += "요일 ";
		strd += "입니다.";
		System.out.println(strd);

		// getHour 등으로 시 분 초 출력한다.
		// 그리니치 천문대 기준. ; UTC
		//
		String strt = "시간은 ";
		strt += d1.getHours();
		strt += "시 ";
		strt += d1.getMinutes();
		strt += "분 ";
		strt += d1.getSeconds();
		strt += "초 ";
		strt += "입니다. ";

		System.out.println(strt);
//		Date()괄호안 파라미터: 기준 년원일로부터 얼마나 지나갔나 
//		java Date메소드의 '기준' : '1970년 1월 1일'
		Date d2 = new Date(1000L);
		System.out.println(d2);

//		Q) 1998.6.30 일생인 사람이 살아온 날 구하기; D+nnnn 구하는 프로그램 만들기
//		오늘날짜 - 생일
		Date d5 = new Date();
//		올바른 결과 위해서 파라미터 값 편집
		Date bir = new Date(1998-1900, 6-1, 30);
//		날짜Date형 자료는 날짜단위 계산이 안되고, .getTime()으로 뽑은 밀리세컨드단위로 계산해야한다. 
//		결과 또한 밀리세컨드 단위로 나오므로 소실방지위해 long형에 저장한다
		long msplus = d5.getTime() - bir.getTime();
		long dplus = msplus/1000/3600/24;	// 밀리초 -> 일수
		System.out.println("살아온 날은 D+" + dplus + " 일 입니다.");
		
//		Q) 오늘부터 시작하여 만난 지 100일 되는 날을 구하는 프로그램을 작성.
		Date d6 = new Date();
		d6.setDate(d6.getDate() + (100 - 1)); // 오늘 포함이므로 +100-1
		
		System.out.println(d6.toLocaleString());
		
		// deprecated메소드 지양하기 > Calendar 객체 사용 
		Calendar cal = Calendar.getInstance(); // 객체.메소드() //클래스명.메소드()
		int year = cal.get(Calendar.YEAR); //2025
		int mon = cal.get(Calendar.MONTH); // 4월
		int day = cal.get(Calendar.DAY_OF_MONTH); // 7일
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.println("현재 시간");
		System.out.println(year + "년 " + mon + "월 " + day + "일 ...");
	
	
	}

}
