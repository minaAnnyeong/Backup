package a149_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {

	public static void main(String[] args) {
		Queue<String> q1 = new LinkedList<String>();
		q1.offer("babo");
		q1.offer("ondal");
		q1.offer("pyeonggang");
//		q1.poll();
//		q1.poll();
//		q1.offer("ondal2");
//		q1.offer("pyeonggang2");
		
		System.out.println(q1.size());
		// q.peek() << 제일 처음(들어간) 값을 반환
		System.out.println(q1.peek());
		while(!q1.isEmpty()) { // underflow 방지
			System.out.println(q1.poll());
		}
	}

}
