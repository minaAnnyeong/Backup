package a139_shootinggame;

// thread 상속받은 클래스
class ThreadClass2 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "내가 쏘고있다는");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}
//		for-end
	}
//	run-end
}
//thread-end

// thread 상속받지 않은 클래스
class RunnableClass implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "네가 쏜다고?");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}
		
	}
}

public class Sgame {

	public static void main(String[] args) {
		ThreadClass2 tc2 = new ThreadClass2();
//		ThreadClass2 tc3 = new ThreadClass2();
		Thread tc3 = new Thread(new RunnableClass());
		tc2.start();
		tc3.start();
		System.out.println("나는 메인이야");
	}

}
