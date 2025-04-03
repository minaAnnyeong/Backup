package a147_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap2 {

	public static void main(String[] args) {
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		hm1.put(100, "멋쟁이");
		hm1.put(300, "공주");
		hm1.put(200, "왕자");
//		System.out.println(hm1.get(300));
//		hm1.remove(200);
//		//hm1.values();
		
		// value들의 모음 출력
		Collection<String> v1 = hm1.values();
		System.out.println(v1);
		// key들의 모음 출력
		Set <Integer> s1 = hm1.keySet(); // [100, 200]
		System.out.println(s1);
		
		for(Integer i : s1) {
			System.out.println(i + "\t" + hm1.get(i));
		}
		// key와 value들의 모음을 묶어서 출력
		Set <Map.Entry <Integer, String>> set3 = hm1.entrySet();
		for(Map.Entry <Integer, String> i : set3) {
			System.out.println(i.getKey() + "\t" + i.getValue());
		}
	}

}
