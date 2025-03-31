package a135_overriding;

class Parent {
	public void Car() {
		System.out.println("부모차타고 여행가자");
	}
}

class Child extends Parent {
	public void Car() {
		System.out.println("자녀차타고 여행가자");
	}
}

public class Overriding {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child();
		p1.Car();
		p2.Car();

	}

}
