package a144_indexof;

public class IndexOf2 {

	public static void main(String[] args) {
		String s = "ondal";
		System.out.println(s.indexOf("da"));
		// .indexOf(str) : 부분문자열str이 있다면 그 인덱스 반환, 없다면 -1반환
		// 1) 부분문자열 존재여부 또는 2) 부분문자열의 위치 찾기 에 사용할 수 있음
		// >> 서점 검색 기능을 구현할 때 사용된다.

//		책이름을 배열에 넣은 후 java책을 모두 검색하는 순차검색 프로그램을 작성하시오.
//		(자바책이 있을 경우 결과:)
//		java Programming
//		easy Java Programming
//		Master of Java 
//		C Language and java
//		Oracle and Java-JDBC
//		
//		(자바책이 없을 경우 결과: )
//		검색하신 책은 결과가 없습니다.

		String bae[] = { "java Programming", "C# programming", "easy Java Programming", "Master of Java",
				"C Language and java", "Power Browser.", "Oracle and Java-JDBC" };
		
//		..여기부터 작성
		String sc = "Java"; // 첫 글자 대문자 가정
		String tar[] = { sc, sc.toUpperCase(), sc.toLowerCase()};
		/*
		 * for (String i : tar) System.out.println(String.valueOf(i));
		 */		
		int cnt = 0;

		System.out.println("\""+ sc + "\" 에 대한 검색 결과: ");
		for (String i : bae) {
			for(String t : tar) {
				if(i.indexOf(t) > 0) {
					System.out.println(i);
					cnt++;
				}
			}
		}
		
		if (cnt == 0) {
			System.out.println("검색하신 결과가 없습니다.");
		}

	}

}
