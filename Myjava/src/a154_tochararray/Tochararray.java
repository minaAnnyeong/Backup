package a154_tochararray;

public class Tochararray {

	public static void main(String[] args) {
		
//		Q) ondal을 daonl으로 암호화하는 프로그램 작성
//		sha256, spring seurity 등
		
		String aa = "ondal";
		char[] bb = aa.toCharArray();
		// swap
		char tmp;
		tmp = bb[0];
		bb[0] = bb[2];
		bb[2] = tmp;
		tmp = bb[1];
		bb[1] = bb[3];
		bb[3] = tmp;
		// char[] => String
		String cc = new String(bb);
		System.out.println(cc);
	}

}
