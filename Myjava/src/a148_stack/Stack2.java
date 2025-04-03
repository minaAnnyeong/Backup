package a148_stack;

import java.util.Stack;

public class Stack2 {

	public static void main(String[] args) {
//		Q) Stack에 음식이름 3개정도를 제네릭으로 넣고 
//		다시 꺼내어 출력하는 프로그램을 작성하시오.
		Stack<String> st1 = new Stack<String>();
		st1.push("카레");
		st1.push("볶음밥");
		st1.push("뚝불고기");
		System.out.println(st1.size());
		System.out.println(st1);
//		System.out.println(st1.pop());
//		System.out.println(st1.pop());
//		System.out.println(st1.pop());
		while(!st1.isEmpty()) { // underflow 방지
			System.out.println(st1.pop());
		}
	}

}
