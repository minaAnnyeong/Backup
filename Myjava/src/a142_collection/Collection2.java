package a142_collection;

import java.util.ArrayList;

public class Collection2 {

	public static void main(String[] args) {
		ArrayList arr1 = new ArrayList();
		arr1.add(50); // 저장 시 객체타입으로 처리
		// Wrapper classes; Integer같은 것들이 전부wrapper.
//		arr1.add(new Integer(50));	// wrapper(클래스화) // deprecated
		arr1.add(100);
		arr1.add(50.5);
		arr1.add("빵");
		arr1.add("우유");
		arr1.add("라면");
		arr1.add("김밥");
		System.out.println(arr1.size());

		arr1.remove("빵");
		System.out.println(arr1.contains("빵"));

		arr1.set(3, "아이스크림");
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}	

	}

}
