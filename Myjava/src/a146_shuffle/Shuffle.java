package a146_shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shuffle {

	public static void main(String[] args) {
//		Q) 문자열을 섞는 문법, colection과 콜라보
//		참고 : 한컴타자연습

		String[] bae = { "babo", "ondal", "kongjoo", "satto", "choonhyang" };
		List<String> list2 = Arrays.asList(bae);
		// 컬렉션 내 요소의 순서를 무작위로 셔플
		Collections.shuffle(list2);
		for (String hana : list2) {
			System.out.println(hana);
		}
	}

}
