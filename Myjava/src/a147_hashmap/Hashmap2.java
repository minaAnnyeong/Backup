package a147_hashmap;

import java.util.HashMap;

public class Hashmap2 {

	public static void main(String[] args) {
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		hm1.put(100, "멋쟁이");
		hm1.put(300, "공주");
		hm1.put(200, "왕자");
		System.out.println(hm1.get(300));
	
	}

}
