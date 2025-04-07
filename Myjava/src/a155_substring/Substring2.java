package a155_substring;

public class Substring2 {

	public static void main(String[] args) {
//		오라클 sql ; 입사년도05년인 사월 출력 ; substr(입사일, 'yy') ?= '05'
		String aa = "LOVE";
		// 인덱스 n이상 m미만
		System.out.println(aa.substring(0, 3));

		// 전광판 프로그램
		String bb = "ONDAL";
		for (int i = 0; i < 10; i++) {
			bb = bb.substring(1, 5) + bb.substring(0, 1);
			System.out.println(bb);
		}

		String cc = "     ONDAL";
		for (int i = 0; i < 10; i++) {
			cc = cc.substring(1, cc.length()) + cc.substring(0, 1);
			System.out.println(cc);
		}
		
		
	}

}
