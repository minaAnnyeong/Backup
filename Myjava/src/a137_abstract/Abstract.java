package a137_abstract;

abstract class Kwail{
//	일반 메소드. 구현o
	public void good() {
		System.out.println("과일 먹으면 좋아");
	}
//	추상 메소드. 구현x
	public abstract void meokja();
}

class Sakwa extends Kwail{
	
	@Override
	public void meokja() {
		System.out.println("사과를 사각사각 먹자");
	}
}

class Bae extends Kwail{
	
	@Override
	public void meokja() {
		System.out.println("배를 요트배모양으로 먹자");
	}
}

class Kam extends Kwail{
	
	@Override
	public void meokja() {
		System.out.println("감 꼭지를 떼고 맛있게 먹자");
	}
}

public class Abstract {

	public static void main(String[] args) {
		Kwail s1 = new Sakwa();
		s1.meokja();
		Kwail b1 = new Bae();
		b1.meokja();
		Kwail k1 = new Kam();
		k1.meokja();

	}

}
