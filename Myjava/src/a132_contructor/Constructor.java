package a132_contructor;

class Car {
	private String color;
	private int door;

	public Car(String color, int door) {
		super();
		this.color = color;
		this.door = door;
	}
//	기본 생성자

	public Car() {
	};

//	지정 사용자 생성자
	/*
	 * public Car(String color, int door) { this.color = color; this.door = door; }
	 */

	public void setColor(String color) {
		this.color = color;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public String getColor() {
		return color;
	}

	public int getDoor() {
		return door;
	}

	void drive() {
		System.out.println("Color : " + color + "\tDoors : " + door);
	}

}

class Bread {
	private String name;
	private int price;

	public Bread(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Bread() {
	};

	public void display() {
		System.out.println("빵: " + name + "\t가격: " + price);
	}

}

public class Constructor {

	public static void main(String[] args) {
		/*
		 * Car mycar = new Car(); mycar.setColor("black"); mycar.setDoor(2);
		 * mycar.drive();
		 * 
		 * Car mycar2 = new Car(); mycar2.setColor("blue"); mycar2.setDoor(4);
		 * mycar2.drive();
		 */
		
		Bread mybread = new Bread("pie", 3000);
		mybread.display();
		
		
	}

}
