package a133_inheritance;

class Boomo {
	int diamond;

	public void don() {
		System.out.println("내 재산 많다는");
	}
}

class Janyu extends Boomo {
	public void Car() {
		diamond = 3;
		System.out.println("중형자동차 있다는");
	}
}

public class Inheritance {
	public static void main(String args[]) {
		Boomo b1 = new Boomo();
		b1.don();
		Janyu j1 = new Janyu();
		j1.don();
		j1.Car();
		System.out.println(j1.diamond);
		
		Boomo b2 = new Janyu();
		b2.don();
	}
}
