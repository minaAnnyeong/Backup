package a134_obj_casting;

class Parent {

}

class Child extends Parent {

}

public class ObjCasting {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Child c1 = new Child();

		Parent p2 = c1;
//		부모쪽으로의 형변환 x
//		Child c5 = (Child)p1;
		
		
	}

}
