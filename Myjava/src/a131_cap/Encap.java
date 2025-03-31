package a131_cap;

class Car {
	private String color;
	private int door;

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
		System.out.println("Color : " + color + "Doors : " + door);
	}
}

public class Encap {

	public static void main(String[] args) {
		Car mycar = new Car();
		mycar.setColor("black");
		mycar.setDoor(2);
		mycar.drive();

		Car mycar2 = new Car();
		mycar2.setColor("blue");
		mycar2.setDoor(4);
	}

}
