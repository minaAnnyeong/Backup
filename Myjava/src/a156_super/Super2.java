package a156_super;

class Boomo {
	protected String juso;
	
	public Boomo() {
		System.out.println("내가 그래도 젊어..");
	}
	public Boomo(int na2) {
		System.out.println("에이 그래도 내가" + na2 + " 살 보다는 많지");
	}
	public void don() {
		System.out.println("돈 많아");
	}
}

class Janyu extends Boomo {
	protected int na2;

	public Janyu(String juso, int na2) {
		super(na2);	// 이 생성자로 자녀객체 생성 시, 부모객체의 생성자를 지정
		this.juso = juso;
		this.na2 = na2;
		System.out.println("나는 자녀생성자라는");
	}

	public Janyu() {

	}

	public void car() {
		System.out.println("차 있다");
	}
}

public class Super2 {

	public static void main(String[] args) {
		Boomo b1 = new Boomo();
		b1.don();
		// 아래 자녀 객체 j1 부모의 기본생성자로 객체 생성함
		Janyu j1 = new Janyu();
		j1.car();
		// 아래 자녀 객체 j2는 super로 명시된 int na2 파라미터의 부모생성자로 객체 생성함
		Janyu j2 = new Janyu("종로", 30);
		
		
	}

}
