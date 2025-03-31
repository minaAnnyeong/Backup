package a136_interface;

interface Samchon {
	/*
	 * public void yoat() { System.out.println("요트 타고 세계일주 하자는"); }
	 */
	public void yoat();
}

interface Komo {
	public void gold();
}

class Parent {
	public void don() {
		System.out.println("나 재산 많아");
	}
}

class Na extends Parent implements Samchon, Komo {
	public void kumko() {
		System.out.println("나는 빈금고는 많아");
	}
	
	@Override
	public void yoat() {
		System.out.println("요트 타고 세계일주 가자");
	}
	
	@Override
	public void gold() {
		System.out.println("고모가 금을 선물함");
	}
}

public class Interface {

	public static void main(String[] args) {
		
	}

}
