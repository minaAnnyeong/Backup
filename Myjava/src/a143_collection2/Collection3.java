package a143_collection2;

import java.util.ArrayList;

class Car {
	private String color;
	private int door;

	public Car(String color, int door) {
		super();
		this.color = color;
		this.door = door;
	}

	public Car() {
	}

	public String getColor() {
		return color;
	}

	public int getDoor() {
		return door;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	@Override
	public String toString() {
		return "자동차 색은 " + color + " 이고 문의 갯수는 " + door + " 개 라는";
	}

}

public class Collection3 {

	public static void main(String[] args) {
//		Q) 컬렉션을 사용하여 차를 판매한 전체 현황을 입력한 후 조건에따라 다양하게
//		출력하는 프로그램을 작성하시오. (단, db는 사용 안하며 컬렉션에는 객체가 저장되도록한다.)

		ArrayList<Car> alist = new ArrayList<Car>();
		alist.add(new Car("white", 4));
		alist.add(new Car("red", 2));
		alist.add(new Car("grey", 4));
		alist.add(new Car("black", 4));
		alist.add(new Car("violet", 2));
		alist.add(new Car("pink", 2));

//		전체 차가 팔린 현황을 출력하시오.
//		for (int i = 0; i < alist.size(); i++) {
//			System.out.println(alist.get(i));
//		}
		for (Car i : alist) {
			System.out.println(i);
		}

//		팔린 자동차의 자동차색에 대한 현황을 출력하시오.
//		단, toString()을 사용하지 마시오
		System.out.println("팔린 모든 자동차의 색상: ");
		for (Car i : alist) {
			System.out.println(i.getColor());
		}
		System.out.println();

//		차 문의 갯수가 4개인 것을 모구 출력하되 출력은 자동차 색과 문의 갯수를 보두 출력하시오.
//		단, toString()을 사용하지 않음
		System.out.println("문 개수가 4개인 모든 자동차: ");
		for (Car i : alist) {
			if (i.getDoor() == 4)
				System.out.println(i);

		}
		System.out.println();
		
//		자동차 색이 p로 시작하는 자동차의 색과 문개수를 출력하시오.
		System.out.println("자동차 색이 p로 시작하는 모든 자동차: ");
		for (Car i : alist) {
			// .startsWith(str) : str로 시작하는 문자열 검색 
			if (i.getColor().startsWith("p"))
				System.out.println(i);

		}
		System.out.println();
		
		

	}

}
