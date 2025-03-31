package a135_overriding;

class Parent {
	String color;
	int door;

	public void Car() {
		System.out.println("부모차타고 여행가자");
	}
}

class Child extends Parent {
	public void Car() {
		System.out.println("자녀차타고 여행가자");
	}

}

class Car {
	protected String color;
	protected int door;

	public Car(String color, int door) {
		this.color = color;
		this.door = door;
	}

	public Car() {
	};

	public void drive() {
		System.out.println("드라이브 ㄱ");
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public String toString() {
		return "차 컬러는 " + color + " 이고 문 개수는 " + door + " 이구만";
	}

}

public class Overriding {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child();
		p1.Car();
		p2.Car();

		Car mycar = new Car("black", 2);
		
		mycar.toString();
	}

}
